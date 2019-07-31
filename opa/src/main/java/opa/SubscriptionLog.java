package opa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SubscriptionLog {

    private SubscriptionCache subscriptionCache;

    @Autowired
    public SubscriptionLog(SubscriptionCache subscriptionCache) {
        this.subscriptionCache = subscriptionCache;
    }

    @PostConstruct
    public void setUp() {
        Subscription subscription1 = new Subscription(subscriptionCache);
        Subscription subscription2 = new Subscription(subscriptionCache);
    }

    @PreDestroy
    public void destory() {

    }

}
