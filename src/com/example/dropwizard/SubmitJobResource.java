package com.example.dropwizard;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;


@Path("submit-job")
@Produces(MediaType.APPLICATION_JSON)
public class SubmitJobResource {
	
	private final AtomicLong counter;
	
	public SubmitJobResource() {
		this.counter = new AtomicLong();
	}
	
	@GET
	@Timed
	public SubmitJob doSubmitJob(@QueryParam("args") String jobContent){
		return new SubmitJob(counter.incrementAndGet(), jobContent);
	}

}
