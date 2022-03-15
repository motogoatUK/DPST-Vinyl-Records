package com.qa.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

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
public ResponseEntity<Record> createRecord(@RequestBody Record info) {
	return new ResponseEntity<>(this.service.create(info), HttpStatus.CREATED);
}
@PostMapping("/createMulti")
public ResponseEntity<List<Record>> createMultiRecord(@RequestBody List<Record> info) {
	return new ResponseEntity<>(this.service.createMulti(info), HttpStatus.CREATED);
}
// Read. readALL - get - list
@GetMapping("/list")
public ResponseEntity<List<Record>> getRecord() {
	return new ResponseEntity<List<Record>>(this.service.readAll(), HttpStatus.OK);
}
@GetMapping("/id/{id}")
public ResponseEntity<Record> getById(@PathVariable int id) {
	return new ResponseEntity<>(this.service.readById(id), HttpStatus.OK);
}
@GetMapping("/list/small")
public ResponseEntity<List<Record>> getSmallRecord() {
	return new ResponseEntity<List<Record>>(this.service.small(), HttpStatus.OK);
}
@GetMapping("/list/large")
public ResponseEntity<List<Record>> getLargeRecord() {
	return new ResponseEntity<>(this.service.large(), HttpStatus.OK);
}

// Update. - put request
@PutMapping("/update/{id}")
public ResponseEntity<Record> updateRecord(@PathVariable int id, @RequestBody Record newInfo) {
	return new ResponseEntity<Record>(this.service.update(id, newInfo),HttpStatus.ACCEPTED);
}

// Delete.
@DeleteMapping("/delete/{id}")
public ResponseEntity<Boolean> delete(@PathVariable int id) {
	return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.OK);
}
}
