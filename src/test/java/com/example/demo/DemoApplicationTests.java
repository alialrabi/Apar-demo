package com.example.demo;

import com.example.demo.rest.UserController;
import com.example.demo.rest.request.UserRequest;
import com.example.demo.rest.response.Response;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	@Test
	public void testCreateUser() {
		UserRequest userRequest = new UserRequest();

		Mockito.doNothing().when(userService).save(userRequest);

		ResponseEntity<Response> responseEntity = userController.createUser(userRequest);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("User saved successfully", responseEntity.getBody().getMessage());

		Mockito.verify(userService, Mockito.times(1)).save(userRequest);
	}


}
