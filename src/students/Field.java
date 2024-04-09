package students;
import students.items.*;
import java.util.Random;


public class Field {
	
	
	int height, width;
	Item[][] field;
	
	public Field(int height, int width){
		
		this.height = height;
		this.width = width;
		field = new Item[height][width];
		
		
		for (int i = 0; i < height; i++) {
			
			for (int j = 0; j < width; j++) {
				
				field[i][j] = new Soil();
				
			}
		}
	}
	
	public void tick() {
		
		for (int i = 0; i < height; i++) {
			
			for (int j = 0; j < width; j++) {
		
				field[i][j].tick();
				
				if (field[i][j] instanceof Soil) {
					Random rand = new Random();
					int num = rand.nextInt(100);
					if (num < 20) {
						field[i][j] = new Weed();
					}
					
				}
				
				if (field[i][j].died()) {
					
					field[i][j] = new UntilledSoil();
					
				}
				
			}
		}	
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // Header row
        sb.append("  ");
        for (int j = 0; j < width; j++) {
            sb.append(j + 1).append(" ");
        }
        sb.append("\n");
        
        // Content rows
        for (int i = 0; i < height; i++) {
            sb.append(i + 1).append(" ");
            for (int j = 0; j < width; j++) {
                sb.append(field[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
	
	public void till(int x, int y) {
		
		field[x][y] = new Soil();
		
	}
	
	public Item get(int x, int y) {
		
		return field[x][y];
		
	}
	
	public void plant(int x, int y, Item item) {
		
		field[x][y] = item;
		
	}
	
	
	public int getValue() {
		
		int value = 0;
		
		for (int i = 0; i < height; i++) {
			
			for (int j = 0; j < width; j++) {
		
				value = field[i][j].getValue() + value;
				
			}
		}
		
		return value;
	}
	
	
	public void getSummary() {
		
		int soil = 0, grain = 0, apples = 0, untilled = 0, weed = 0;	
			
		for (int i = 0; i < height; i++) {
					
					for (int j = 0; j < width; j++) {
				
						if (field[i][j] instanceof Soil) {
							soil++;
						}else if (field[i][j] instanceof Apples) {
							apples++;
						}else if(field[i][j] instanceof Grain) {
							grain++;
						}else if(field[i][j] instanceof UntilledSoil) {
							untilled++;
						}else if(field[i][j] instanceof Weed) {
							weed++;
						}
						
					}
				}
				
		
		System.out.printf("%-20s %20s %n","Apples:", apples);
		System.out.printf("%-20s %20.2f %n","Grain:", grain);
		System.out.printf("%-20s %20.2f %n","Soil:", soil);
		System.out.printf("%-20s %20.2f %n","Untilled:", untilled);
		System.out.printf("%-20s %20.2f %n","Weed:", weed);
		System.out.printf("%-20s %20.2f %n","For a total of $", getValue());;
		
		
		
		
	}
	
	
}
