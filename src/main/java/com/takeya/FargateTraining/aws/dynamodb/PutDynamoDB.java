package com.takeya.FargateTraining.aws.dynamodb;


import com.amazonaws.services.dynamodbv2.datamodeling.*;

import com.amazonaws.services.outposts.model.CatalogItem;
import com.takeya.FargateTraining.aws.dynamodb.config.DynamoDBConfig;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PutDynamoDB {

    private final DynamoDbClient client = DynamoDBConfig.createDynanmoDBClient();
    private final DynamoDBMapper mapper = DynamoDBConfig.createDynanmoDBMapper();

    public void put() {
        // software.amazon.awssdk


        // com.amazonaws
        CatalogItem item = new CatalogItem();
        item.setId(102);
        item.setTitle("Book 102 Title");
        item.setISBN("222-2222222222");
        item.setBookAuthors(new HashSet<String>(Arrays.asList("Author 1", "Author 2")));
        item.setSomeProp("Test");

        mapper.save(item);
    }

    @DynamoDBTable(tableName="ProductCatalog")
    public class CatalogItem {

        private Integer id;
        private String title;
        private String ISBN;
        private Set<String> bookAuthors;
        private String someProp;

        @DynamoDBHashKey(attributeName="Id")
        public Integer getId() { return id; }
        public void setId(Integer id) {this.id = id; }

        @DynamoDBAttribute(attributeName="Title")
        public String getTitle() {return title; }
        public void setTitle(String title) { this.title = title; }

        @DynamoDBAttribute(attributeName="ISBN")
        public String getISBN() { return ISBN; }
        public void setISBN(String ISBN) { this.ISBN = ISBN; }

        @DynamoDBAttribute(attributeName="Authors")
        public Set<String> getBookAuthors() { return bookAuthors; }
        public void setBookAuthors(Set<String> bookAuthors) { this.bookAuthors = bookAuthors; }

        @DynamoDBIgnore
        public String getSomeProp() { return someProp; }
        public void setSomeProp(String someProp) { this.someProp = someProp; }
    }
}
