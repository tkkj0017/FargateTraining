package com.takeya.FargateTraining.aws.dynamodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;

import java.net.URI;
import java.util.List;

@Service
public class CreateTableLocal {

     public void createTable(String tableName) throws Exception {
         DynamoDbClient client = DynamoDbClient.builder()
                 .region(Region.AP_NORTHEAST_1)
                 .endpointOverride(URI.create("http://localhost:8000"))
                 .build();

         final var request = CreateTableRequest.builder()
                 .tableName(tableName)
                 .keySchema(List.of(
                         KeySchemaElement.builder()
                                 .attributeName("id")
                                 .keyType("HASH")
                                 .build(),
                         KeySchemaElement.builder()
                                 .attributeName("name")
                                 .keyType("RANGE")
                                 .build()
                 ))
                 .attributeDefinitions(List.of(
                         AttributeDefinition.builder()
                                 .attributeName("id")
                                 .attributeType("S")
                                 .build(),
                         AttributeDefinition.builder()
                                 .attributeName("name")
                                 .attributeType("S")
                                 .build()
//                         AttributeDefinition.builder()
//                                 .attributeName("age")
//                                 .attributeType("N")
//                                 .build()
                 ))
                 .provisionedThroughput(ProvisionedThroughput.builder()
                         .readCapacityUnits(10L)
                         .writeCapacityUnits(10L)
                         .build())
                 .build();

         try {
             client.createTable(request);
             System.err.println("Success.");
         } catch (Exception e) {
             System.err.println("Failed.");
             System.err.println(e.getMessage());
         }
     }



}
