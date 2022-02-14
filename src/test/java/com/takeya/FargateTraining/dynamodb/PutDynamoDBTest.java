package com.takeya.FargateTraining.dynamodb;

import com.takeya.FargateTraining.aws.dynamodb.PutDynamoDBVersion2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PutDynamoDBTest {

    @Autowired
    private PutDynamoDBVersion2 putDynamoDB;

    @Test
    void putTest() {
        String table_name = "test";
        Map<String, AttributeValue> key = new HashMap<String, AttributeValue>();
        key.put(":id", AttributeValue.builder().s("n-01").build());

        putDynamoDB.put(table_name, key);
    }
}
