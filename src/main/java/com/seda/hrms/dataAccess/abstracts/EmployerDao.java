package com.seda.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seda.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

}
