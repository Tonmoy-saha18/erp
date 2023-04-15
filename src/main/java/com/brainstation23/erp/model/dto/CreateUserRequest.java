package com.brainstation23.erp.model.dto;

import com.brainstation23.erp.constant.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public class CreateUserRequest {
	@NotNull
	@Schema(description = "User First name", example = "Tonmoy")
	private String firstname;

	@NotNull
	@Schema(description = "User Last name", example = "Saha")
	private String lastName;

	@NotNull
	@Schema(description = "User Email", example = "abc@gmail.com")
	private String email;

	@NotNull
	@Schema(description = "User Password", example = "abc@^*")
	private String password;

	@NotNull
	@Schema(description = "User Salary", example = "1000.01")
	private Double salary;

	@NotNull
	@Schema(description = "User role", example = "EMPLOYEE")
	private UserRole role;
}
