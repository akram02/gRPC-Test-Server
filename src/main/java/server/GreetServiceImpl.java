package server;

import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello " + name)
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
