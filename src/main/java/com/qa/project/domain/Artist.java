package com.qa.project.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Artist {
	@Id //marks it as the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //makes it auto-increment
	private int artistId;
	//@Column(unique = true)
	private String artistName;
	
	@OneToMany (mappedBy = "artist")
	@JsonIgnore
	//@JsonManagedReference(value="artist")
	private Set<Record> artist = new HashSet<>();
	
}
