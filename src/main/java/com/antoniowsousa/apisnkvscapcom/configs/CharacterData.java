package com.antoniowsousa.apisnkvscapcom.configs;

import static com.antoniowsousa.apisnkvscapcom.constants.CharacterConstant.ENDPOINT_DYNAMO;
import static com.antoniowsousa.apisnkvscapcom.constants.CharacterConstant.REGION_DYNAMO;

import org.springframework.stereotype.Component;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

@Component
public class CharacterData {
	
	public static void main (String[] args) throws Exception {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        
	    DynamoDB dynamoDB = new DynamoDB(client);

	    Table table = dynamoDB.getTable("tb_character");

	    Item character = new Item()
	    		.withPrimaryKey("id", "1")
	    		.withString("name", "Ryu")
	    		.withString("universe", "Capcom")
	    		.withNumber("games", 3);

	    Item character2 = new Item()
	    		.withPrimaryKey("id", "2")
	    		.withString("name", "Ken")
	    		.withString("universe", "Capcom")
	    		.withNumber("games", 3);

	    Item character3 = new Item()
	    		.withPrimaryKey("id", "3")
	    		.withString("name", "Kyo Kusanagi")
	    		.withString("universe", "SNK")
	    		.withNumber("games", 3);

	    PutItemOutcome outcome1 = table.putItem(character);
	    PutItemOutcome outcome2 = table.putItem(character2);
	    PutItemOutcome outcome3 = table.putItem(character3);
    }
}
