package com.brainstation23.erp.model.dto;

import com.brainstation23.erp.constant.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@ToString
@Getter
@Setter
public class UserResponse {
	@Schema(description = "User ID", example = "3F41A301-25ED-4F0F-876F-7657BEABB00F")
	private UUID id;

	@Schema(description = "User FirstName", example = "Tonmoy")
	private String firstName;

	@Schema(description = "User LastName", example = "Saha")
	private String lastName;

	@Schema(description = "User email", example = "abc@gmail.com")
	private String email;

	@Schema(description = "User password", example = "abc^720")
	private String password;

	@Schema(description = "User Salary", example = "1000.01")
	private Double salary;

	@Schema(description = "User role", example = "EMPLOYEE")
	private UserRole role;
}
