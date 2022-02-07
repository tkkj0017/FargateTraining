package com.takeya.FargateTraining.aws.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.takeya.FargateTraining.aws.dynamodb.entity.Book;
import com.takeya.FargateTraining.aws.dynamodb.entity.SampleEntirty;
import org.springframework.beans.factory.annotation.Autowired;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetDynamoDBVersion2 {

    @Autowired
    private DynamoDBMapper mapper;

    @Autowired
    private DynamoDbClient client;

    public Object getItem(String table, String key) {
        return null;
    }

    public Object scan(String table, String value) {
        return null;
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
