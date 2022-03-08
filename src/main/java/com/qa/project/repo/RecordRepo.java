package com.qa.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class RecordRepo {
	
	@Repository
	public interface RecordsRepo extends JpaRepository<Record,Integer> {
		//custom queries go here
}
}
