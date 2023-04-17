package com.brainstation23.erp.persistence.entity;

import com.brainstation23.erp.config.AuditableBase;
import com.brainstation23.erp.constant.EntityConstant;
import com.brainstation23.erp.constant.UserRole;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.UUID;
@Entity(name = EntityConstant.USER)
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends AuditableBase {
    @Id
    @Type(type = "uuid-char")
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Double salary;
    @Column(nullable = false, columnDefinition = "Varchar(45) default 'EMPLOYEE'")
    private UserRole role;
}
