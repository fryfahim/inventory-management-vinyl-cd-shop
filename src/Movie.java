import java.io.Serializable;

public class Movie extends StockableProduct implements Serializable{
	private String director;
	
	public Movie() {
		director = "unknown";
	}
	
	public Movie(String name, int productId, double price, String genre, int yearPublished, double discount,int numberOfItemStocked, String director) {
		super(name, productId, price, genre, yearPublished, discount, numberOfItemStocked);
		this.director = director;
	}

	public String getDirector() {
		return director; 
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Movie [director=" + director + "]";
	}
	
	public String getInfo() {
		return "Movie name: " + getName() + "\nProduct ID: " + getProductId() + "\nPrice: " + getPrice() + "\nGenre: " + getGenre() +
				"\nYear Published: " + getYearPublished() + "\nDiscount: " + getDiscount() + "\nNumber of item stocked: " + getNumberOfItemStocked() +
				"\nDirector: " + getDirector(); 
	}
}
