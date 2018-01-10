package pos;

import pos.domain.*;

import java.util.*;

public class Simulator {
	
	public static void main(String[] args) {
		
		// Primitive simulation
		Store location1 = new Store();
		Register reg = location1.getRegister();

		Scanner kb = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
		    System.out.println("-------------------------------------");
			System.out.print("Press [1] to begin a new sale: ");
			String input = kb.next();
			if (input.equals("1")) {
				System.out.println();
				
				reg.makeNewSale();
	
				while (!reg.getSale().isComplete()) {
					System.out.print("Enter item ID: ");
					String id = kb.next();
					System.out.print("Enter quantity: ");
					int quant = kb.nextInt();
	
					reg.enterItem(id, quant);
					
					System.out.print("Continue? [y/n]: ");
					
					String in = kb.next();
					System.out.println();
					if (in.matches("[Nn]")) {
						reg.endSale();
					} 
				}
				
				System.out.print("\nEnter amount tendered: ");
				float cash = kb.nextFloat();
				reg.makePayment(cash);
				System.out.println();
			}
			else
				run = false;
		}
		kb.close();
		System.exit(0);
	}
}
