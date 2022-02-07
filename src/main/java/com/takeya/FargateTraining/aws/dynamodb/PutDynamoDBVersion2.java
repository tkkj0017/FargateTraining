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
//        // Create a BatchWriteItemEnhancedRequest object
//        BatchWriteItemEnhancedRequest batchWriteItemEnhancedRequest =
//                BatchWriteItemEnhancedRequest.builder()
//                        .writeBatches(
//                                WriteBatch.builder(Customer.class)
//                                        .mappedTableResource(mappedTable)
//                                        .addPutItem(r -> r.item(record2))
//                                        .addPutItem(r -> r.item(record3))
//                                        .build())
//                        .build();
//
//        // Add these two items to the table
//        enhancedClient.batchWriteItem(batchWriteItemEnhancedRequest);
//        System.out.println("done");
//
//        } catch (DynamoDbException e) {
//            System.err.println(e.getMessage());
//            System.exit(1);
//        }
    }
}
