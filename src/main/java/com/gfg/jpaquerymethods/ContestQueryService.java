package com.gfg.jpaquerymethods;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("contestQueryService")
public class ContestQueryService {
	@Autowired

	private ContestRepositoryWithQuery contestRepositoryWithQuery;
	
	public void test() {
		// Save a new contest
		Contest geekContest = new Contest();
		geekContest.setContestName("PremierLeague");
		geekContest.setContestDescription("Inviting Geeks To submit articles in plenty");
		
		//contestRepositoryWithQuery.save(geekContest);
		
		Contest hackthoContest = new Contest();
		hackthoContest.setContestName("Hackathon");
		hackthoContest.setContestDescription("Coding Round Challenge");		
		//contestRepositoryWithQuery.save(hackthoContest);
		
		Optional<Contest> result = contestRepositoryWithQuery.findById(1L);
		result.ifPresent(contest -> System.out.println(contest));
		
		// Find contest by contest name
		List<Contest> contests = contestRepositoryWithQuery.findByContestName("Hackathon");
		contests.forEach(contest -> System.out.println("Searched for Hackathon.." + contest));
		
		// List all contests
		Iterable<Contest> iterator = contestRepositoryWithQuery.findAll();
		iterator.forEach(contest -> System.out.println(contest));
		
		// Count number of contest
		long countOfContest = contestRepositoryWithQuery.count();
		System.out.println("Number of contest held: " + countOfContest);
		
		//Positional based test
		System.out.println("..Positional based test..");
		Optional<Contest> result1 = contestRepositoryWithQuery.findByContestNameAndId("PremierLeague",6L);
		result1.ifPresent(contest -> System.out.println("Searched for PremierLeague.." + contest));
		
		//Named query test
		System.out.println("..Named query test..");
		Optional<Contest> namedQueryResult = contestRepositoryWithQuery.findByNamedParameter("PremierLeague",6L);
		namedQueryResult.ifPresent(contest -> System.out.println("Searched for PremierLeague.." + contest));		
		
		//Async way of testing
		System.out.println("..Async way of testing..");
		Future<Contest> resultAsync = contestRepositoryWithQuery.findContest1ById(6L);
		try {
			System.out.println("Async way of getting contestname.." + resultAsync.get().getContestName());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Future<Optional<Contest>> hackathonAsyncResult = contestRepositoryWithQuery.findContest2ById(7L);
		result.ifPresent(hackathonContest -> System.out.println(hackathonContest));
		
		Future<Contest> asyncContest = contestRepositoryWithQuery.findContestAsyncByContestName("Hackathon");
		try {
			System.out.println("contestname retrieval in async way .." + asyncContest.get().getContestName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Future<Optional<String>> contestDetails = contestRepositoryWithQuery.findContestById(10L);
		//contestDetails.ifPresent(hackathonContest -> System.out.println(hackathonContest));
		
		Future<String> contestString = contestRepositoryWithQuery.findContestAsyncById(10L);
		System.out.println(contestString);
	}
}
