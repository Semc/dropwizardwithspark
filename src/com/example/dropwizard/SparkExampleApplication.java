package com.example.dropwizard;

import com.example.dropwizard.resources.SubmitJobResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SparkExampleApplication extends Application<InitialConfiguration> {

	public static void main(String[] args) throws Exception {
		new SparkExampleApplication().run(args);

	}
	
	@Override
	public String getName() {
		return "Dropwizard with Spark examlpe";
	}

	@Override
	public void initialize(Bootstrap<InitialConfiguration> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(InitialConfiguration configuration, Environment environment)
			throws Exception {
		final SubmitJobResource resource = new SubmitJobResource();
		environment.jersey().register(resource);
		
	}

}
