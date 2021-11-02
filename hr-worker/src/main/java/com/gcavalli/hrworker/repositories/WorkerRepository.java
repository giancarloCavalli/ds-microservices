package com.gcavalli.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcavalli.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
