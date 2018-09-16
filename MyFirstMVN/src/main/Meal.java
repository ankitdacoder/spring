package main;

public class Meal {

	public Meal() {
	}

	public Meal(Fruit f, Vegitable v) {
		this.fruit = f;
		this.veg = v;
	};

	private Fruit fruit;

	public Fruit getFruit() {
		return fruit;
	}

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	private Vegitable veg;

	public Vegitable getVeg() {
		return veg;
	}

	public void setVeg(Vegitable veg) {
		this.veg = veg;
	}

	public String whatsOnMyPlate() {
		String foods = "";
		if (fruit != null) {
			foods = "some fruit";
		}
		if (veg != null) {
			foods += "some vegitable";
		}
		return foods;
	}

}
