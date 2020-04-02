package tech.heartin.books.serverlesscookbook;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloWorldLambdaHandler implements RequestHandler<String,String> {
    @Override
    public String handleRequest(String s, Context context) {
        context.getLogger().log("input: " + s + "\n");
        String greeting = "Hello " + s;
        return greeting;
    }
}
