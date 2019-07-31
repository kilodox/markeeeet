package opa;

import opa.grpc.OpaResponse;
import opa.grpc.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SubscriptionCache {

    private Map<String, List<StreamObserver<OpaResponse>>> cache;

    @Autowired
    public SubscriptionCache() {
        this.cache = new HashMap<>();
    }

    public synchronized void add(String pattern, StreamObserver<OpaResponse> responseObserver) {
        if (!cache.containsKey(pattern)) {
            cache.put(pattern, new ArrayList<>());
        }

        cache.get(pattern).add(responseObserver);
    }

    public synchronized void sendUpdate(Object object) {
        for (String pattern : cache.keySet()) {
            // Check pattern
            if (true) {
                for (StreamObserver<OpaResponse> responseObserver : cache.get(pattern)) {
                    // Create response
                    responseObserver.onNext(new OpaResponse());
                }
            }
        }
    }
}
