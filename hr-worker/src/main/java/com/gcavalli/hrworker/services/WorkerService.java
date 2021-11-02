package com.gcavalli.hrworker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcavalli.hrworker.entities.Worker;
import com.gcavalli.hrworker.repositories.WorkerRepository;
import com.gcavalli.hrworker.services.exceptions.ResourceNotFoundException;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repo;
	
	public List<Worker> findAll() {
		return repo.findAll();
	}

	public Worker findById(Long id) {
		Optional<Worker> result = repo.findById(id);
		Worker entity = result.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return entity;
	}
	
}
