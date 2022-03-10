package com.qa.project.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Location {
	@Id // marks it as the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // makes it auto-increment
	private int locationId;
//	@Column(unique = true)
	
	private String locationName;
	@OneToMany (mappedBy = "location")
	@JsonIgnore
	private Set<Record> record;

}