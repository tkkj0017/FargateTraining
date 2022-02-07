package com.takeya.FargateTraining.aws.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.takeya.FargateTraining.aws.dynamodb.entity.Book;
import com.takeya.FargateTraining.aws.dynamodb.entity.SampleEntirty;
import org.springframework.beans.factory.annotation.Autowired;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

import java.util.*;
import java.util.stream.Collectors;

public class GetDynamoDBVersion2 {

    @Autowired
    private DynamoDBMapper mapper;

    @Autowired
    private DynamoDbClient client;

    public Object getItem(String table, Map<String, AttributeValue> key) {

        final var request = GetItemRequest.builder()
                .key(key)
                .tableName(table)
                .build();

        try {
            final var responseItem = client.getItem(request).item();

            if (responseItem != null) {
                Set<String> keys = responseItem.keySet();
                System.out.println("Amazon DynamoDB table attributes: \n");

                for (String key1 : keys) {
                    System.out.format("%s: %s\n", key1, responseItem.get(key1).toString());
                }
            } else {
                System.out.format("No item found with the key %s!\n", key);
            }
            return responseItem;
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return Optional.ofNullable(null);
    }

    public Object scan(String table, String value, String filter, Integer limit) {
        final var request = ScanRequest.builder()
                .tableName(table)
                .filterExpression(filter)
                .limit(limit)
                .build();

        var scanResponse = client.scan(request);
        var items = scanResponse.items();

        while (scanResponse.hasLastEvaluatedKey() && limit - scanResponse.count() > 0) {
            limit -= scanResponse.count();
            scanResponse = client.scan(request);

            // TODO
        }

    }

    public Object scanAll() {
        return null;
    }

    public Object scanIndex() {
        return null;
    }

    public Object query(String table, String key1, String key2) {
        return null;
    }

    public Object queryIndex() {
        return null;
    }
}
