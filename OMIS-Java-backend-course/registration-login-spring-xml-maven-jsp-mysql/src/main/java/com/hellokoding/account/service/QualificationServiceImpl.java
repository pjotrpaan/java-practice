package com.hellokoding.account.service;

import com.hellokoding.account.model.Qualification;
import com.hellokoding.account.repository.QualificationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QualificationServiceImpl implements QualificationService {
	
	@Autowired
    private QualificationRepository qualificationRepository;

	@Override
	public void save(Qualification qual) {
		qualificationRepository.save(qual);
	}

	@Override
	public Qualification findById(long id) {
		return qualificationRepository.getOne(id);
	}

	@Override
	public List<Qualification> getAllQualifications() {
		return qualificationRepository.findAll();
	}

	@Override
	public void delete(long id) {
		qualificationRepository.delete(id);
	}
    
}
