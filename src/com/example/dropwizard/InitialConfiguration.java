package com.example.dropwizard;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class InitialConfiguration extends Configuration {
	
	@NotEmpty
	private String hadoopHome;

	@JsonProperty
	public String getHadoopHome() {
		return hadoopHome;
	}

	@JsonProperty
	public void setHadoopHome(String hadoopHome) {
		this.hadoopHome = hadoopHome;
	}

}
