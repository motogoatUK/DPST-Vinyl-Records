package com.qa.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qa.project.service.RecordService;
import com.qa.project.domain.Record;


@RestController
@RequestMapping("/record")
public class RecordController {
	@Autowired
private RecordService service;
public RecordController(RecordService service) {
	super();
	this.service = service;
}
// CRUD
// Create.
@PostMapping("/create")
public Record createRecord(@RequestBody Record info) {
	return this.service.create(info);
}
@PostMapping("/createMulti")
public List<Record> createMultiRecord(@RequestBody List<Record> info) {
	return this.service.createMulti(info);
}
// Read. readALL - get - list
@GetMapping("/list")
public List<Record> getRecord() {
	return new ArrayList<Record>(this.service.readAll());
}
@GetMapping("/list/small")
public List<Record> getSmallRecord() {
	return new ArrayList<Record>(this.service.small());
}
@GetMapping("/list/large")
public List<Record> getLargeRecord() {
	return new ArrayList<Record>(this.service.large());
}

// Update.
// Delete.
@DeleteMapping("/delete/{id}")
public boolean delete(@PathVariable int id) {
	return this.service.delete(id);
}
}
