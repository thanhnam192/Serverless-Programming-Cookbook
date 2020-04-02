package tech.heartin.books.serverlesscookbook;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import tech.heartin.books.serverlesscookbook.dto.DynamoDbCrudRequest;
import tech.heartin.books.serverlesscookbook.dto.DynamoDbCrudResponse;
import tech.heartin.books.serverlesscookbook.service.DynamoDbCrudService;

public class MyDynamoDbCrudHandler implements RequestHandler<DynamoDbCrudRequest, DynamoDbCrudResponse> {

    @Override
    public DynamoDbCrudResponse handleRequest(DynamoDbCrudRequest dynamoDbCrudRequest, Context context) {
        DynamoDbCrudService crud =  new DynamoDbCrudImpl();
        if( dynamoDbCrudRequest.getType().equalsIgnoreCase("put") ){
            context.getLogger().log("Start to put item");

            return crud.createData(dynamoDbCrudRequest);


        } else if( dynamoDbCrudRequest.getType().equalsIgnoreCase("get") ){
            try {
                context.getLogger().log("Start to get item");
                return crud.getData(dynamoDbCrudRequest);
            } catch (JsonProcessingException e) {
                return new DynamoDbCrudResponse(null,
                        "Error - JsonProcessingException " + e.getMessage());
            }
        }

        throw new IllegalArgumentException("Wrong parameter");

    }
}
