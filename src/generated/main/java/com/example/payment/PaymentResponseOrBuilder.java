// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: payment.proto

package com.example.payment;

public interface PaymentResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PaymentResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Indicates if the payment was successful
   * </pre>
   *
   * <code>bool success = 1;</code>
   * @return The success.
   */
  boolean getSuccess();

  /**
   * <pre>
   * Message with details, e.g., payment confirmation
   * </pre>
   *
   * <code>string message = 2;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <pre>
   * Message with details, e.g., payment confirmation
   * </pre>
   *
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();
}
