package com.example.LogisticsWarehouse.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@DynamoDBTable(tableName="sh_testDB")
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class RaspberryPi {


    @DynamoDBHashKey(attributeName = "clientId")
    private String clientId;

    @DynamoDBRangeKey(attributeName = "timestamp")
    private Long timestamp;

//    @DynamoDBAttribute(attributeName = "payload")
//    public Map<String, String> payload;

    @DynamoDBAttribute(attributeName = "payload")
    @DynamoDBTyped(value = DynamoDBMapperFieldModel.DynamoDBAttributeType.M)
    private Map<String, String> payload;

//    @DynamoDBAttribute
//    @DynamoDBTypeConverted(converter = BodyTypeConverter.class)
//    private Map<String, Object> body;


//    @DynamoDBHashKey(attributeName = "user")
//    private Integer user;
//
//    @DynamoDBRangeKey(attributeName = "name")
//    private String name;




}

