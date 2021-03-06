package com.takeya.FargateTraining.aws.dynamodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

@Service
public class PutDynamoDBVersion2 {

    @Autowired
    private DynamoDbClient client;

    public void put(String table, Map<String, AttributeValue> item) {

        final var request = PutItemRequest.builder()
                .tableName(table)
                .item(item)
                .build();

        client.putItem(request);
    }
}
