
public class VendItem implements Vendible{
   
	//Declaration of variables
    private int itemID;
    private static int nextID = 1;
    private String name;
    private double unitPrice;
    private int qtyAvailable;

    /**
     * Constructor containing name and unitPrice.
     * @param name
     * @param cost
     */
    public VendItem(String name, double cost) {
        this.name = name;
		this.unitPrice = cost;
		qtyAvailable = 1;
    }
    /**
     * Constructor containing name, unitPrice and qtyAvailable.
     * @param name
     * @param cost
     * @param qtyAvailable
     */
    public VendItem(String name, double cost, int qtyAvailable) {
        this.itemID = nextID;
        nextID++; //generates new unique ID for the next item
        this.name = name;
        this.unitPrice = cost;
        this.qtyAvailable = qtyAvailable;

    }


    public boolean restock(int restockQuantity) {
        this.qtyAvailable += restockQuantity; 	//Accounts for re-stock amount given from e.g. manufacturer 
        if (qtyAvailable > 10) {				//Maximum amount of one item in machine is 10
            qtyAvailable = 10;
            return true;
        }
        return false;
    }

    //Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return unitPrice;
    }

    public int getQty() {
        return qtyAvailable;
    }

    
    
    //Taking deliver() method from the 'Vendible' interface via the '@Override' subclass. 
	@Override
	public String deliver() {
	//
    	if(qtyAvailable == 0){
    		return null;				//There is none of the item left so delivery does not occur
		}
    	qtyAvailable--;
		return "Thanks for purchasing: " + name;
	}
}
