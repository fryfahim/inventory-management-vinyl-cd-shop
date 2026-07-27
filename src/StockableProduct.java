import java.io.Serializable;

public abstract class StockableProduct extends Product implements Stockable, Serializable{
	private int numberOfItemStocked;
	
	public StockableProduct() {
		numberOfItemStocked = 0;
	}
	
	public StockableProduct(String name, int productId, double price, String genre, int yearPublished, double discount, int numberOfItemStocked) {
		super(name, productId, price, genre, yearPublished, discount);
		this.numberOfItemStocked = numberOfItemStocked;
	}
	
	public void addStock(int num) {
		numberOfItemStocked += num;
	}
	
	public void removeStock(int num) {
		numberOfItemStocked -= num; 
	}
	
	public void editStock(int num) {
		numberOfItemStocked = num; 
	}
	
	public abstract String getInfo();

	public int getNumberOfItemStocked() {
		return numberOfItemStocked;
	}

	public void setNumberOfItemStocked(int numberOfItemStocked) {
		this.numberOfItemStocked = numberOfItemStocked;
	}

	@Override
	public String toString() {
		return "StockableProduct [numberOfItemStocked=" + numberOfItemStocked + "]";
	}
}

