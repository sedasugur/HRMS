package com.seda.hrms.business.abstracts;

import java.util.List;

import com.seda.hrms.core.utilities.results.DataResult;
import com.seda.hrms.core.utilities.results.Result;
import com.seda.hrms.entities.concretes.JobAdvertisement;
import com.seda.hrms.entities.concretes.JobPosition;

public interface JobAdvertisementService {
	
	public Result add(JobAdvertisement jobAdvertisement);
	public DataResult<List<JobAdvertisement>> getAllActives();
	public DataResult<List<JobAdvertisement>> getAllActivesSortedByDate();
	public DataResult<List<JobAdvertisement>> getAllActivesByCompanyName(String companyName);
	public Result setStatus(int id, boolean status);

}
