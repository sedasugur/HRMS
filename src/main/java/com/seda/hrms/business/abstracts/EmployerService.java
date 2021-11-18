package com.seda.hrms.business.abstracts;

import java.util.List;

import com.seda.hrms.core.utilities.results.DataResult;
import com.seda.hrms.core.utilities.results.Result;
import com.seda.hrms.entities.concretes.Employer;

public interface EmployerService {
	public DataResult<List<Employer>> getAll();
	public Result add(Employer employer);
}
