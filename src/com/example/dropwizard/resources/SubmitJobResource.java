package com.example.dropwizard.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.example.dropwizard.core.JobParameters;
import com.example.dropwizard.core.SubmitJob;


@Path("submit-job")
@Produces(MediaType.APPLICATION_JSON)
public class SubmitJobResource {
	
	private AtomicLong counter;
	
	public SubmitJobResource() {
		this.counter = new AtomicLong();
	}
	
	@GET
	@Timed
	public Response doSubmitJob(JobParameters data){
		new SubmitJob(counter.incrementAndGet(), data).execute();
		return Response.serverError().build();
	}

}
