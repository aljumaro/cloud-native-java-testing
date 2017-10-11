package com.aljumaro.test.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JsonTest
public class UserTest {
	private User user;

	@Autowired
	private JacksonTester<User> json;

	@Before
	public void setUp() throws Exception {
		User user = User.builder().build();
		user.setId(0);
		user.setName("name");
		user.setEmail("email");

		this.user = user;
	}

	@Test
	public void deserializeJson() throws Exception {
		String content = "{\"id\": \"0\", \"name\": \"name\", " + "\"email\": \"email\"}";

		ObjectContent<User> parse = this.json.parse(content);
		User parseObject = this.json.parseObject(content);
		assertThat(parse).isEqualTo(this.user);
		assertThat(parseObject.getName()).isEqualTo("name");
	}

	@Test
	public void serializeJson() throws Exception {
		assertThat(this.json.write(user)).isEqualTo("user.json");
		assertThat(this.json.write(user)).isEqualToJson("user.json");
		assertThat(this.json.write(user)).hasJsonPathStringValue("@.name");

		assertJsonPropertyEquals("@.name", "name");
		assertJsonPropertyEquals("@.email", "email");
	}

	private void assertJsonPropertyEquals(String key, String value) throws java.io.IOException {
		assertThat(this.json.write(user)).extractingJsonPathStringValue(key).isEqualTo(value);
	}
}
