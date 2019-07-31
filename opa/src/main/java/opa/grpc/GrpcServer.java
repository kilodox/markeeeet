package opa.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class GrpcServer {

    private Server server;

    @Autowired
    public GrpcServer(OpaService opaService) {
        server = ServerBuilder.forPort(8980)
                //.addService(opaService)
                .build();
    }

    @PostConstruct
    public void setUp() {
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
