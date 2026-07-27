import java.io.Serializable;

public class Music extends StockableProduct implements Serializable{
	private String artistName;
	
	public Music() {
		artistName = "unknown";
	}
	
	public Music(String name, int productId, double price, String genre, int yearPublished, double discount,int numberOfItemStocked, String artistName) {
		super(name, productId, price, genre, yearPublished, discount, numberOfItemStocked);
		this.artistName = artistName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	@Override
	public String toString() {
		return "Music [artistName=" + artistName + "]";
	}
	
	public String getInfo() {
		return "Music name: " + getName() + "\nProduct ID: " + getProductId() + "\nPrice: " + getPrice() + "\nGenre: " + getGenre() +
				"\nYear Published: " + getYearPublished() + "\nDiscount: " + getDiscount() + "\nNumber of item stocked: " + getNumberOfItemStocked() +
				"\nArtist name: " + getArtistName(); 
	}
}
