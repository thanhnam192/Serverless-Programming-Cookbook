package tech.heartin.books.serverlesscookbook.dto;




public class HandlerResponse {
    private String message;

    public HandlerResponse(){}
    public HandlerResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
