package org.lessons.java.spring.model;

public class Movie 
{
	
	private int id;
	private String title;
	
	
	public Movie (int id, String title)
	{
		this.id = id;
		this.title = title;
	}
	
	
	public int getid() {
		return id;
	}
	
