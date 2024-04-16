package students;
import students.items.*;
import java.util.Scanner;
import java.util.Random;

public class Farm {
	
	// initialise variables
    int startingFunds;
    int bankBalance;
    Field field;
    // new functionality
    private String[] weather = {"Sunny", "Rainy", "Cloudy", "Stormy"};


    
    // constructor method
    public Farm(int fieldWidth, int fieldHeight, int startingFunds) {
        this.startingFunds = startingFunds;
        this.bankBalance = startingFunds;
        this.field = new Field(fieldHeight, fieldWidth);
    }

    // run function, runs the game
    public void run() {
    	// scanner for input
        Scanner scanner = new Scanner(System.in);
        String action = "";
        
        // while loop, outputs balance and user options
        while (!action.equals("q")) {
            System.out.println(field);
            System.out.println("Bank balance: $" + bankBalance);
            System.out.println("Enter your next action:");
            System.out.println("  t x y: till");
            System.out.println("  h x y: harvest");
            System.out.println("  p x y: plant");
            System.out.println("  s: field summary");
            System.out.println("  w: wait");
            System.out.println("  q: quit");

            // user input
            action = scanner.nextLine();

            // switch that checks the character and does action based on it
            switch (action.charAt(0)) {
                case 't':
                    till(action);
                    break;
                case 'h':
                    harvest(action);
                    break;
                case 'p':
                    plant(action);
                    break;
                case 's':
                    System.out.println(field.getSummary());
                    break;
                case 'w':
                    field.tick();
                    System.out.println("Current weather: " + generateWeather());
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
            }
        }

        System.out.println("Game ended. Final bank balance: $" + bankBalance);
    }

    // method for checking what the x and y co-ordinates are. till method
    public void till(String action) {
        if (generateWeather() == "Stormy") {
        	System.out.println("Too Stormy to till!");
        }
        else {
    	try {
            String[] parts = action.split(" ");
            int x = Integer.parseInt(parts[1]) - 1;
            int y = Integer.parseInt(parts[2]) - 1;
            field.till(x, y);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input. Please enter valid coordinates.");
        }
    }}

    // method for checking x and y co-ordinates. harvest method
    public void harvest(String action) {
        try {
            String[] parts = action.split(" ");
            int x = Integer.parseInt(parts[1]) - 1;
            int y = Integer.parseInt(parts[2]) - 1;
            Item item = field.get(x, y);
            // if item is Food, harvests it and adds value to money. turns item to Soil
            if (item instanceof Food) {
                bankBalance += item.getValue();
                field.plant(x, y, new Soil());
            } else {
                System.out.println("Cannot harvest. Either no crop or not matured yet.");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input. Please enter valid coordinates.");
        }
    }

    //  method for checking x and y coordinates. plant method
    public void plant(String action) {
        try {
            String[] parts = action.split(" ");
            int x = Integer.parseInt(parts[1]) - 1;
            int y = Integer.parseInt(parts[2]) - 1;
            // user input for what user wants to plant
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter:");
            System.out.println(" - 'a' to buy an apple for $1");
            System.out.println(" - 'g' to buy grain for $2");
            String choice = scanner.nextLine();
            // if statements based on input
            Item newItem = null;
            if (choice.equals("a")) {
                if (bankBalance >= 1) {
                    newItem = new Apples();
                    bankBalance -= 1;
                } else {
                    System.out.println("Insufficient funds to buy apple.");
                    return;
                }
            } else if (choice.equals("g")) {
                if (bankBalance >= 2) {
                    newItem = new Grain();
                    bankBalance -= 2;
                } else {
                    System.out.println("Insufficient funds to buy grain.");
                    return;
                }
            } else {
                System.out.println("Invalid choice.");
                return;
            }
            
            // if field[x][y] is Soil, then plants the item, else does not
            if (field.get(x, y) instanceof Soil) {
                field.plant(x, y, newItem);
            } else {
                System.out.println("Cannot plant. Location is not soil.");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input. Please enter valid coordinates.");
        }
    }
    
    // outputs value from weather list randomly
    public String generateWeather() {
        Random rand = new Random();
        int index = rand.nextInt(weather.length);
        return weather[index];
    }
    
    

}