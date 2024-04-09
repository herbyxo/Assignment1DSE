package students;
import students.items.*;
import java.util.Scanner;

public class Farm {
    int startingFunds;
    int bankBalance;
    Field field;

    public Farm(int fieldWidth, int fieldHeight, int startingFunds) {
        this.startingFunds = startingFunds;
        this.bankBalance = startingFunds;
        this.field = new Field(fieldHeight, fieldWidth);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String action = "";

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

            action = scanner.nextLine();

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
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
            }
        }

        System.out.println("Game ended. Final bank balance: $" + bankBalance);
    }

    private void till(String action) {
        try {
            String[] parts = action.split(" ");
            int x = Integer.parseInt(parts[1]) - 1;
            int y = Integer.parseInt(parts[2]) - 1;
            field.till(x, y);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input. Please enter valid coordinates.");
        }
    }

    private void harvest(String action) {
        try {
            String[] parts = action.split(" ");
            int x = Integer.parseInt(parts[1]) - 1;
            int y = Integer.parseInt(parts[2]) - 1;
            Item item = field.get(x, y);
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

    private void plant(String action) {
        try {
            String[] parts = action.split(" ");
            int x = Integer.parseInt(parts[1]) - 1;
            int y = Integer.parseInt(parts[2]) - 1;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter:");
            System.out.println(" - 'a' to buy an apple for $1");
            System.out.println(" - 'g' to buy grain for $2");

            String choice = scanner.nextLine();
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

            if (field.get(x, y) instanceof Soil) {
                field.plant(x, y, newItem);
            } else {
                System.out.println("Cannot plant. Location is not soil.");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input. Please enter valid coordinates.");
        }
    }

}