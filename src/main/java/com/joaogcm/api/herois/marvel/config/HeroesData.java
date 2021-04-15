package com.joaogcm.api.herois.marvel.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.joaogcm.api.herois.marvel.constants.HeroesConstant.REGION_DYNAMO;
import static com.joaogcm.api.herois.marvel.constants.HeroesConstant.ENDPOINT_DYNAMO;;

public class HeroesData {

	public static void main(String[] args) {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO)).build();

		DynamoDB dynamoDB = new DynamoDB(client);

		Table table = dynamoDB.getTable("Heroes_Table");
		Item hero = new Item().withPrimaryKey("id", 1).withString("name", "Mulher Maravilha")
				.withString("universe", "DC Comics").withNumber("films", 3);

		PutItemOutcome outCome = table.putItem(hero);
	}
}