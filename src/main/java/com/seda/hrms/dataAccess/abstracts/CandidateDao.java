package com.seda.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.seda.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	boolean existsCandidateByEmail(String email);
	boolean existsCandidateByIdentityNumber(String identityNumber);

}
