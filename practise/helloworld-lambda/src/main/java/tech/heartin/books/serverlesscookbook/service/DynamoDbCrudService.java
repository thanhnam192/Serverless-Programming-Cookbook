package tech.heartin.books.serverlesscookbook.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import tech.heartin.books.serverlesscookbook.dto.DynamoDbCrudRequest;
import tech.heartin.books.serverlesscookbook.dto.DynamoDbCrudResponse;

public interface DynamoDbCrudService {
    DynamoDbCrudResponse createData(DynamoDbCrudRequest request);
    DynamoDbCrudResponse getData(DynamoDbCrudRequest request) throws JsonProcessingException;
}
