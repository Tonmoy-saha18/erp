package com.brainstation23.erp.service;

import com.brainstation23.erp.constant.UserRole;
import com.brainstation23.erp.exception.custom.custom.NotFoundException;
import com.brainstation23.erp.mapper.OrganizationMapper;
import com.brainstation23.erp.mapper.UserMapper;
import com.brainstation23.erp.model.domain.Organization;
import com.brainstation23.erp.model.domain.User;
import com.brainstation23.erp.model.dto.*;
import com.brainstation23.erp.persistence.entity.OrganizationEntity;
import com.brainstation23.erp.persistence.entity.UserEntity;
import com.brainstation23.erp.persistence.repository.OrganizationRepository;
import com.brainstation23.erp.persistence.repository.UserRepository;
import com.brainstation23.erp.util.JwtTokenUtils;
import com.brainstation23.erp.util.RandomUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
	public static final String USER_NOT_FOUND = "User Not Found";
	private static final String CREDENTIAL_MISMATCH = "Invalid Username or Password";
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final JwtTokenUtils jwtTokenUtils;

	public Page<User> getAll(Pageable pageable) {
		var entities = userRepository.findAll(pageable);
		return entities.map(userMapper::entityToDomain);
	}

	public User getOne(UUID id) {
		var entity = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));
		return userMapper.entityToDomain(entity);
	}

	public UUID createOne(CreateUserRequest createRequest) {
		var entity = new UserEntity();
		entity.setId(UUID.randomUUID())
				.setFirstName(createRequest.getFirstname())
				.setLastName(createRequest.getLastName())
				.setEmail(createRequest.getEmail())
				.setPassword((createRequest.getPassword()))
				.setSalary(createRequest.getSalary())
				.setRole(createRequest.getRole());
		var createdEntity = userRepository.save(entity);
		return createdEntity.getId();
	}

	public void updateOne(UUID id, UpdateUserRequest updateRequest) {
		var entity = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));
		entity.setFirstName(updateRequest.getFirstname());
		entity.setLastName(updateRequest.getLastName());
		entity.setSalary(updateRequest.getSalary());
		entity.setRole(updateRequest.getRole());
		userRepository.save(entity);
	}

	public void deleteOne(UUID id) {
		userRepository.deleteById(id);
	}
	public UUID createOne(UserSignUpRequest createRequest) {
		var entity = new UserEntity();
		entity.setId(UUID.randomUUID())
				.setFirstName(createRequest.getFirstname())
				.setLastName(createRequest.getLastName())
				.setEmail(createRequest.getEmail())
				.setPassword((createRequest.getPassword()))
				.setSalary(0.00)
				.setRole(UserRole.EMPLOYEE);
		var createdEntity = userRepository.save(entity);
		return createdEntity.getId();
	}

	public String authentication(String mail, String password) throws Exception{
		UserEntity userEntity = userRepository.findByEmail(mail)
				.orElseThrow(() -> new NotFoundException((USER_NOT_FOUND)));

		User user = userMapper.entityToDomain(userEntity);
		String jwtToken;
		if(userEntity.getPassword().equals(password)){
			jwtToken = jwtTokenUtils.generateJwtToken(user);
		}
		else {
			throw new Exception(CREDENTIAL_MISMATCH);
		}
		return jwtToken;
	}
}
