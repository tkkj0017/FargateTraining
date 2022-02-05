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
    public Object scan() {
        final var response = getDynamoDB.scan();
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
    public Object query() {
        final var response = getDynamoDB.query();
        return response;
    }

    @GetMapping("query/index")
    public Object queryIndex() {
        final var response = getDynamoDB.queryIndex();
        return response;
    }
}
