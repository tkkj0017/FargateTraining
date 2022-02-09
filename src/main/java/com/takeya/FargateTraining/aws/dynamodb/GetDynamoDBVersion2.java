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

public class GetDynamoDBVersion2 {

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

    public Object scan(String table, String filter, Integer limit, Map<String, AttributeValue> filterKeyValue) {
        final var request = ScanRequest.builder()
                .tableName(table)
                .filterExpression(filter)
                .limit(limit)
                .expressionAttributeValues(filterKeyValue)
                .build();

        var scanResponse = client.scan(request);
        var items = scanResponse.items();

        while (scanResponse.hasLastEvaluatedKey() && limit - scanResponse.count() > 0) {
            limit -= scanResponse.count();
            var newItems = client.scan(request).items();
            items.addAll(newItems);
        }
        return items;
    }

    public Object scanAll(String table, Integer limit) {
        final var request = ScanRequest.builder()
                .tableName(table)
                .limit(limit)
                .build();
        var scanResponse = client.scan(request);
        var items = scanResponse.items();

        while (scanResponse.hasLastEvaluatedKey() && limit - scanResponse.count() > 0) {
            limit -= scanResponse.count();
            var newItems = client.scan(request).items();
            items.addAll(newItems);
        }
        return items;
    }

    public Object scanIndex(String table, Map<String, AttributeValue> filter, String index, Integer limit) {
        final var request = ScanRequest.builder()
                .tableName(table)
                .limit(limit)
                .indexName(index)
                .build();
        var scanResponse = client.scan(request);
        var items = scanResponse.items();

        while (scanResponse.hasLastEvaluatedKey() && limit - scanResponse.count() > 0) {
            limit -= scanResponse.count();
            var newItems = client.scan(request).items();
            items.addAll(newItems);
        }
        return items;
    }
}
