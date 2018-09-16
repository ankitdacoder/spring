package main;

public class Fruit {
	
	private String myName;
	private String myDefination;
	public String getMyDefination() {
		return myDefination;
	}

	public void setMyDefination(String myDefination) {
		this.myDefination = myDefination;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public Fruit(){}//no argument constructor 
	

	public Fruit(String name){
		
		setMyName(name);
	}
	
	public String getFruit()
	{
		return "Hi ,I am a Fruit and my name is "+myName;
	}
	
	public String talkAboutYourSelf()
	{
		return myDefination;
	}
	
	

}
