package tech.heartin.books.serverlesscookbook;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.heartin.books.serverlesscookbook.dto.DynamoDbCrudRequest;
import tech.heartin.books.serverlesscookbook.dto.DynamoDbCrudResponse;
import tech.heartin.books.serverlesscookbook.service.DynamoDbCrudService;

import java.util.HashMap;
import java.util.Map;

public class DynamoDbCrudImpl implements DynamoDbCrudService {
    private final DynamoDB dynamoDB;

    public DynamoDbCrudImpl() {
        final AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.defaultClient();
        this.dynamoDB = new DynamoDB(dynamoDBClient);
    }

    @Override
    public DynamoDbCrudResponse createData(DynamoDbCrudRequest request) {
        Table table = this.dynamoDB.getTable(request.getTableName());

        if (request.isWaitForActive()) {
            try {
                table.waitForActive();
            } catch (InterruptedException e) {
                return new DynamoDbCrudResponse(null,
                        "Error while waiting for table to become active  " + e.getMessage());
            }
        }

        Item item = new Item();
        item.withPrimaryKey(request.getPartitionKey(), request.getPartitionKeyValue(),
                            request.getSortKey(), request.getSortKeyValue());


        if( request.getStringData() != null ) {
            request.getStringData().forEach( (k,v) -> {
                item.withString(k,v);
            });
        }

        if( request.getIntegerData() != null ) {
            request.getIntegerData().forEach( (k,v) -> {
                item.withInt(k,v);
            });
        }

        table.putItem(item);

        return new DynamoDbCrudResponse("Item added into " + request.getTableName() + " with API version V1.", null);
    }

    @Override
    public DynamoDbCrudResponse getData(DynamoDbCrudRequest request) throws JsonProcessingException {
        Table table = this.dynamoDB.getTable(request.getTableName());

        if (request.isWaitForActive()) {
            try {
                table.waitForActive();
            } catch (InterruptedException e) {
                return new DynamoDbCrudResponse(null,
                        "Error while waiting for table to become active  " + e.getMessage());
            }
        }


        final Item item = table.getItem(request.getPartitionKey(), request.getPartitionKeyValue(), request.getSortKey(), request.getSortKeyValue());
        Map<String,Object> data = new HashMap<>();
        if(item != null){
            item.attributes().forEach( d -> {
                data.put(d.getKey(), d.getValue());
            });
        } else {
            return new DynamoDbCrudResponse("no data", null);
        }

        ObjectMapper mapper = new ObjectMapper();


        return new DynamoDbCrudResponse(mapper.writeValueAsString(data), null);
    }
}
