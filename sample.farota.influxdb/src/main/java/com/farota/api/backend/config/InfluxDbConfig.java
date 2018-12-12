package com.farota.api.backend.config;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfluxDbConfig {
	
	@Value("${spring.influx.url}")
	private String SERVER_ADDRESS;
	
	@Value("${spring.influx.user}")
	private String USERID;
	
	@Value("${spring.influx.password}")
	private String PASSWORD;

	
	@Bean
	public InfluxDB connectDatabase() {

		InfluxDB connection = InfluxDBFactory.connect(SERVER_ADDRESS, USERID, PASSWORD);

		return connection;

	}

}
