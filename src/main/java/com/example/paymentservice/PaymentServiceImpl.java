package com.example.paymentservice;

import com.example.payment.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;

import java.util.concurrent.ThreadLocalRandom;

@GrpcService
public class PaymentServiceImpl extends PaymentServiceGrpc.PaymentServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    // Unary RPC method to process a payment
    @Override
    @Secured("ROLE_AUTHORIZED")
    public void processPayment(PaymentRequest request, StreamObserver<PaymentResponse> responseObserver) {
        logger.info("Processing payment for userId: {}, eventId: {}, amount: {}",
                request.getUserId(), request.getEventId(), request.getPrice());

        // Simulate processing the payment
        boolean paymentSuccess = processPaymentLogic(request);

        if (!paymentSuccess) {
            throw new PaymentException("Payment failed");
        }

        PaymentResponse response = PaymentResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Payment successful!")
                .build();

        responseObserver.onNext(response);
        logger.info("Payment response sent for userId: {}, success: {}", request.getUserId(), paymentSuccess);
        responseObserver.onCompleted();
    }


    @Override
    @Secured("ROLE_AUTHORIZED")
    public StreamObserver<PaymentReturnRequest> streamPaymentReturn(StreamObserver<PaymentReturnResponse> responseObserver) {
        logger.info("Stream for payment return initiated.");

        return new StreamObserver<PaymentReturnRequest>() {

            @Override
            public void onNext(PaymentReturnRequest request) {
                logger.info("Received payment return request for paymentId: {}, refund amount: {}",
                        request.getPaymentId(), request.getRefundSum());

                boolean refundSuccess = processRefund(request);

                if (!refundSuccess) {
                    throw new PaymentException("Refund failed");
                }

                // Build the response for each payment return
                PaymentReturnResponse response = PaymentReturnResponse.newBuilder()
                        .setPaymentId(String.valueOf(request.getPaymentId()))
                        .setTimestamp(request.getTimestamp())
                        .setMessage("Refund initiated successfully.")
                        .setSuccess(true)
                        .build();

                logger.info("Sending refund response for paymentId: {}, success: {}", request.getPaymentId(), refundSuccess);
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                logger.error("Error in payment return stream: ", t);
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                logger.info("Payment return stream completed.");
                responseObserver.onCompleted();
            }
        };
    }

    private boolean processPaymentLogic(PaymentRequest request) {
        logger.info("Processing payment for userId: {} and eventId: {}", request.getUserId(), request.getEventId());
        return ThreadLocalRandom.current().nextBoolean();
    }

    private boolean processRefund(PaymentReturnRequest request) {
        logger.info("Processing refund for paymentId: {}, refund amount: {}", request.getPaymentId(), request.getRefundSum());
        return true;
    }
}
