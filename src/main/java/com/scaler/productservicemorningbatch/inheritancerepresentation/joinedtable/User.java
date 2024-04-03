package com.scaler.productservicemorningbatch.inheritancerepresentation.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "jt_users")
public class User {
    @Id
    private Long userId;
    private String name;
    private String email;
    private String password;
}
