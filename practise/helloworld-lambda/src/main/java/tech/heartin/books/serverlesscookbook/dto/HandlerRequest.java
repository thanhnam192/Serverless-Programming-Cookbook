package tech.heartin.books.serverlesscookbook.dto;

import lombok.Data;


public class HandlerRequest {
    private String name;
    private String time;

    public HandlerRequest(){}

    public HandlerRequest(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
