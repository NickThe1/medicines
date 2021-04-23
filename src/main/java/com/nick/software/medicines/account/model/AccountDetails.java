package com.nick.software.medicines.account.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@Entity
public class AccountDetails extends BaseAuditEntity{

    @NotBlank(message = "must be filled in")
    private String firstname;

    @NotBlank(message = "must be filled in")
    private String lastname;

    @NotBlank(message = "must be filled in")
    private String middlename;

    @NotBlank(message = "must be filled in")
    private String resume;

    @Min(value = 0)
    private BigDecimal amount;

    @OneToOne()
    private Account account;
}
