package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;

public class GreetingClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub greetClient = GreeterGrpc.newBlockingStub(channel);

        long start = System.currentTimeMillis();
        for (int i = 1; i < 10000000; i++) {
            HelloRequest helloRequest = HelloRequest.newBuilder()
                    .setName("Akram")
                    .build();

            HelloReply reply = greetClient.sayHello(helloRequest);
            reply.getMessage();
            if (i%10000==0) {
                long now = System.currentTimeMillis();
                System.out.println("Time passed " + (now-start)/1000.0);
            }
        }
    }
}
