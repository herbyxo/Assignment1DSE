package students.items;

public class Grain extends Food{
	
	static int generationCount = 0, cost = 2;

	public Grain() {
	super(2, 6, 2);
	// TODO Auto-generated constructor stub
	generationCount++;
}
	
	@Override
	public String toString () {
		if (age > maturation_age) {
		return "G";
		} else {
		return "g";
		}
	}
	
	static public int getGenerationCount(){
		
		return generationCount;
		
	}
		
	

}
