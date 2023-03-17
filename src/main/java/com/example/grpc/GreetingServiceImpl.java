package com.example.grpc;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        // HelloRequest has toString auto-generated.
        System.out.println(request);

        // You must use a builder to construct a new Protobuffer object
        GreetingServiceOuterClass.HelloResponse response1 = GreetingServiceOuterClass.HelloResponse.newBuilder()
                .setGreeting("Hello there, " + request.getName())
                .build();

        GreetingServiceOuterClass.HelloResponse response2 = GreetingServiceOuterClass.HelloResponse.newBuilder()
                .setGreeting("Hi Again there, " + request.getName())
                .build();

        GreetingServiceOuterClass.HelloResponse response3 = GreetingServiceOuterClass.HelloResponse.newBuilder()
                .setGreeting("Last one, " + request.getName())
                .build();

        // Use responseObserver to send a single response back
        responseObserver.onNext(response1);
        responseObserver.onNext(response2);
        responseObserver.onNext(response3);

        // When you are done, you must call onCompleted.
        responseObserver.onCompleted();
    }
}