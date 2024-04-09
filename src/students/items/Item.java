package students.items;

abstract public class Item {
	
	int age, maturation_age, death_age;
	int monetary_value;
	
	public Item(int maturation, int death, int monetary) {
		
		this.age = 0;
		this.maturation_age = maturation;
		this.death_age = death;
		this.monetary_value = monetary;
		
	}
	
	public void tick() {
		
		age++;
		
	}
	
	public void setAge(int age) {
		
		this.age = age;
		
	}
	
	public boolean died() {
		
		return age > death_age;
	}
		
		
	public int getValue() {
		
		if (age > maturation_age) {
			
			return monetary_value;
			
		}else {
			return 0;
		}
		
	}
	
	public boolean equals(Item object) {

		if (this == object) {
			return true;	
		}else {
			return false;
		}
	}
	
	abstract public String toString();



	
}