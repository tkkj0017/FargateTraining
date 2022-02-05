package com.takeya.FargateTraining.aws.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.fms.model.InternalErrorException;
import lombok.Data;
import lombok.Setter;

@DynamoDBDocument
@Setter
public class CommonItem implements CloneableItem {

    private String createdAt;
    private String updatedAt;

    @DynamoDBAttribute(attributeName = "created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @DynamoDBAttribute(attributeName = "updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch(CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
