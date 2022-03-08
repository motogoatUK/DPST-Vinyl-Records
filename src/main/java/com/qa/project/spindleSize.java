package com.qa.project;

public enum spindleSize {
SS_LARGE("1.5 inch"),SS_SMALL("9/32 inch");
	private final String ssize;
	
	spindleSize(String ssize) {
		this.ssize = ssize;
	}
	public String size() {	
		return ssize;
		}
	}
