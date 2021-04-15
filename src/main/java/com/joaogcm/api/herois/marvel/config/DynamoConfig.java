package com.joaogcm.api.herois.marvel.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import org.springframework.util.StringUtils;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
public class DynamoConfig {

	@Value("${amazon.dynamodb.endpoint}")
	private String amazonDynamoDBEndPoint;

	@Value("${aws_access_key_id}")
	private String amazonAWSAccessKey;

	@Value("${aws_secret_access_key}")
	private String amazonAWSecretKey;

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());

		if (!StringUtils.isEmpty(amazonDynamoDBEndPoint)) {
			amazonDynamoDB.setEndpoint(amazonDynamoDBEndPoint);
		}

		return amazonDynamoDB;
	}

	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSecretKey);
	}
}