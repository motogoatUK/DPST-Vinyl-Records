package com.qa.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.qa.project.domain.Record;

	
	@Repository
	public interface RecordRepo extends JpaRepository<Record,Integer> {
		//custom queries go here
		
		@Query(value = "SELECT * FROM record WHERE spindle LIKE 'SS_SMALL'", nativeQuery = true)
		public abstract List<Record> getSmall();
		@Query(value = "SELECT * FROM record WHERE spindle LIKE 'SS_LARGE'", nativeQuery = true)
		public abstract List<Record> getLarge();
}
