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
	
	
	public void setid(int id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
}
