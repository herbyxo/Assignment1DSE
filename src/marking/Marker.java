package marking;

import students.Farm;
import students.Field;
import students.items.*;

public class Item {
	
	int age = 0, maturatation_age, death_age;
	double monetary_value;
	
	public Item(maturation, death, monetary) {
		
		this.maturatation_age = maturation;
		this.death_age = death;
		this.monetary_value = monetary;
		
	}
	
	public void tick() {
		
		age++;
		
	}
	
	public void setAge(int) {
		
		this.age = int;
		
	}
	
	public boolean died() {
		
		if (this.age > this.death_age) {
			return true
		} else {
			return false
		}
	}
		
		
	public double getValue() {
		
		if (this.age > this.maturatation_age) {
			
			return this.monetary_value
			
		}
		
	}
	
	public boolean equals(Item object) {

		if (this.age == object.age && this.maturation_age == maturation_age && this.death_age == death_age && this.monetary_value == monetary_value) {
			
			return true
			
			)
		}else {
			
			return false
			// confused on this
		}
		
	}
	
	public String toString() {
		
		//and this
		
	}
	
	public class Food{
		
		
		public class Grain {
			
			Food grain;
			
			int maturation_age = 2, death_age = 6, monetary_value = 2;
			
			public int getGenerationCount() {
				
				
				
				
			}
			
		}
		
	}
	
	
	
}

public class Marker {

	public static void main(String[] args) {
		
		// Section ONE
		
		//you should NOT be able to make an Item - following line shouldn't compile if uncommented
		//new Item(0, 0, 0);
		
		
		
		System.out.println(Apples.getGenerationCount()); // should print 0
		Apples a = new Apples();
		System.out.println(Apples.getGenerationCount()); // should print 1
		System.out.println(a); // should print "a"
		System.out.println(a.getValue()); // should print 0
		a.setAge(5);
		System.out.println(a.getValue()); // should print 3
		System.out.println(a); // should print "A"
		System.out.println(a.died()); // should print false
		a.tick();
		System.out.println(a.died()); // should print true
		Food testFood = a; //this should be possible
		Item testItem = testFood; //this should be possible

		System.out.println(new Weed()); // should print "#"
		System.out.println(new UntilledSoil()); // should print "/"

		// Section TWO
		// uncomment this section once you get to it
		
		/*
		Field testField = new Field(5, 5);
		System.out.println(testField.get(3, 3)); //should print "."
		System.out.println(testField); //should print the field
		System.out.println(testField.getValue()); //should print 0
		a = new Apples();
		a.setAge(5);
		testField.plant(0, 0, a);
		System.out.println(testField.getValue()); //should print 3
		System.out.println(a.equals(testField.get(0, 0))); //should print true
		testField.till(0, 0);
		System.out.println(a.equals(testField.get(0, 0))); //should print false
		System.out.println(testField.get(0, 0).equals(new Soil())); //should print true
		*/

		// Section THREE
		// uncomment this section once you get to it
		//remember, your farm should work on varies size fields (assuming all fields are less than 10x10)
		//Farm f = new Farm(10, 5, 10);
		//f.run();
		
	}

}
