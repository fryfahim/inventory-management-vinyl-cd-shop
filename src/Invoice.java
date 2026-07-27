import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
import java.util.ArrayList;
import java.util.Iterator;
public class Invoice implements Iterable<Product>{
	private ArrayList<Product> items;
	private LocalDateTime date;

	//Iterator Implementation
	public Iterator<Product> iterator() {
		return new customIterator<Product>(items);
	}
	
	public class customIterator<E> implements Iterator<E> {
		int indexPosition = 0;
		ArrayList<E> internalList; 
		
		public customIterator(ArrayList<E> internalList) {
			this.internalList = internalList; 
		}
		
		public boolean hasNext() {
			if(internalList.size()>=indexPosition+1) {
				return true;
			}
			else
				return false;
		}
		
		public E next() {
			E val = internalList.get(indexPosition);
			indexPosition++;
			return val;
		}
	}
	//Iterator Implementation
		 
	public Invoice() {
		items = new ArrayList<>();
		date = LocalDateTime.now();
	} 
	
	public Invoice(LocalDateTime date) {
		items = new ArrayList<>();
		this.date = date;
	}
	
	public String getLocalDateTime() { 
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String stringDate = date.format(formatter);
		return stringDate;
	}
	
	public void addProduct(Product product) {
		items.add(product);
	}
	
	public void removeProduct(Product product) {
		items.remove(product);
	}
	
	private double calculatePriceWithoutDiscount() {
		double totalPrice=0.0;
		for(Product item :items) { 
			totalPrice=totalPrice+item.getPrice();
		}
		return totalPrice; 
	}
	
	private boolean isFullHouseDiscountAvailable() {
		int game=0, movie=0, music=0; 
		String classOfItem;
		for(Product item :items) {
			classOfItem = item.getClass().getSimpleName();
			if(classOfItem == "Game") {
				game++;
			}
			else if(classOfItem == "Movie") {
				movie++;
			}
			else if(classOfItem == "Music") {
				music++;
			}
		}
		if((game>=2) && (movie>=2) && (music>=2)) {
			return true;
		}
		else
			return false;
	}
	
	private double calculateDiscountedPrice() {
		double discountPrice = 0.0, fullHouseDiscount = 0.0;
		for(Product item :items) {
			discountPrice += (item.getPrice() - ((item.getPrice()*item.getDiscount())/100));
		}
		if(isFullHouseDiscountAvailable() == true) {
			fullHouseDiscount = (calculatePriceWithoutDiscount() - ((calculatePriceWithoutDiscount()*50)/100));
			if(fullHouseDiscount<discountPrice) {
				return fullHouseDiscount; 	 
			}
		}
		return discountPrice;
	}
	
	public String getInvoice() { 
		StringBuilder result = new StringBuilder();
	    result.append("");

	    for(Product item :items)
	    {
	        result.append("\nName: "+item.getName()+", Price: "+item.getPrice()+" ");
	    }
		return "date - " +  getLocalDateTime() + result + "\nTotal Price: " + calculatePriceWithoutDiscount()
		+ "\nPrice after discount: " + calculateDiscountedPrice();
	}
}
