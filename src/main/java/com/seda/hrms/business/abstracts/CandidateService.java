package com.seda.hrms.business.abstracts;

import java.util.List;

import com.seda.hrms.core.utilities.results.DataResult;
import com.seda.hrms.core.utilities.results.Result;
import com.seda.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	
	Result add(Candidate candidate);

}
