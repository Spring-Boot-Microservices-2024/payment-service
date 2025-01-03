// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: payment.proto

package com.example.payment;

public final class PaymentProto {
  private PaymentProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PaymentRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PaymentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PaymentResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PaymentResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PaymentReturnRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PaymentReturnRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PaymentReturnResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PaymentReturnResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rpayment.proto\"m\n\016PaymentRequest\022\017\n\007use" +
      "r_id\030\001 \001(\003\022\020\n\010event_id\030\002 \001(\003\022\r\n\005price\030\003 " +
      "\001(\002\022\026\n\016payment_method\030\004 \001(\t\022\021\n\ttimestamp" +
      "\030\005 \001(\t\"3\n\017PaymentResponse\022\017\n\007success\030\001 \001" +
      "(\010\022\017\n\007message\030\002 \001(\t\"Q\n\024PaymentReturnRequ" +
      "est\022\022\n\npayment_id\030\001 \001(\003\022\022\n\nrefund_sum\030\002 " +
      "\001(\002\022\021\n\ttimestamp\030\003 \001(\t\"`\n\025PaymentReturnR" +
      "esponse\022\022\n\npayment_id\030\001 \001(\t\022\021\n\ttimestamp" +
      "\030\002 \001(\t\022\017\n\007message\030\003 \001(\t\022\017\n\007success\030\004 \001(\010" +
      "2\217\001\n\016PaymentService\0223\n\016ProcessPayment\022\017." +
      "PaymentRequest\032\020.PaymentResponse\022H\n\023Stre" +
      "amPaymentReturn\022\025.PaymentReturnRequest\032\026" +
      ".PaymentReturnResponse(\0010\001B%\n\023com.exampl" +
      "e.paymentB\014PaymentProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_PaymentRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PaymentRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PaymentRequest_descriptor,
        new java.lang.String[] { "UserId", "EventId", "Price", "PaymentMethod", "Timestamp", });
    internal_static_PaymentResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_PaymentResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PaymentResponse_descriptor,
        new java.lang.String[] { "Success", "Message", });
    internal_static_PaymentReturnRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_PaymentReturnRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PaymentReturnRequest_descriptor,
        new java.lang.String[] { "PaymentId", "RefundSum", "Timestamp", });
    internal_static_PaymentReturnResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_PaymentReturnResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PaymentReturnResponse_descriptor,
        new java.lang.String[] { "PaymentId", "Timestamp", "Message", "Success", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
