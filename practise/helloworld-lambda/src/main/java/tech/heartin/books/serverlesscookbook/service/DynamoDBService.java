package tech.heartin.books.serverlesscookbook.service;

import tech.heartin.books.serverlesscookbook.dto.DynamoDbRequest;
import tech.heartin.books.serverlesscookbook.dto.DynamoDbResponse;

public interface DynamoDBService {

    DynamoDbResponse createTable(DynamoDbRequest request);

}
