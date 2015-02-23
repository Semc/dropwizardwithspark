package com.example.dropwizard;

import com.esotericsoftware.kryo.serializers.FieldSerializer.Optional;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmitJob {
	
	private long id;
	private String jobDescription;
	
	public SubmitJob(long id, String content) {
		this.id = id;
		this.jobDescription = content;
		System.out.println("Job submitted succesfully");
	}
	
	@JsonProperty
	public long getId(){
		return id;
	}
	
	@JsonProperty
	public String getContent(){
		return jobDescription;
	}

}
