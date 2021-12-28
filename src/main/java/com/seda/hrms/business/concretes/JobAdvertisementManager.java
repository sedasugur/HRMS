package com.seda.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.seda.hrms.business.abstracts.JobAdvertisementService;
import com.seda.hrms.core.utilities.results.DataResult;
import com.seda.hrms.core.utilities.results.Result;
import com.seda.hrms.core.utilities.results.SuccessDataResult;
import com.seda.hrms.core.utilities.results.SuccessResult;
import com.seda.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.seda.hrms.entities.concretes.JobAdvertisement;
import com.seda.hrms.entities.concretes.JobPosition;

import net.bytebuddy.asm.Advice.This;

public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement successfully added.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActives() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllActives(), "Active job advertisements are listed.");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActivesSortedByDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllActivesSortedByDate(Sort.by(Sort.Direction.DESC, "releaseDate")), "Active job advertisements are listed by creation date.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActivesByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByStatusAndCompany_CompanyName(true, companyName));
	}

	@Override
	public Result setStatus(int id, boolean status) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(id);
		jobAdvertisement.setStatus(status);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement status is changed.");
	}

}
