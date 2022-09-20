package com.gfg.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContestRepository extends CrudRepository<Contest, Long> {
	List<Contest> findByContestName(String contestName);
}
