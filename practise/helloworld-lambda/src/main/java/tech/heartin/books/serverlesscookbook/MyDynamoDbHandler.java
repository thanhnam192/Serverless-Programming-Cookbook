package tech.heartin.books.serverlesscookbook;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import tech.heartin.books.serverlesscookbook.dto.DynamoDbRequest;
import tech.heartin.books.serverlesscookbook.dto.DynamoDbResponse;
import tech.heartin.books.serverlesscookbook.service.DynamoDBService;

public final class MyDynamoDbHandler implements RequestHandler<DynamoDbRequest, DynamoDbResponse> {

    private DynamoDBService service;

    /**
     * Handle request.
     *
     * @param request  - input to lambda handler
     * @param context - context object
     * @return greeting text
     */
    public DynamoDbResponse handleRequest(final DynamoDbRequest request, final Context context) {
        context.getLogger().log("Creating table " + request.getTableName());

        final String version = System.getenv("API_VERSION");
        if (version != null && version.equals("V2")) {
            service = new DynamoDBServiceImpl2();
        } else {
            service = new DynamoDBServiceImpl1();
        }
        return service.createTable(request);
    }
}
