package students.items;

public class Food extends Item {

	// constructor for food, inherits from Item
	public Food(int maturation, int death, int monetary) {
		super(maturation, death, monetary);
		// TODO Auto-generated constructor stub
	}
	
	// toString method for food, overrides Item toString
	@Override  
	public String toString() {
		
		return "Food";
	}

}
