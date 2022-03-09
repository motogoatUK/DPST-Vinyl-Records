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

@Override
public Record create(Record t) {
	// TODO Auto-generated method stub
	return null;
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
}
