package com.qa.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.qa.project.domain.Record;

@Repository
public interface RecordRepo extends JpaRepository<Record, Integer> {
	// custom queries go here

	@Query(value = "SELECT * FROM record WHERE spindle LIKE 'SS_SMALL'", nativeQuery = true)
	public abstract List<Record> getSmall();

	@Query(value = "SELECT * FROM record WHERE spindle LIKE 'SS_LARGE'", nativeQuery = true)
	public abstract List<Record> getLarge();

// For future implementation
//	@Query(value = "select rec.record_id, artist.artist_name, rec.sidea, rec.sideb, rec.spindle, rec.observation, loc.location_name from record rec join artist on rec.artist = artist.artist_id join location loc on rec.location = loc.location_id;")
//	public abstract List<Record> getFormattedList();

}
