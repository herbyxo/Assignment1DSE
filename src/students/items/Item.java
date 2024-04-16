package students.items;

abstract public class Item {
	// initialise variables
	int age, maturation_age, death_age;
	int monetary_value;
	
	// constructor method for variables
	public Item(int maturation, int death, int monetary) {
		
		this.age = 0;
		this.maturation_age = maturation;
		this.death_age = death;
		this.monetary_value = monetary;
		
	}
	
	// tick method, increases age each time its called
	public void tick() {
		
		age++;
		
	}
	
	// setter for age
	public void setAge(int age) {
		
		this.age = age;
		
	}
	
	// died method, returns age value when it is above death_age
	public boolean died() {
		
		return age > death_age;
	}
		
	// getter for monetary value if the age of item is matured
	public int getValue() {
		
		if (age > maturation_age) {
			
			return monetary_value;
			
		}else {
			return 0;
		}
		
	}
	
	// returns boolean based on if objects equal eachother
	public boolean equals(Item object) {

		if (this == object) {
			return true;	
		}else {
			return false;
		}
	}
	
	// abstract method for toString
	abstract public String toString();



	
}