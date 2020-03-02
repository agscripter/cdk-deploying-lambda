package com.agneresteves;

import software.amazon.awscdk.core.App;

public class CdkDeployingLambdaApp {

    public static void main(final String[] args) {
        App app = new App();

        new CdkDeployingLambdaStack(app, "CdkDeployingLambdaStack");

        app.synth();
    }

}
