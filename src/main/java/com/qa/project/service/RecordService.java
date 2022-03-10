package com.qa.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.qa.project.domain.Record;
import com.qa.project.repo.RecordRepo;

@Service
public class RecordService implements ServiceInterface<Record> {
	private RecordRepo repo;

	public RecordService(RecordRepo repo) {
		this.repo = repo;
	}

	public Record create(Record newRecord) {
		
		return this.repo.save(newRecord);
	}
	public List<Record> createMulti(List<Record> newRecords){
		for (Record records:newRecords) {
			this.repo.save(records);
			}
	return newRecords;
	}

	public List<Record> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Record readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Record update(int id, Record t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
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
