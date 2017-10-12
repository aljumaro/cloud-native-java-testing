package com.aljumaro.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

@RunWith(SpringRunner.class)
@RestClientTest({ UserService.class })
@AutoConfigureWebClient(registerRestTemplate = true)
public class UserServiceTest {

	@Value("${user-service.host:user-service}")
	private String serviceHost;

	@Autowired
	private UserService userService;

	@Autowired
	private MockRestServiceServer server;

	@Test
	public void getAuthenticatedUserShouldReturnUser() {
		this.server.expect(requestTo(String.format("http://%s/uaa/v1/me", this.serviceHost))).andRespond(
				withSuccess(new ClassPathResource("com/aljumaro/test/service/user.json"), MediaType.APPLICATION_JSON));

		User user = userService.getAuthenticatedUser();

		assertThat(user.getName()).isEqualTo("name");
		assertThat(user.getEmail()).isEqualTo("email");
	}

}
