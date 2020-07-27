package com.hellokoding.account.repository;

import com.hellokoding.account.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualificationRepository extends JpaRepository<Qualification, Long>{

	Qualification findById(long id);
	
}
