package tech.heartin.books.serverlesscookbook;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import tech.heartin.books.serverlesscookbook.dto.HandlerRequest;
import tech.heartin.books.serverlesscookbook.dto.HandlerResponse;

public class MyLambdaHandler implements RequestHandler<HandlerRequest, HandlerResponse> {

    @Override
    public HandlerResponse handleRequest(HandlerRequest request, Context context) {
        String greeting = "";

        if (!isEmpty(request.getTime())) {
            greeting = "Good " + request.getTime() + ", ";
        } else {
            greeting = "Good Day, ";
        }

        if (!isEmpty(request.getName())) {
            greeting = greeting + request.getName();
        } else {
            greeting = greeting + "User";
        }

        context.getLogger().log(greeting);

        return new HandlerResponse(greeting);
    }

    private boolean isEmpty(final String str) {
        return (str == null || str.isEmpty());
    }
}
