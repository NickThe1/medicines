package com.nick.software.medicines.account.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
public class Account extends BaseAuditEntity{

    @NotBlank(message = "must be filled in")
    @Column(unique = true, length = 100)
    private String username;

    @Email(message = "must be filled in")
    @Column(unique = true, length = 100)
    private String email;

    @NotBlank(message = "must be filled in")
    @Column(unique = true)
    private String password;

    @ElementCollection(targetClass = AccountType.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<AccountType> accountTypes;
}
