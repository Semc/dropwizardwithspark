package com.example.dropwizard.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobParameters {
	
	private String param1;

	public JobParameters(String param1) {
		this.param1 = param1;
	}

	@JsonProperty
	public String getParam1() {
		return param1;
	}

	@JsonProperty
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	
	
	
	

}
