package students.items;

public class UntilledSoil extends Item{
	
	// constructor, inherits from Item
	public UntilledSoil() {
	super(999,999, -1);  
	}

	// toString method
	@Override
	public String toString() {
		
		return "/";
		
	}
	
}
