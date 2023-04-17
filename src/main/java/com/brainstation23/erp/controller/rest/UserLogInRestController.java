package com.brainstation23.erp.controller.rest;


import com.brainstation23.erp.model.dto.UserLoginRequest;
import com.brainstation23.erp.model.dto.UserSignUpRequest;
import com.brainstation23.erp.service.UserService;
import com.brainstation23.erp.util.JwtTokenUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@Tag(name = "LogIn")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/login")
public class UserLogInRestController {
	private final UserService userService;

	@Operation(summary = "User Authentication")
	@PostMapping
	public ResponseEntity<String> login(@RequestBody UserLoginRequest loginRequest){
		log.info("Authenticating User: {} ", loginRequest.getEmail());
		log.info("User Password: {}", loginRequest.getPassword());
		try {
			String token = userService.authentication(loginRequest.getEmail(), loginRequest.getPassword());
			return ResponseEntity.ok(token);

		} catch (Exception e) {
			log.info("Exception: " + e);
			return ResponseEntity.badRequest().body("Invalid username or password");
		}
	}
}
