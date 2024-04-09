package students.items;

public class Apples extends Food{

	static int generationCount = 0, cost = 2;
	
	
	public Apples() {
	super(3, 5, 3);
	// TODO Auto-generated constructor stub
	generationCount++;
}
	
	@Override
	public String toString () {
		if (age > maturation_age) {
		return "A";
		} else {
		return "a";
		}
	}
	
	static public int getGenerationCount(){
		
		return generationCount;
		
	}
		
	

}


