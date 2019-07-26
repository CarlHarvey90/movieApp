package com.movieDB.entity;

public enum SQL {
	
	STATEMENT_DETAILS("select * from movie_table");
	
	String value;
	
	SQL(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
