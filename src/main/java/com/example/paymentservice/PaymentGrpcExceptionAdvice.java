package com.example.paymentservice;

import io.grpc.Status;
import io.grpc.StatusException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class PaymentGrpcExceptionAdvice {
  @GrpcExceptionHandler(IllegalArgumentException.class)
  public StatusException handleInvalidArgument(IllegalArgumentException e) {
    return Status.INVALID_ARGUMENT.withDescription("Invalid argument: " + e.getMessage()).withCause(e).asException();
  }

  @GrpcExceptionHandler(PaymentException.class)
  public StatusException handlePaymentException(PaymentException e) {
    return Status.FAILED_PRECONDITION.withDescription("Payment processing error: " + e.getMessage()).withCause(e).asException();
  }

  @GrpcExceptionHandler(Exception.class)
  public StatusException handleGeneralException(Exception e) {
    return Status.UNKNOWN.withDescription("Unknown error occurred: " + e.getMessage()).withCause(e).asException();
  }
}
