package com.seda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.seda.hrms.business.abstracts.CandidateService;
import com.seda.hrms.core.utilities.results.DataResult;
import com.seda.hrms.core.utilities.results.ErrorResult;
import com.seda.hrms.core.utilities.results.Result;
import com.seda.hrms.core.utilities.results.SuccessDataResult;
import com.seda.hrms.core.utilities.results.SuccessResult;
import com.seda.hrms.dataAccess.abstracts.CandidateDao;
import com.seda.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(), "Candidates are listed.");
	}

	@Override
	public Result add(Candidate candidate) {
		
		if(candidate.getEmail() ==null || candidate.getPassword() ==null || candidate.getPasswordAgain() == null || 
				candidate.getFirstName() == null|| candidate.getIdentityNumber() == null || candidate.getLastName() == null ||
				candidate.getYearOfBirth() == null || candidate.getType() ==null) {
			return new ErrorResult("All fields are required!");
		}
		else if(!candidate.getPassword().equals(candidate.getPasswordAgain())) {
			return new ErrorResult("The passwords you entered did not match!");		
		}
		else if (candidateDao.existsCandidateByEmail(candidate.getEmail())) {
			return new ErrorResult("This e-mail address is already in use!");
		}
		else if (candidateDao.existsCandidateByIdentityNumber(candidate.getIdentityNumber())) {
			return new ErrorResult("This identity number is already in use!");			
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate successfully added.");
	}

}
