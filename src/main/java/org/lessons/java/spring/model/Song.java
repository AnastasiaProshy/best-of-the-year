package org.lessons.java.spring.model;

public class Song 
{
	
	private Integer id;			 // Using Integer instead of int allows null values
	private String title;
	
	
	public Song (Integer id, String title)
	{
		this.id = id;
		this.title = title;
	}
	
	
	public int getId() {
		return this.id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return this.title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
}
