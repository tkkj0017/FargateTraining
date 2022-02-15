package com.takeya.FargateTraining.presentation.controller;

import com.takeya.FargateTraining.aws.dynamodb.CreateTableLocal;
import com.takeya.FargateTraining.aws.dynamodb.GetDynamoDBVersion1;
import com.takeya.FargateTraining.aws.dynamodb.GetDynamoDBVersion2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dynamodb")
public class DynamoDBController {

    @Autowired
    private GetDynamoDBVersion1 getDynamoDBVersion1;

    @Autowired
    private GetDynamoDBVersion2 getDynamoDBVersion2;

    @Autowired
    private CreateTableLocal createTableLocal;

    @GetMapping("item")
    public Object getItem(@RequestParam String table, @RequestParam String key) {

        final var response = getDynamoDBVersion1.getItem(table, key);
        return response;
    }

    @GetMapping("/scan")
    public Object scan(String table, String value) {
        final var response = getDynamoDBVersion1.scan(table, value);
        return response;
    }

    @GetMapping("/scan/all")
    public Object scanAll() {
        final var response = getDynamoDBVersion1.scanAll();
        return response;
    }

    @GetMapping("scan/index")
    public Object scanIndex() {
        final var response = getDynamoDBVersion1.scanIndex();
        return response;
    }

    @GetMapping("query")
    public Object query(String table, String key1, String key2) {
        final var response = getDynamoDBVersion1.query(table, key1, key2);
        return response;
    }

    @GetMapping("query/index")
    public Object queryIndex() {
        final var response = getDynamoDBVersion1.queryIndex();
        return response;
    }

    @GetMapping("create_table")
    public void createTable() throws Exception {
        createTableLocal.createTable();
    }
}
