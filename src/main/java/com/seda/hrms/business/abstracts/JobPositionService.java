package com.seda.hrms.business.abstracts;

import java.util.List;

import com.seda.hrms.core.utilities.results.DataResult;
import com.seda.hrms.core.utilities.results.Result;
import com.seda.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	public Result add(JobPosition jobPosition);
	public DataResult<List<JobPosition>> getAll();
}
