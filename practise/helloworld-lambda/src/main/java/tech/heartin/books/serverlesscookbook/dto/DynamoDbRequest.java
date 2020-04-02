package tech.heartin.books.serverlesscookbook.dto;

public class DynamoDbRequest {
    private String tableName;
    private String partitionKey;
    private String sortKey;
    private long readCapacityUnits;
    private long writeCapacityUnits;
    private boolean waitForActive;

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

    public long getReadCapacityUnits() {
        return readCapacityUnits;
    }

    public void setReadCapacityUnits(long readCapacityUnits) {
        this.readCapacityUnits = readCapacityUnits;
    }

    public long getWriteCapacityUnits() {
        return writeCapacityUnits;
    }

    public void setWriteCapacityUnits(long writeCapacityUnits) {
        this.writeCapacityUnits = writeCapacityUnits;
    }

    public boolean isWaitForActive() {
        return waitForActive;
    }

    public void setWaitForActive(boolean waitForActive) {
        this.waitForActive = waitForActive;
    }
}
