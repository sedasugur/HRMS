package com.seda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seda.hrms.business.abstracts.EmployerService;
import com.seda.hrms.core.utilities.results.DataResult;
import com.seda.hrms.core.utilities.results.ErrorResult;
import com.seda.hrms.core.utilities.results.Result;
import com.seda.hrms.core.utilities.results.SuccessDataResult;
import com.seda.hrms.core.utilities.results.SuccessResult;
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

	@Override
	public Result add(Employer employer) {
		
		if(employer.getCompanyName() == null || employer.getEmail() == null || employer.getPassword() == null ||
				employer.getPasswordAgain() == null || employer.getPhoneNumber() == null || employer.getType() == null || employer.getWebAddress() == null) {
			return new ErrorResult("All fields are required!");
		}
		else if (employerDao.existsEmployerByEmail(employer.getEmail())) {
			return new ErrorResult("This e-mail address is already in use!");
		}
		
		this.employerDao.save(employer);
		return new SuccessResult("Employer successfully added.");
	}
	

}
