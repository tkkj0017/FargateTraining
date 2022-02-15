package com.takeya.FargateTraining.aws.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.takeya.FargateTraining.aws.dynamodb.config.DynamoDBConfig;
import com.takeya.FargateTraining.aws.dynamodb.entity.Book;
import com.takeya.FargateTraining.aws.dynamodb.entity.SampleEntirty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetDynamoDBVersion1 {

    @Autowired
    private DynamoDBMapper mapper;

    @Autowired
    private DynamoDbClient client;

    public Object getItem(String table, String key) {
        final var consistentReads = DynamoDBMapperConfig.builder()
                .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT).build();
        final var item = mapper.load(SampleEntirty.class, key, consistentReads);
        return item;
    }

    public Object scan(String table, String value) {
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withN(value));
        eav.put(":val2", new AttributeValue().withS(table));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("Price < :val1 and ProductCategory = :val2").withExpressionAttributeValues(eav);

        List<Book> scanResult = mapper.scan(Book.class, scanExpression);

        for (Book book : scanResult) {
            System.out.println(book);
        }

        return scanResult;
    }

    public Object scanAll() {
        return null;
    }

    public Object scanIndex() {
        return null;
    }

    public Object query(String table, String key1, String key2) {
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":v1",new AttributeValue().withS(key1));
        eav.put(":v2", new AttributeValue().withS(key2));
        eav.put(":v3", new AttributeValue().withS(table));

        DynamoDBQueryExpression<Book> queryExpression = new DynamoDBQueryExpression<Book>()
                .withKeyConditionExpression("CategoryId = :v1 and CategoryName= :v2")
                .withExpressionAttributeValues(eav);

        List<Book> queryResult = mapper.query(Book.class, queryExpression);

        for (Book book : queryResult) {
            System.out.println(book);
        }

        return queryResult;
    }

    public Object queryIndex() {
        return null;
    }
}
