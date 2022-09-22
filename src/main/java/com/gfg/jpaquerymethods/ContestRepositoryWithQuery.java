package com.gfg.jpaquerymethods;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

public interface ContestRepositoryWithQuery extends CrudRepository<Contest, Long> {

    @Query("SELECT contest.contestName FROM Contest contest where contest.id = :id") 
    String findContestByIdString(@Param("id") Long id);
    
    @Query("SELECT contest.contestName FROM Contest contest where contest.contestName = :contestName") 
    String findContestByContestName(@Param("contestName") String contestName);
    
    List<Contest> findByContestName(String contestName);
    //Position based parameter binding
    //We cannot change the order of the method parameters
    //We cannot change the order of the placeholders without breaking our database query
    @Query("SELECT contest FROM Contest contest where contest.contestName = ?1 AND contest.id = ?2")
    public Optional<Contest> findByContestNameAndId(String contestName, Long id);
    
    //Named Parameter
    //The @Param annotation configures the name of the named parameter that is replaced with the value of the method parameter.
    //This will be more helpful than positional based
    @Query("SELECT contest FROM Contest contest where contest.contestName = :contestName AND contest.id = :id")
    public Optional<Contest> findByNamedParameter(@Param("contestName") String contestName, 
                                                    @Param("id") Long id);
     
   
    
    @Async
    Future<Contest> findContest1ById(Long id);
     
    @Async
    Future<Optional<Contest>> findContest2ById(Long id);
 
    @Async
    Future<Contest> findContestAsyncByContestName(String contestName);
     
    @Async
    Future<Stream<Contest>> findContestAsyncStreamByContestName(String contestName
    		);
	
	@Async
    @Query("SELECT contest.contestName FROM Contest contest where contest.id = :id") 
    Future<Optional<String>> findContestById(@Param("id") Long id);
	
	@Async
    @Query("SELECT contest.contestName FROM Contest contest where contest.id = :id") 
    Future<String> findContestAsyncById(@Param("id") Long id);
     
    
}
