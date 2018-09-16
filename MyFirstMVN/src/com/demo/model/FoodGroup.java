package com.demo.model;

public class FoodGroup {
	
	
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	public FoodGroup(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	/**
	 * 
	 */
	public FoodGroup() {
	
	}
	/**
	 * @param id
	 * @param name
	 * @param description]
	 */
	public FoodGroup(String name, String description) {
		this.name = name;
		this.description = description;
	}

	private int id;
	private String name;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String talkAboutYourSelf()
	{
		return "Food group name : "+name+"Food group description :"+description+"Food Group id : "+id;
	}

}
