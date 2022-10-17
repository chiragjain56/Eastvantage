package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "user_name")
    private String name;

	@Email(message = "Email is not valid")
    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private Integer phoneNumber;

    @Column(name = "app_id")
    private String appointmentId;

}
