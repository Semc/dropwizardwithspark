package com.example.dropwizard.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmitJob {
	
	private long id;
	private JobParameters data;
	
	public SubmitJob(long id, JobParameters data) {
		this.id = id;
		this.data = data;
	}
	
	@JsonProperty
	public long getId(){
		return id;
	}
	
	@JsonProperty
	public JobParameters getContent(){
		return data;
	}

	public void execute() {
		System.out.println(id);
		System.out.println(data.getParam1());
	}

}
