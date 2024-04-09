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
