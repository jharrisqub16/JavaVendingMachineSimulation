


public class VendingMachine {

    //Declaration of variables
    private String owner;
    private int maxItems;
    private int itemCount;
    private VendItem[] stock;
    private double totalMoney;
    private double userMoney;
    private Status vmStatus;
    

    /**
     * Constructor containing owner and maxItems.
     * @param vmOwner
     * @param vmMaxItems
     */
    public VendingMachine(String vmOwner, int vmMaxItems) {
        this.owner = vmOwner;
        this.maxItems = vmMaxItems;
        this.stock = new VendItem[vmMaxItems];
		itemCount = 0;
		userMoney = 0;
		vmStatus = Status.SERVICE_MODE;
		
    }

    //Returns all the information available for the user regarding the Vending Machine
    public String getSystemInfo() {
		String info = "Owner: " +
				owner + "\n" +
				"Items held: " + itemCount + "/" + maxItems + "\n" +
				"User money: " + userMoney + "\n" +
				"Total held amount: " + totalMoney;
		return info;

    }
    //Completely resets the vending machine emptying all items and money
    public void reset() {
    	stock = new VendItem[maxItems];
    	itemCount = 0;
    	userMoney = 0;
    	totalMoney = 0;
    }

    //Method to allow the user to purchase an item
    public String purchaseItem(int itemPosition) {

    	VendItem item =  stock[itemPosition];
    	if(vmStatus.getStatus() == Status.VENDING_MODE) {
			String result =  item.deliver();			//Allows for the purchasing of an item when in vending mode
			if(!ifAnyItemHasAQuantity()){
				vmStatus = Status.SERVICE_MODE;
			}
			return result;
		}
    	return null;
	}

	//Checks if any item has a quantity above 0
	private boolean ifAnyItemHasAQuantity() {
    	for(int i = 0; i < itemCount; i++){
    		if(stock[i].getQty() > 0){
    			return true;
			}
		}
		return false;
	}
	//Ensures that any coin inserted matches the requirements
	public boolean insertCoin(int coin) {
        if((coin == 5) || (coin == 10) || (coin == 20) || (coin == 50) || (coin == 100) || (coin == 200)){
			userMoney += coin;
			return true;
		}
        return false;
    }

    public String[] listItems() {
    	if(itemCount == 0){
    		return new String[]{};
		}
        String[] items = new String[itemCount];
        for (int i = 0; i < itemCount; i++) {
            items[i] = stock[i].getName() + "(" + stock[i].getQty() + ")";
        }
        return items;
    }
    
    //Allowing for the addition of a new item
    public boolean addNewItem(VendItem item) {
    	if(itemCount == maxItems){
    		return false;		//Ensures if the machine is full a new item cannot be added. 
		}
    	if(item.getQty() > 0){
    		vmStatus = Status.VENDING_MODE;
		}
    	stock[itemCount] = item;
		itemCount++;
		return true;
	}
}
