package com.farota.api.backend.domain;

import java.sql.Timestamp;
import java.time.Instant;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import lombok.Data;

@Data
@Measurement(name = "test")
public class TestPOJO {

	@Column(name = "time")
	private Instant time;

	@Column(name = "site")
	private String site;

	@Column(name = "model_id")
	private String modelId;

	@Column(name = "serial")
	private String serial;

	@Column(name = "rssi")
	private String rssi;

	@Column(name = "cmd")
	private String cmd;

	@Column(name = "sendCmdTime")
	private Timestamp sendCmdTime;

	@Column(name = "execCmdTime")
	private Timestamp execCmdTime;

	@Column(name = "connTime")
	private Timestamp connTime;

	@Column(name = "retry")
	private Integer retry = 0;

	@Column(name = "ignore")
	private String ignore = "no";
}