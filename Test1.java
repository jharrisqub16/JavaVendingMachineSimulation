import java.util.Scanner;

public class Test1 {
    private static Scanner scanner;
    public static void main(String[] args) {
    	scanner = new Scanner(System.in);
    	//Changing the options within the menu bases system
    	String[] options = new String[]{"View All Items","Insert Coin","View Information","Purchase Item","View Receipt","Quit"};
		Menu menu = new Menu("Vending Machine",options);
		//Creating the owner and items within the machine
		VendingMachine vendingMachine = new VendingMachine("John", 5);
		VendItem item1 = new VendItem("Apple",20, 10);
		VendItem item2 = new VendItem("Banana",30);
		VendItem item3 = new VendItem("Chocolate",60, 5);
		vendingMachine.addNewItem(item1);
		vendingMachine.addNewItem(item2);
		vendingMachine.addNewItem(item3);

		int choice = 1;
		String resultOfPreviousPurchase = null;
		while(choice != 6) {
			choice = menu.getChoice();
			int position;
			//Switch created for breakdown of menu choices
			switch (choice){
				case 1:		//If option 1: 'View All Items' is selected
					 position = 1;
					for(String item : vendingMachine.listItems()){
						System.out.println(position + " " + item);
						position++;
					}
					System.out.println("+++++++++++++++\n");
					break;
				case 2:		//If option 2: 'Insert Coin' is selected
					System.out.print("Insert coin > ");
					int coin = scanner.nextInt();
					if(vendingMachine.insertCoin(coin)){
						System.out.println("Coin inserted");
					}
					else{
						System.out.println("Coin rejected");
					}
					System.out.println("+++++++++++++++\n");
					break;
				case 3:		//If option 3: 'View Information' is selected
					System.out.println(vendingMachine.getSystemInfo());
					System.out.println("+++++++++++++++\n");
					break;
				case 4:		//If option 4: 'Purchase Item' is selected
					position = 1;
					for(String item : vendingMachine.listItems()){
						System.out.println(position + " " + item);
						position++;
					}
					System.out.println();
					System.out.print("Choose item > ");
					int itemPosition = scanner.nextInt();
					resultOfPreviousPurchase = vendingMachine.purchaseItem(itemPosition - 1);
					System.out.println("+++++++++++++++\n");
					break;

				case 5:		//If option 5: 'View Receipt' is selected
					System.out.println(resultOfPreviousPurchase);
					System.out.println("+++++++++++++++\n");
					break;
			}
		}
	}

}
