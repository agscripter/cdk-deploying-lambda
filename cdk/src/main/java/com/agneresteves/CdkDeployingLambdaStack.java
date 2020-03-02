package com.agneresteves;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;

public class CdkDeployingLambdaStack extends Stack {

    public CdkDeployingLambdaStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public CdkDeployingLambdaStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        new MyLambdaStack(this, "MyLambdaStack");
    }

}
