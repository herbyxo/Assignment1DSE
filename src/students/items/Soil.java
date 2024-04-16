package students.items;

public class Soil extends Item{
	
	// constructor, inherits from Item
	public Soil() {
		super(999,999, -1);  
		}
	// toString method
	@Override
	public String toString() {
		
		return ".";
		
	}

}
