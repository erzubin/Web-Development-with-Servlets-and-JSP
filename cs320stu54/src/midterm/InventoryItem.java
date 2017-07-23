package midterm;

public class InventoryItem {
	private int id;
	private String Name;
    private String Description;
    private int Price;
    private double Inventory;
   
    public InventoryItem(String Name,String Description,int Price,Double Inventory)
    {
     	this.Name = Name;
     	this.Description = Description;
     	this.Price= Price;
     	this.Inventory=Inventory;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public double getInventory() {
		return Inventory;
	}

	public void setInventory(double inventory) {
		Inventory = inventory;
	}

		
}
