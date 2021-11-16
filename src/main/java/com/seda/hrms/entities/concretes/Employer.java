package com.seda.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.seda.hrms.entities.abstracts.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name= "user_id")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name= "phone_number")
	private String phoneNumber;
	
	@Column(name= "web_address")
	private String webAddress;
	
}
