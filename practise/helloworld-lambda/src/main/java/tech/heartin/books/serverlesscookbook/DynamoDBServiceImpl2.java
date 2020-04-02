package tech.heartin.books.serverlesscookbook;

import java.util.Arrays;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import tech.heartin.books.serverlesscookbook.dto.DynamoDbRequest;
import tech.heartin.books.serverlesscookbook.dto.DynamoDbResponse;
import tech.heartin.books.serverlesscookbook.service.DynamoDBService;

/**
 * Implementation of DynamoDBService that use AmazonDynamoDB client.
 */
public class DynamoDBServiceImpl2 implements DynamoDBService {

    private final AmazonDynamoDB dynamoDBClient;

    public DynamoDBServiceImpl2() {
        this.dynamoDBClient = AmazonDynamoDBClientBuilder.defaultClient();
    }

    @Override
    public final DynamoDbResponse createTable(final DynamoDbRequest request) {

        final CreateTableRequest createTableRequest = new CreateTableRequest(
                Arrays.asList(
                        new AttributeDefinition(request.getPartitionKey(), ScalarAttributeType.S),
                        new AttributeDefinition(request.getSortKey(), ScalarAttributeType.N)),
                request.getTableName(),
                Arrays.asList(
                        new KeySchemaElement(request.getPartitionKey(), KeyType.HASH),
                        new KeySchemaElement(request.getSortKey(), KeyType.RANGE)),
                new ProvisionedThroughput(request.getReadCapacityUnits(), request.getWriteCapacityUnits()));

        TableUtils.createTableIfNotExists(this.dynamoDBClient, createTableRequest);

        try {
            TableUtils.waitUntilActive(this.dynamoDBClient, request.getTableName());
        } catch (final AmazonClientException | InterruptedException e) {
            return new DynamoDbResponse(null, "Failed in table active check in API version V2: " + e.getMessage());
        }

        return new DynamoDbResponse(request.getTableName() + " created with API version V2.", null);
    }
}
