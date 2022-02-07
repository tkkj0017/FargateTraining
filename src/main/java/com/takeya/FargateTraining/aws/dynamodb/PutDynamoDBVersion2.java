package com.takeya.FargateTraining.aws.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.Arrays;
import java.util.HashSet;

public class PutDynamoDBVersion2 {

    @Autowired
    private DynamoDBMapper mapper;

    @Autowired
    private DynamoDbClient client;

    public void put() {

    }
}
