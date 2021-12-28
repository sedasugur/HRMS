package com.seda.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.seda.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	@Query("FROM JobAdvertisement where status = true")
	List<JobAdvertisement> getAllActives();
	List<JobAdvertisement> getAllActivesSortedByDate(Sort by);
	List<JobAdvertisement> getByStatusAndCompany_CompanyName(boolean status, String companyName);
	JobAdvertisement getById(int id);
}
