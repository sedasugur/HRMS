package com.seda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seda.hrms.business.abstracts.JobPositionService;
import com.seda.hrms.core.utilities.results.DataResult;
import com.seda.hrms.core.utilities.results.ErrorResult;
import com.seda.hrms.core.utilities.results.Result;
import com.seda.hrms.core.utilities.results.SuccessDataResult;
import com.seda.hrms.core.utilities.results.SuccessResult;
import com.seda.hrms.dataAccess.abstracts.JobPositionDao;
import com.seda.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public Result add(JobPosition jobPosition) {
		
		if(this.jobPositionDao.existsJobPositionByJobPositionName(jobPosition.getJobPositionName())) {
			return new ErrorResult("This job position has already been added!");
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Job position successfully added.");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Job positions are listed.");
	}

}
