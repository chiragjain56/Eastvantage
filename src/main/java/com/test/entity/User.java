package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userId;

	@NotNull
	@Column(name = "user_name")
	private String name;

	@Min(18)
	@Max(60)
	private Integer age;

	@Email(message = "Email is not valid")
	@Column(name = "email")
	private String email;

	@Column(name = "phone_no")
	@Pattern(regexp = "^\\d{10}$", message = "phone no is Invalid")
	private String phoneNumber;

}
