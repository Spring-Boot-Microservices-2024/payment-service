package com.example.paymentservice;

import com.example.payment.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class PaymentServiceImpl extends PaymentServiceGrpc.PaymentServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    // Unary RPC method to process a payment
    @Override
    public void processPayment(PaymentRequest request, StreamObserver<PaymentResponse> responseObserver) {
        logger.info("Processing payment for userId: {}, eventId: {}, amount: {}",
                request.getUserId(), request.getEventId(), request.getPrice());

        // Simulate processing the payment
        boolean paymentSuccess = processPaymentLogic(request);  // You would call some logic to process the payment

        // Build the response
        PaymentResponse response = PaymentResponse.newBuilder()
                .setSuccess(paymentSuccess)
                .setMessage(paymentSuccess ? "Payment successful!" : "Payment failed!")
                .build();

        // Send the response
        responseObserver.onNext(response);
        logger.info("Payment response sent for userId: {}, success: {}", request.getUserId(), paymentSuccess);
        responseObserver.onCompleted();
    }

    // Bidirectional streaming RPC method to handle payment updates and cancellations
    @Override
    public StreamObserver<PaymentReturnRequest> streamPaymentReturn(StreamObserver<PaymentReturnResponse> responseObserver) {
        logger.info("Stream for payment return initiated.");

        // This will handle a stream of requests from the client and send responses back
        return new StreamObserver<PaymentReturnRequest>() {

            @Override
            public void onNext(PaymentReturnRequest request) {
                logger.info("Received payment return request for paymentId: {}, refund amount: {}",
                        request.getPaymentId(), request.getRefundSum());

                // Logic to process the payment return request, e.g., validate the payment ID, refund amount
                boolean refundSuccess = processRefund(request);  // You would call some logic to process the refund

                // Build the response for each payment return
                PaymentReturnResponse response = PaymentReturnResponse.newBuilder()
                        .setPaymentId(String.valueOf(request.getPaymentId()))
                        .setTimestamp(request.getTimestamp())
                        .setMessage(refundSuccess ? "Refund initiated successfully." : "Refund failed.")
                        .setSuccess(refundSuccess)
                        .build();

                // Send the response back to the client
                logger.info("Sending refund response for paymentId: {}, success: {}", request.getPaymentId(), refundSuccess);
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                logger.error("Error in payment return stream: ", t);
                // Handle error if something goes wrong in the stream
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                logger.info("Payment return stream completed.");
                // Once the client has finished sending requests, complete the response
                responseObserver.onCompleted();
            }
        };
    }

    // Simulated payment processing logic (you would replace this with real logic)
    private boolean processPaymentLogic(PaymentRequest request) {
        logger.info("Processing payment for userId: {} and eventId: {}", request.getUserId(), request.getEventId());
        // In a real scenario, you'd process the payment here (e.g., call to a payment gateway)
        return true; // Simulate success
    }

    // Simulated refund processing logic (you would replace this with real logic)
    private boolean processRefund(PaymentReturnRequest request) {
        logger.info("Processing refund for paymentId: {}, refund amount: {}", request.getPaymentId(), request.getRefundSum());
        // In a real scenario, you'd process the refund here (e.g., refund via payment gateway)
        return true; // Simulate success
    }
}
