package tech.heartin.books.serverlesscookbook.dto;

public class DynamoDbCrudResponse {
    private String message;
    private String errorMessage;

    public DynamoDbCrudResponse(){}

    public DynamoDbCrudResponse(String message, String errorMessage) {
        this.message = message;
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
