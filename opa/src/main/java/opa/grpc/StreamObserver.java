package opa.grpc;

public interface StreamObserver<T> {

    void onNext(T item);

    void onError(Throwable error);

    void onComplete();

}
