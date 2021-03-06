package com.agneresteves;

import org.jetbrains.annotations.NotNull;
import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Duration;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;

public class MyLambdaStack extends Construct {

    public MyLambdaStack(@NotNull Construct scope, @NotNull String id) {
        super(scope, id);

        Function handler = Function.Builder.create(this, "MyLambdaHandler")
                .code(Code.fromAsset("./lambda/target/lambda-0.1-jar-with-dependencies.jar"))
                .runtime(Runtime.JAVA_8)
                .timeout(Duration.seconds(200))
                .memorySize(512)
                .handler("com.agneresteves.lambda.MyHandler")
                .build();

        new SnsTopic(handler, this, "LambdaSnsTopic");
    }

}
