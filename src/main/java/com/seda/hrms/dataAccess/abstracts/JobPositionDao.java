package com.seda.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seda.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	boolean existsJobPositionByJobPositionName(String jobPositionName);
}
