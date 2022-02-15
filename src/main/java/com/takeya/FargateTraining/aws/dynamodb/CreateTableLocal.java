package com.takeya.FargateTraining.aws.dynamodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Service
public class CreateTableLocal {

     public void createTable() throws Exception {
         DynamoDbClient client = DynamoDbClient.builder()
                 .region(Region.AP_NORTHEAST_1)
                 .endpointOverride(URI.create("http://localhost:8000"))
                 .build();

         String tableName = "test_table";

         // TODO
     }



}
