package com.farota.api.backend.influx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farota.api.backend.domain.TestPOJO;

@Service
public class InfluxService {
	
	
	@Autowired
	InfluxComponent influxComponent;
	
	
	public void testInsert(TestPOJO test){
		
		String dbName = "testdb";
		String measurement = "test";
		
		influxComponent.insertLog(dbName, measurement, test);
		
		
		
	}
	
	
	

}
