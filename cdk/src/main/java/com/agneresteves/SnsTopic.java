package com.agneresteves;

import org.jetbrains.annotations.NotNull;
import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.sns.Topic;
import software.amazon.awscdk.services.sns.subscriptions.LambdaSubscription;
import software.amazon.awscdk.services.sns.subscriptions.LambdaSubscriptionProps;

public class SnsTopic extends Topic {

    public SnsTopic(Function function, @NotNull Construct scope, @NotNull String id) {
        super(scope, id);

        this.addSubscription(new LambdaSubscription(function, LambdaSubscriptionProps.builder()
                .build()));
    }

}
