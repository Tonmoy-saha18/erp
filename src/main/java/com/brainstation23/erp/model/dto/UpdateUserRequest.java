package com.brainstation23.erp.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public class UpdateUserRequest {
	@NotNull
	@Schema(description = "User First name", example = "Tonmoy")
	private String firstname;

	@NotNull
	@Schema(description = "User Last name", example = "Saha")
	private String lastName;

	@NotNull
	@Schema(description = "User Salary", example = "1000.01")
	private Double salary;

	@NotNull
	@Schema(description = "User role", example = "Admin/Employee")
	private String role;
}
