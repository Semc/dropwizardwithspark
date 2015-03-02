package test;

import io.dropwizard.testing.junit.ResourceTestRule;

import java.io.IOException;

import static io.dropwizard.testing.FixtureHelpers.*;
import static org.fest.assertions.api.Assertions.*;

import org.junit.ClassRule;
import org.junit.Test;

import com.example.dropwizard.core.JobParameters;
import com.example.dropwizard.core.SubmitJob;
import com.example.dropwizard.resources.SubmitJobResource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SubmitJobResourceTest {

	@ClassRule
	public static final ResourceTestRule resource = ResourceTestRule.builder().addResource(new SubmitJobResource()).build();
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private final JobParameters parameters = new JobParameters("my value of param 1");
	private final SubmitJob job = new SubmitJob(0, parameters);

	@Test
	public void testJSONSerialize() throws JsonProcessingException, IOException {
		assertThat(MAPPER.writeValueAsString(parameters)).isEqualTo(
				fixture("fixtures/jobParameters.json"));
	}

	@Test
	public void testGetJobParametersFromJSON() {
		assertThat(resource.client().resource("submit-job").get(SubmitJob.class)).isEqualTo(job);
	}

}
