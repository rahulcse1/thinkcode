package com.tw.thinkcode;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class InterviewControllerTests {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MockMvc mockMvc;

	private MockRestServiceServer mockServer;

	@BeforeEach
	public void attachMockServer() {
		mockServer = MockRestServiceServer.bindTo(restTemplate).build();
	}

	@AfterEach
	public void verifyAndResetMockServer() {
		mockServer.verify();
		mockServer.reset();
	}

	@Test
	void resolvesExercise() throws Exception {
		mockServer.expect(method(HttpMethod.GET))
			.andExpect(requestTo("http://unit-test/api/320"))
			.andRespond(withSuccess("{\"a\":62,\"op\":\"+\",\"b\":14}\n", MediaType.APPLICATION_JSON));

		mockMvc.perform(get("/api/calculate/320"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.input").value(320))
			.andExpect(jsonPath("$.calculation").value("62 + 14 = 76"))
			.andExpect(jsonPath("$.result").value(76));
	}

}
