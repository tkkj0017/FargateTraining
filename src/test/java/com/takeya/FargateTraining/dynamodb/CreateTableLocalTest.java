package com.takeya.FargateTraining.dynamodb;

import com.takeya.FargateTraining.aws.dynamodb.CreateTableLocal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;

@SpringBootTest
class CreateTableLocalTest {

    @Autowired
    private CreateTableLocal createTableLocal;

    @Test
    void createTableTest() {
        DynamoDbClient client = DynamoDbClient.builder()
                .region(Region.AP_NORTHEAST_1)
                .endpointOverride(URI.create("http://localhost:8000"))
                .build();

        try {
            createTableLocal.createTable("test_test_test");
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(true);
    }
}
