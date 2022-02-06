package com.takeya.FargateTraining.aws.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.takeya.FargateTraining.aws.dynamodb.config.DynamoDBConfig;
import com.takeya.FargateTraining.aws.dynamodb.entity.SampleEntirty;
import org.springframework.beans.factory.annotation.Autowired;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class GetDynamoDB {

//    private final DynamoDbClient client = DynamoDBConfig.createDynanmoDBClient();
//    private final DynamoDBMapper mapper = DynamoDBConfig.createDynamoDBMapper();

    @Autowired
    private DynamoDbClient client;

    @Autowired
    private DynamoDBMapper mapper;

    public Object getItem(String table, String key) {
        // software.amazon.awssdk


        // ccom.amazonaws
        final var consistentReads = DynamoDBMapperConfig.builder()
                .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT).build();
        final var item = mapper.load(SampleEntirty.class, key, consistentReads);
        return item;
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
