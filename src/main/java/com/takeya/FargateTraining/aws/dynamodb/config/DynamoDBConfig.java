package com.takeya.FargateTraining.aws.dynamodb.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.PredefinedClientConfigurations;
import com.amazonaws.regions.Regions;
import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import java.net.URI;
import java.time.Duration;

@Configuration
public class DynamoDBConfig {

    @Bean
    public static DynamoDbClient createDynanmoDBVersion2() {

        final var overrideConfiguration = ClientOverrideConfiguration.builder()
                .apiCallTimeout(Duration.ofMillis(10000))
                .apiCallAttemptTimeout(Duration.ofMillis(10000))
                .build();

        final var httpClient = ApacheHttpClient.builder()
                .connectionTimeout(Duration.ofMillis(10000))
                .socketTimeout(Duration.ofMillis(10000))
                .maxConnections(3)
                .build();

        DynamoDbClient client = DynamoDbClient.builder()
                .overrideConfiguration(overrideConfiguration)
                .httpClient(httpClient)
                .endpointOverride(URI.create("http://localhost:8000"))
                // The region is meaningless for local DynamoDb but required for client builder validation
                .region(Region.AP_NORTHEAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("dummy-key", "dummy-secret")))
                .build();

        return client;
    }


}
