package com.agneresteves;

import org.jetbrains.annotations.NotNull;
import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.services.apigateway.LambdaIntegration;
import software.amazon.awscdk.services.apigateway.RestApi;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.s3.Bucket;

import java.util.Collections;

public class WidgetService extends Construct {

    public WidgetService(@NotNull Construct scope, @NotNull String id) {
        super(scope, id);

        Bucket bucket = new Bucket(this, "WidgetStore");

        Function handler = Function.Builder.create(this, "WidgetHandler")
                .runtime(Runtime.NODEJS_10_X)
                .code(Code.fromAsset("src/main/resources"))
                .handler("widgets.main")
                .environment(Collections.singletonMap("BUCKET", bucket.getBucketName()))
                .build();

        bucket.grantReadWrite(handler);

        RestApi api = RestApi.Builder.create(this, "Widgets-API")
                .restApiName("Widget Service").description("This service services widgets")
                .build();

//        LambdaIntegration getWidgetsIntegration = LambdaIntegration.Builder.create(handler)
//                .requestTemplates(Collections.singletonMap("application/json", "{\"statusCode\": \"200\"}"))
//                .build();

        LambdaIntegration postWidgetIntegration = new LambdaIntegration(handler);

        LambdaIntegration getWidgetIntegration = new LambdaIntegration(handler);

        LambdaIntegration deleteWidgetIntegration = new LambdaIntegration(handler);

        api.getRoot().addMethod("POST", postWidgetIntegration);
        api.getRoot().addMethod("GET", getWidgetIntegration);
        api.getRoot().addMethod("DELETE", deleteWidgetIntegration);
    }

}
