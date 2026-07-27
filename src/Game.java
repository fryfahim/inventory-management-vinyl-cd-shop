import java.io.Serializable;

public class Game extends StockableProduct implements Serializable{
	private String developer;
	
	public Game() {
		developer = "unknown";
	}
	
	public Game(String name, int productId, double price, String genre, int yearPublished, double discount,int numberOfItemStocked, String developer) {
		super(name, productId, price, genre, yearPublished, discount, numberOfItemStocked); 
		this.developer = developer;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	@Override
	public String toString() {
		return "Game [developer=" + developer + "]"; 
	}
	
	public String getInfo() {
		return "Game name: " + getName() + "\nProduct ID: " + getProductId() + "\nPrice: " + getPrice() + "\nGenre: " + getGenre() +
				"\nYear Published: " + getYearPublished() + "\nDiscount: " + getDiscount() + "\nNumber of item stocked: " + getNumberOfItemStocked() +
				"\nDeveloper: " + getDeveloper(); 
	}
}
