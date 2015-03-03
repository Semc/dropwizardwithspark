package com.example.dropwizard.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

	@POST
	@Timed
	public Response doSubmitJob(JobParameters data) throws URISyntaxException {
		if (data != null) {
			new SubmitJob(counter.incrementAndGet(), data).execute();
			return Response.created(new URI("/")).build();
		}
		return Response.serverError().build();
	}

}
