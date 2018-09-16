package main;

public class Mobile {
	
	private String name;
	
	public Mobile() {}//no-argument constructor

	public Mobile(String m) {
		this.name=m;
	}	 
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String talk()
	{
		return getName();
	}
	
	public void initMethod()
	{
		System.out.println("Mobile is ready to go "+this.name);
	}
	
	public void destoryMethod()
	{
		System.out.println("Mobile Bean is about to destory");
	}
	

}
