package opa.grpc;

import opa.SubscriptionCache;

public class OpaRequestObserver implements StreamObserver<OpaRequest> {

    private SubscriptionCache subscriptionCache;

    private StreamObserver<OpaResponse> responseObserver;

    public OpaRequestObserver(SubscriptionCache subscriptionCache, StreamObserver<OpaResponse> responseObserver) {
        this.subscriptionCache = subscriptionCache;
        this.responseObserver = responseObserver;
    }

    @Override
    public void onNext(OpaRequest item) {
        subscriptionCache.add(item.getPattern(), responseObserver);
    }

    @Override
    public void onError(Throwable error) {

    }

    @Override
    public void onComplete() {

    }
}
