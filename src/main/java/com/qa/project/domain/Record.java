package com.qa.project.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		private int recordId; // considered using Long (BIGINT) but int gives us  2,147,483,647 records,
						// which is more than enough for a personal collection given that there are
						// about 130,000,000 songs in the world (in 1200 years)
		@ManyToOne (cascade = CascadeType.ALL)
		@JoinColumn(name = "artistId")
		private Artist artist; // id of artist
		private String sideA,sideB; // contains song titles
		private String observation; // condition / notes (condition is a mySQL reserved word)
		@Enumerated(EnumType.STRING)
		private spindleSize spindle;
		private int  location; // id of location
		
//		public Record(Artist artist) {
//			this.artist= getArtistName(artist);
//			this.artist.setRecord((Set<Record>) this);	
//		}
}
