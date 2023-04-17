package com.brainstation23.erp.controller.rest;


import com.brainstation23.erp.mapper.UserMapper;
import com.brainstation23.erp.model.dto.CreateUserRequest;
import com.brainstation23.erp.model.dto.UpdateUserRequest;
import com.brainstation23.erp.model.dto.UserResponse;
import com.brainstation23.erp.model.dto.UserSignUpRequest;
import com.brainstation23.erp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "Sign Up")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/signup")
public class UserSignUpRestController {
	private final UserService userService;
	@Operation(summary = "Sign up to become an employee")
	@PostMapping
	public ResponseEntity<Void> createOne(@RequestBody @Valid UserSignUpRequest createRequest) {
		log.info("Creating an User: {} ", createRequest);
		userService.createOne(createRequest); // overload the createOne method
		return ResponseEntity.ok().build();
	}
}
