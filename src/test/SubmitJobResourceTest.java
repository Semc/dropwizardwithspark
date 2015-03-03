package test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.fest.assertions.api.Assertions.assertThat;
import io.dropwizard.testing.junit.ResourceTestRule;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import com.example.dropwizard.core.JobParameters;
import com.example.dropwizard.resources.SubmitJobResource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;

public class SubmitJobResourceTest {

	@ClassRule
	public static final ResourceTestRule resource = ResourceTestRule.builder()
			.addResource(new SubmitJobResource()).build();
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private final JobParameters parameters = new JobParameters(
			"my value of param 1");

	@Before
	public void setUp() {
	}

	@Test
	public void testJSONSerialize() throws JsonProcessingException, IOException {
		assertThat(MAPPER.writeValueAsString(parameters)).isEqualTo(
				fixture("fixtures/jobParameters.json"));
	}

	@Test
	public void testParseJSON() throws UniformInterfaceException, ClientHandlerException, JsonProcessingException {
		
		ClientResponse response = resource.client().resource("/submit-job")
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, MAPPER.writeValueAsString(parameters));
		
		assertThat(response.getStatus()).isEqualTo(201);
	}
}
