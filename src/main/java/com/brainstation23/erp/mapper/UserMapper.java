package com.brainstation23.erp.mapper;

import com.brainstation23.erp.model.domain.Organization;
import com.brainstation23.erp.model.domain.User;
import com.brainstation23.erp.model.dto.OrganizationResponse;
import com.brainstation23.erp.model.dto.UserResponse;
import com.brainstation23.erp.persistence.entity.OrganizationEntity;
import com.brainstation23.erp.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
	User entityToDomain(UserEntity userEntity);

	UserResponse domainToResponse(User user);
}
