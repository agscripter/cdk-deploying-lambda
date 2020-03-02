package com.agneresteves.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Collections;
import java.util.Map;

public class MyHandler implements RequestHandler<Map<String, Object>, GatewayResponse> {

    @Override
    public GatewayResponse handleRequest(Map<String, Object> stringObjectMap, Context context) {
        Map<String, String> headers = Collections.singletonMap("Content-Type", "application/json");

        return new GatewayResponse("{}", headers, 200);
    }

}
