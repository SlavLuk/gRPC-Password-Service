package ie.gmit.ds;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: password.proto")
public final class UserPasswordServiceGrpc {

  private UserPasswordServiceGrpc() {}

  public static final String SERVICE_NAME = "ie.gmit.ds.UserPasswordService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ie.gmit.ds.UserRequest,
      ie.gmit.ds.UserResponse> getHashMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "hash",
      requestType = ie.gmit.ds.UserRequest.class,
      responseType = ie.gmit.ds.UserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.ds.UserRequest,
      ie.gmit.ds.UserResponse> getHashMethod() {
    io.grpc.MethodDescriptor<ie.gmit.ds.UserRequest, ie.gmit.ds.UserResponse> getHashMethod;
    if ((getHashMethod = UserPasswordServiceGrpc.getHashMethod) == null) {
      synchronized (UserPasswordServiceGrpc.class) {
        if ((getHashMethod = UserPasswordServiceGrpc.getHashMethod) == null) {
          UserPasswordServiceGrpc.getHashMethod = getHashMethod =
              io.grpc.MethodDescriptor.<ie.gmit.ds.UserRequest, ie.gmit.ds.UserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "hash"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.UserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.UserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserPasswordServiceMethodDescriptorSupplier("hash"))
              .build();
        }
      }
    }
    return getHashMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ie.gmit.ds.UserValidationRequest,
      com.google.protobuf.BoolValue> getValidateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "validate",
      requestType = ie.gmit.ds.UserValidationRequest.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.ds.UserValidationRequest,
      com.google.protobuf.BoolValue> getValidateMethod() {
    io.grpc.MethodDescriptor<ie.gmit.ds.UserValidationRequest, com.google.protobuf.BoolValue> getValidateMethod;
    if ((getValidateMethod = UserPasswordServiceGrpc.getValidateMethod) == null) {
      synchronized (UserPasswordServiceGrpc.class) {
        if ((getValidateMethod = UserPasswordServiceGrpc.getValidateMethod) == null) {
          UserPasswordServiceGrpc.getValidateMethod = getValidateMethod =
              io.grpc.MethodDescriptor.<ie.gmit.ds.UserValidationRequest, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "validate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.UserValidationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new UserPasswordServiceMethodDescriptorSupplier("validate"))
              .build();
        }
      }
    }
    return getValidateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserPasswordServiceStub newStub(io.grpc.Channel channel) {
    return new UserPasswordServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserPasswordServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserPasswordServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserPasswordServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserPasswordServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserPasswordServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void hash(ie.gmit.ds.UserRequest request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.UserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHashMethod(), responseObserver);
    }

    /**
     */
    public void validate(ie.gmit.ds.UserValidationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getValidateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHashMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.ds.UserRequest,
                ie.gmit.ds.UserResponse>(
                  this, METHODID_HASH)))
          .addMethod(
            getValidateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.ds.UserValidationRequest,
                com.google.protobuf.BoolValue>(
                  this, METHODID_VALIDATE)))
          .build();
    }
  }

  /**
   */
  public static final class UserPasswordServiceStub extends io.grpc.stub.AbstractStub<UserPasswordServiceStub> {
    private UserPasswordServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserPasswordServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserPasswordServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserPasswordServiceStub(channel, callOptions);
    }

    /**
     */
    public void hash(ie.gmit.ds.UserRequest request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.UserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHashMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validate(ie.gmit.ds.UserValidationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserPasswordServiceBlockingStub extends io.grpc.stub.AbstractStub<UserPasswordServiceBlockingStub> {
    private UserPasswordServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserPasswordServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserPasswordServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserPasswordServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ie.gmit.ds.UserResponse hash(ie.gmit.ds.UserRequest request) {
      return blockingUnaryCall(
          getChannel(), getHashMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue validate(ie.gmit.ds.UserValidationRequest request) {
      return blockingUnaryCall(
          getChannel(), getValidateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserPasswordServiceFutureStub extends io.grpc.stub.AbstractStub<UserPasswordServiceFutureStub> {
    private UserPasswordServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserPasswordServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserPasswordServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserPasswordServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.gmit.ds.UserResponse> hash(
        ie.gmit.ds.UserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHashMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> validate(
        ie.gmit.ds.UserValidationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HASH = 0;
  private static final int METHODID_VALIDATE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserPasswordServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserPasswordServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HASH:
          serviceImpl.hash((ie.gmit.ds.UserRequest) request,
              (io.grpc.stub.StreamObserver<ie.gmit.ds.UserResponse>) responseObserver);
          break;
        case METHODID_VALIDATE:
          serviceImpl.validate((ie.gmit.ds.UserValidationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserPasswordServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserPasswordServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ie.gmit.ds.Password.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserPasswordService");
    }
  }

  private static final class UserPasswordServiceFileDescriptorSupplier
      extends UserPasswordServiceBaseDescriptorSupplier {
    UserPasswordServiceFileDescriptorSupplier() {}
  }

  private static final class UserPasswordServiceMethodDescriptorSupplier
      extends UserPasswordServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserPasswordServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserPasswordServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserPasswordServiceFileDescriptorSupplier())
              .addMethod(getHashMethod())
              .addMethod(getValidateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
