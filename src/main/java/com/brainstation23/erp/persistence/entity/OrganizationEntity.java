package com.brainstation23.erp.persistence.entity;

import com.brainstation23.erp.config.AuditableBase;
import com.brainstation23.erp.constant.EntityConstant;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = EntityConstant.ORGANIZATION)
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationEntity extends AuditableBase {
	@Id
	@Type(type = "uuid-char")
	private UUID id;
	private String name;
	private String code;
}
