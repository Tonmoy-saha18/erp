package com.brainstation23.erp.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public class UserLoginRequest {
	@NotNull
	@Schema(description = "User email", example = "abc@gmail.com")
	private String email;

	@NotNull
	@Schema(description = "User password", example = "abc^720")
	private String password;
}
