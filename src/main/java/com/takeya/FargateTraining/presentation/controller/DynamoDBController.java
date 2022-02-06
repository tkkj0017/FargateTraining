package com.takeya.FargateTraining.presentation.controller;

import com.takeya.FargateTraining.aws.dynamodb.GetDynamoDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dynamodb")
public class DynamoDBController {

    private GetDynamoDB getDynamoDB;

    @GetMapping("item")
    public Object getItem(@RequestParam String table, @RequestParam String key) {

        final var response = getDynamoDB.getItem(table, key);
        return response;
    }

    @GetMapping("/scan")
    public Object scan(String table, String value) {
        final var response = getDynamoDB.scan(table, value);
        return response;
    }

    @GetMapping("/scan/all")
    public Object scanAll() {
        final var response = getDynamoDB.scanAll();
        return response;
    }

    @GetMapping("scan/index")
    public Object scanIndex() {
        final var response = getDynamoDB.scanIndex();
        return response;
    }

    @GetMapping("query")
    public Object query(String table, String key1, String key2) {
        final var response = getDynamoDB.query(table, key1, key2);
        return response;
    }

    @GetMapping("query/index")
    public Object queryIndex() {
        final var response = getDynamoDB.queryIndex();
        return response;
    }
}
