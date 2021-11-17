package com.seda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seda.hrms.business.abstracts.EmployerService;
import com.seda.hrms.core.utilities.results.DataResult;
import com.seda.hrms.core.utilities.results.SuccessDataResult;
import com.seda.hrms.dataAccess.abstracts.EmployerDao;
import com.seda.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers are listed.");
	}
	

}
