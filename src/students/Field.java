package students;
import students.items.*;
import students.Weather;
import java.util.Random;


public class Field {
	
	// initialise variables and array
	int height, width;
	Item[][] field;
	Weather weather = new Weather();
	
	// constructor, fills array based on height and width inputs
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
	
	// tick method, uses for loops to age each plot of land in the field
	public void tick() {
		
		
		for (int i = 0; i < height; i++) {
			
			for (int j = 0; j < width; j++) {
		
				field[i][j].tick();
				
				// if field[x][y] is Soil, then there is a 20 percent chance it can become a weed
				if (field[i][j] instanceof Soil) {
					Random rand = new Random();
					int num = rand.nextInt(100);
					if (num < 20) {
						field[i][j] = new Weed();
					}
					
				}
				
				// if field[x][y] has died, it becomes untilledsoil
				if (field[i][j].died()) {
					
					field[i][j] = new UntilledSoil();
					
				}
				
			}
		}	
	}
	
	// toString method
	public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // header row
        sb.append("  ");
        for (int j = 0; j < width; j++) {
            sb.append(j + 1).append(" ");
        }
        sb.append("\n");
        
        // content rows
        for (int i = 0; i < height; i++) {
            sb.append(i + 1).append(" ");
            for (int j = 0; j < width; j++) {
                sb.append(field[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
	// till method, fills x and y with soil
	public void till(int x, int y) {
		
		field[x][y] = new Soil();
		
	}
	
	// gets Item at x and y
	public Item get(int x, int y) {
		
		return field[x][y];
		
	}
	
	// plants Item at x and y
	public void plant(int x, int y, Item item) {
		
		field[x][y] = item;
		
	}
	
	
	// returns value of all items in the field summed up
	public int getValue() {
		
		int value = 0;
		
		for (int i = 0; i < height; i++) {
			
			for (int j = 0; j < width; j++) {
		
				value = field[i][j].getValue() + value;
				
			}
		}
		
		return value;
	}
	
	// returns a summary of number of each item, and value
	public String getSummary() {
		
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
				
		
		int totalValue = getValue();
        String summary = "Apples:        " + apples + "\n";
        summary += "Grain:         " + grain + "\n";
        summary += "Soil:          " + soil + "\n";
        summary += "Untilled:      " + untilled + "\n";
        summary += "Weed:          " + weed + "\n";
        summary += "For a total of $" + totalValue + "\n";
        summary += "Total apples created: " + apples + "\n";
        summary += "Total grain created: " + grain + "\n";
        
        return summary;
		
		
		
	}
	
	
}
