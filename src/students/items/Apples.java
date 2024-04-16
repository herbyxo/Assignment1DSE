package students.items;

public class Apples extends Food{

	// initialise variables 
	static int generationCount = 0, cost = 2;
	
	// constructor that inherits attributes from Food class
	public Apples() {
	super(3, 5, 3);
	// TODO Auto-generated constructor stub
	generationCount++;
}
	// to String method, checks if age is mature
	@Override
	public String toString () {
		if (age > maturation_age) {
		return "A";
		} else {
		return "a";
		}
	}
	
	// getter for generation count
	static public int getGenerationCount(){
		
		return generationCount;
		
	}
		
	

}


