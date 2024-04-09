package students;
import java.util.Scanner;
import students.items.*;


public class Farm {
	
	int height, width, funds;
	Field field;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		
		this.height = fieldHeight;
		this.width = fieldWidth;
		this.funds = startingFunds;
		this.field = new Field(fieldWidth, fieldHeight);
		
		
	}
	
	
	
	public void run()
	{
		
		Scanner sc = new Scanner(System.in);
		String input = " ";
		
		System.out.println(field);
		System.out.println("Bank balance: $" + funds);
		System.out.println("Enter your next action:");
		System.out.println("  t x y: till");
		System.out.println("  h x y: harvest");
		System.out.println("  p x y: plant");
		System.out.println("  s: field summary");
		System.out.println("  w: wait");
		System.out.println("  q: quit");
		input = sc.nextLine();
		
		switch(input.charAt(0)) {
		case 't':
			field.till(input.charAt(2), input.charAt(4));
			break;
		
		
		}
		
		
	}
	
}
