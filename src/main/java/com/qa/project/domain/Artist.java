package com.qa.project.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

class Artist {
	@Id //marks it as the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //makes it auto-increment
	private int artistId;

	private String artistName;
	
	@OneToMany (mappedBy = "artist")
	private Set<Record> record;
	
}
