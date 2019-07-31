package opa.grpc;

import opa.SubscriptionCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpaService {

    private SubscriptionCache subscriptionCache;

    @Autowired
    public OpaService(SubscriptionCache subscriptionCache) {
        this.subscriptionCache = subscriptionCache;
    }

    public StreamObserver<OpaRequest> getOpaResponses(StreamObserver<OpaResponse> responseObserver) {
        return new OpaRequestObserver(subscriptionCache, responseObserver);
    }

}
