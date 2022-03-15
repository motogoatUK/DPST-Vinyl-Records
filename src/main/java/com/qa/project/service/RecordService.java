package com.qa.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.project.domain.Record;
import com.qa.project.repo.RecordRepo;

@Service
public class RecordService implements ServiceInterface<Record> {
	@Autowired
	private RecordRepo repo;
	public RecordService(RecordRepo repo) {
		this.repo = repo;
	}
	@Override
	public Record create(Record newRecord) {

		return this.repo.save(newRecord);
	}
	public List<Record> createMulti(List<Record> newRecords) {
		for (Record records : newRecords) {
			this.repo.save(records);
		}
		return newRecords;
	}
	@Override
	public List<Record> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Record readById(int id) {
		return this.repo.findById(id).get();
	}

// Update. commented lines for use when logger implemented
	// public String update(int id, Record newInfo) {
	@Override
	public Record update(int id, Record newInfo) {
		Record orig = this.repo.findById(id).get();
		// int countFlag = 0;
		if (newInfo.getArtist() != null) {
			orig.setArtist(newInfo.getArtist());
			// countFlag++;
		}
		if (newInfo.getSideA() != null) {
			orig.setSideA(newInfo.getSideA());
			// countFlag++;
		}
		if (newInfo.getSideB() != null) {
			orig.setSideB(newInfo.getSideB());
			// countFlag++;
		}
		if (newInfo.getObservation() != null) {
			orig.setObservation(newInfo.getObservation());
			// countFlag++;
		}
		if (newInfo.getSpindle() != null) {
			orig.setSpindle(newInfo.getSpindle());
			// countFlag++;
		}
		if (newInfo.getLocation() != null) {
			orig.setLocation(newInfo.getLocation());
			// countFlag++;
		}

		// Logger.info(countFlag+" fields updated in record #"+id);
		return this.repo.save(orig);
	}

//delete by Id
	@Override
	public boolean delete(int id) {
		try {
			this.repo.deleteById(id);
		} catch (Exception e) {
			//LOGGER.info("Record #"+id+" not deleted");
			return false;
		}
		return true;
	}

	// return list of records with small spindles
	public List<Record> small() {
		return this.repo.getSmall();
	}

	// return list of records with large spindles
	public List<Record> large() {
		return this.repo.getLarge();
	}
}
