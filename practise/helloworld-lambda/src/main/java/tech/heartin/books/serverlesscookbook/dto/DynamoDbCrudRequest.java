package tech.heartin.books.serverlesscookbook.dto;

import java.util.Map;

public class DynamoDbCrudRequest {
    private String tableName;
    private String partitionKey;
    private String sortKey;
    private String partitionKeyValue;
    private Integer sortKeyValue;
    private boolean waitForActive;
    private Map<String, String> stringData;
    private Map<String, Integer> integerData;
    private String type;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPartitionKey() {
        return partitionKey;
    }

    public void setPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public String getPartitionKeyValue() {
        return partitionKeyValue;
    }

    public void setPartitionKeyValue(String partitionKeyValue) {
        this.partitionKeyValue = partitionKeyValue;
    }

    public Integer getSortKeyValue() {
        return sortKeyValue;
    }

    public void setSortKeyValue(Integer sortKeyValue) {
        this.sortKeyValue = sortKeyValue;
    }

    public boolean isWaitForActive() {
        return waitForActive;
    }

    public void setWaitForActive(boolean waitForActive) {
        this.waitForActive = waitForActive;
    }

    public Map<String, String> getStringData() {
        return stringData;
    }

    public void setStringData(Map<String, String> stringData) {
        this.stringData = stringData;
    }

    public Map<String, Integer> getIntegerData() {
        return integerData;
    }

    public void setIntegerData(Map<String, Integer> integerData) {
        this.integerData = integerData;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
