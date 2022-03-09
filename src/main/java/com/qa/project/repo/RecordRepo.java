package com.qa.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.project.domain.Record;
	
	@Repository
	public interface RecordRepo extends JpaRepository<Record,Integer> {
		//custom queries go here

}
