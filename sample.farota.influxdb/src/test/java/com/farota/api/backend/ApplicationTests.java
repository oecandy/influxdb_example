package com.farota.api.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.farota.api.backend.config.InfluxDbConfig;
import com.farota.api.backend.domain.TestPOJO;
import com.farota.api.backend.influx.InfluxComponent;
import com.farota.api.backend.influx.InfluxService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {InfluxDbConfig.class,InfluxService.class,InfluxComponent.class})
public class ApplicationTests {

	@Autowired
	private InfluxService InfluxService;
	
	
	
	
	@Test
	public void contextLoads() {
		TestPOJO test = new TestPOJO();
		test.setSite("12");
		test.setSerial("2313123");
		test.setModelId("asdasd");
		test.setRssi("-2222");
		test.setCmd("open");
		test.setRetry(1);
		test.setIgnore("yes");
		
		
		
		InfluxService.testInsert(test);
	}

}
