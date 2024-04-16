package students.items;

public class Grain extends Food{
	
	// initialise variables
	static int generationCount = 0, cost = 2;
	
	//constructor, inherits from Food class
	public Grain() {
	super(2, 6, 2);
	// TODO Auto-generated constructor stub
	generationCount++;
}
	// toString method, checks if age is mature
	@Override
	public String toString () {
		if (age > maturation_age) {
		return "G";
		} else {
		return "g";
		}
	}
	
	// getter for generation count
	static public int getGenerationCount(){
		
		return generationCount;
		
	}
		
	

}
