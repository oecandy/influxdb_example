package com.farota.api.backend.influx;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farota.api.backend.config.InfluxDbConfig;
import com.farota.api.backend.domain.TestPOJO;

/**
 * @author JunYoung
 *
 */
@Component
public class InfluxComponent {

	@Autowired
	private InfluxDbConfig influxDB;
	
	/**
	 * @param connection
	 * @param query
	 * @param dbName
	 * @return
	 */
	private QueryResult runQuery(InfluxDB connection, String query, String dbName) {
		
		// Run the query
		Query queryObject = new Query(query, dbName);
		QueryResult queryResult = connection.query(queryObject);
		
		return queryResult;
		
	}

	/**
	 * @param query
	 * @param dbName
	 * @return
	 */
	public List<TestPOJO> getPoints(String query, String dbName) {
		
		InfluxDB connection = influxDB.connectDatabase();
		
		QueryResult queryResult = this.runQuery(connection, query, dbName);
		// Map it
		InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
		
		connection.close();
		return resultMapper.toPOJO(queryResult, TestPOJO.class);// pojo로 리턴
	}
	
	/**
	 * @param dbName
	 * @param measurement
	 * @param test
	 */
	public void insertLog(String dbName, String measurement, TestPOJO test){

		InfluxDB connection = influxDB.connectDatabase();

		Point point = Point.measurement(measurement).time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
				.addField("site", test.getSite())
				.addField("model_id", test.getModelId())
				.addField("serial", test.getSerial())
				.addField("rssi", test.getRssi())
				.addField("cmd", test.getCmd())
				.addField("ignore", test.getIgnore()).build();
		
		connection.write(dbName, null, point);
		
		/*String query = "SELECT * FROM " + measurement;
		
		List<TestPOJO> memoryPointList = getPoints(query, dbName);

		System.out.println(memoryPointList);*/

		connection.close();
	}

}
