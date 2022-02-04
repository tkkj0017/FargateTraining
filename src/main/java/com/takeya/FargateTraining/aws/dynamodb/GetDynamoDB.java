package com.takeya.FargateTraining.aws.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.takeya.FargateTraining.aws.dynamodb.config.DynamoDBConfig;
import org.springframework.web.bind.annotation.GetMapping;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class GetDynamoDB {

    private final DynamoDbClient client = DynamoDBConfig.createDynanmoDBClient();
    private final DynamoDBMapper mapper = DynamoDBConfig.createDynanmoDBMapper();

    public Object getItem() {
        // software.amazon.awssdk


        // ccom.amazonaws
        return null;
    }

    public Object scan() {
        return null;
    }

    public Object scanAll() {
        return null;
    }

    public Object scanIndex() {
        return null;
    }

    public Object query() {
        return null;
    }

    public Object queryIndex() {
        return null;
    }
}
