package com.gfg.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("contestService")
public class ContestService {
	@Autowired
	private ContestRepository contestRepository;
	
	public void test() {
		// Save a new contest
		Contest geekContest = new Contest();
		geekContest.setContestName("PremierLeague");
		geekContest.setContestDescription("Inviting Geeks To submit articles in plenty");
		
		contestRepository.save(geekContest);
		
		// Find a contest by ID
		Optional<Contest> result = contestRepository.findById(1L);
		result.ifPresent(contest -> System.out.println(contest));
		
		// Find contest by contest name
		List<Contest> contests = contestRepository.findByContestName("PremierLeague");
		contests.forEach(contest -> System.out.println(contest));
		
		// List all contests
		Iterable<Contest> iterator = contestRepository.findAll();
		iterator.forEach(contest -> System.out.println(contest));
		
		// Count number of contest
		long countOfContest = contestRepository.count();
		System.out.println("Number of contest held: " + countOfContest);
	}
}
