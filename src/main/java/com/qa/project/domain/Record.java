package com.qa.project.domain;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.qa.project.spindleSize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Record {
// Declare variables
	//columns for the the table
	
		@Id //marks it as the primary key
		@GeneratedValue(strategy = GenerationType.IDENTITY) //makes it auto-increment
		private int id; // considered using Long (BIGINT) but int gives us  2,147,483,647 records,
						// which is more than enough for a personal collection given that there are
						// about 130,000,000 songs in the world (in 1200 years) 
		private int sideA,sideB; // contains id of song
		private String condition;
		private spindleSize spindle;
		
}
