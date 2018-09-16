package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.model.FoodGroup;
import com.demo.model.FoodGroupDAO;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Fruit f=new Fruit();

//		ApplicationContext appContext = new FileSystemXmlApplicationContext("appContext.xml");
//		Fruit f = appContext.getBean("fruit", Fruit.class);
//
//		System.out.println(f.getFruit());
//
//		Fruit myf = appContext.getBean("myFruit", Fruit.class);
//		System.out.println(myf.getFruit());
//
//		Vegitable V = (Vegitable) appContext.getBean("myVegitable");
//
//		System.out.println("I am a Vegitable and my name is " + V.getMyName());
//
//		Sports sp = appContext.getBean("sports", Sports.class);
//
//		System.out.println(sp.printSports());
//		
//         
//		Vegitable nameSpace = (Vegitable) appContext.getBean("pnamespace");
//        System.out.println(nameSpace.getMyName());
//        
//        
//        Meal melSetterInjection = (Meal) appContext.getBean("meal");
//        System.out.println("setter injection "+melSetterInjection.whatsOnMyPlate());
//        
//        
//        Meal mealConstrutor = (Meal) appContext.getBean("mealCons");
//        System.out.println("Parameter constrtor injection "+mealConstrutor.whatsOnMyPlate());
//        
//        Fruit myfruitProprty = appContext.getBean("myFruitPro", Fruit.class);
//		System.out.println(myfruitProprty.talkAboutYourSelf());
//		
//		
//		Mobile myAutoWiredByType= appContext.getBean("autoWiredByType",Mobile.class);
//		
//		System.out.println("AutoWired byType "+myAutoWiredByType.talk());
//        
//		((FileSystemXmlApplicationContext)appContext).close();
		
		ApplicationContext appContext=new FileSystemXmlApplicationContext("appContextMysql.xml");
		FoodGroupDAO myFoodGroupDAO=appContext.getBean("foodGroupDAO",FoodGroupDAO.class);
		
		
		myFoodGroupDAO.addFoodGroup("New Food", "Happy Addeding");
		

		
		FoodGroup honey= myFoodGroupDAO.getFoodGroup(1);
		System.out.println(honey.talkAboutYourSelf());
		
           
		//adding row using bean property 
		FoodGroup fg= new FoodGroup("Random Name", "Random Description");
		myFoodGroupDAO.create(fg);
		
		/*        List all the food list from database*/
		List<FoodGroup> myFoodGroupList=myFoodGroupDAO.getFoodGroups();
		
		for(FoodGroup fgs :myFoodGroupList)
		{
			System.out.println(fgs.talkAboutYourSelf());
		}
		
		//update record using id
		FoodGroup update=new FoodGroup(1, "Honey Baba","Using spices such as turmeric, cardamom and cinnamon to flavour your food is a tasty way to cut down on salt, too much of which can lead to high blood pressure.");
		myFoodGroupDAO.update(update);
		
		//delete row 
		
		myFoodGroupDAO.delete(1);
		
		
		
		
		
	}

}
