package com.qa.project.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.qa.project.spindleSize;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.qa.project.spindleSize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility =Visibility.ANY)
public class Record {
// Declare variables
	//columns for the the table
	
		@Id //marks it as the primary key
		@GeneratedValue(strategy = GenerationType.IDENTITY) //makes it auto-increment

		private int recordId; // considered using Long (BIGINT) but int gives us  2,147,483,647 records,
		                      // which is more than enough for a personal collection given that there are only 
		                      // about 130,000,000 songs in the world (in 1200 years)
		@ManyToOne (cascade= {CascadeType.PERSIST,CascadeType.MERGE})
		@JoinColumn(name = "artist") // foreign key -> artistId
		//@JsonBackReference(value="artist")
		private Artist artist; // The record's artist
		private String sideA,sideB; // contains song titles
		private String observation; // condition (observation - condition is a mySQL reserved word)
		@Enumerated(EnumType.STRING)
		private spindleSize spindle;
		@ManyToOne (cascade= {CascadeType.PERSIST,CascadeType.MERGE})
		@JoinColumn(name = "location") // foreign key -> locationId
		//@JsonBackReference(value="location")
		private Location location; // The record's location

		
}
