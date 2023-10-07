package com.example.LogisticsWarehouse.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.example.LogisticsWarehouse.entity.RaspberryPi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaspberryPiService {

    private final AmazonDynamoDBClient amazonDynamoDBClient;

    @Autowired
    public RaspberryPiService(AmazonDynamoDBClient amazonDynamoDBClient) {
        this.amazonDynamoDBClient = amazonDynamoDBClient;
    }

//    public void createItem(){
//        RaspberryPi raspberryPi = new RaspberryPi("raspberrypi", 1696335706074L, "test");
//
//        // Save Lyric To DynamoDB
//        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDBClient);
//        mapper.save(raspberryPi);
//
//    }

    public RaspberryPi findItem(){

        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDBClient);
        RaspberryPi raspberryPi = mapper.load(RaspberryPi.class, "raspberrypi", 1696652873367L);
//        System.out.println(raspberryPi.getPayload().get("stationDecision"));
        return raspberryPi;
    }

    public List<RaspberryPi> findAllItem(){

        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDBClient);
        return mapper.scan(RaspberryPi.class, new DynamoDBScanExpression());
    }

    public RaspberryPi finaLastItem(){
        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDBClient);
        List<RaspberryPi> raspberryPis = mapper.scan(RaspberryPi.class, new DynamoDBScanExpression());
        return raspberryPis.get(raspberryPis.size() - 1);


    }


}
