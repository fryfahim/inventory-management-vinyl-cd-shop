import java.util.*;
public class Inventory implements Iterable<StockableProduct>{
	private ArrayList<StockableProduct> items;
	
	//Iterator Implementation
	public Iterator<StockableProduct> iterator() {
		return new customIterator<StockableProduct>(items);
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
	
	public Inventory() { 
		items = new ArrayList<>(); 
	}
	
	public void addItem(StockableProduct product) {
		items.add(product);
	}
	
	public void removeItem(int productId) {
		for(int i = 0; i<items.size(); i++) {
			if(items.get(i).getProductId()==productId) {
				items.remove(i);
			}
		}
	}
	
	public StockableProduct getItem(int productId) {
		int n = 0;
		for(int i = 0; i<items.size(); i++) {
			if(items.get(i).getProductId()==productId) {
				n += i;
				break;
			}
		}
		items.get(n).removeStock(1);
		return items.get(n);
	}
	
	public void addProductStock(int productId, int numberOfNewStock) {
		for(int i = 0; i<items.size(); i++) {
			if(items.get(i).getProductId()==productId) {
				items.get(i).addStock(numberOfNewStock);
			}
		}
	}
	
	public void sortByPrice() {
		StockableProduct temp;
		for(int i = 0; i<((items.size())-1); i++) {
			for(int j = i+1; j<items.size(); j++) {
				if(items.get(j).getPrice()<items.get(i).getPrice()) {
					temp  = items.get(i);
					items.set(i, items.get(j));
					items.set(j, temp);
				}
			}
		}
	}
	
	public void sortByAvailableStock() { 
		StockableProduct temp;
		for(int i = 0; i<((items.size())-1); i++) {
			for(int j = i+1; j<items.size(); j++) {
				if(items.get(j).getNumberOfItemStocked()<items.get(i).getNumberOfItemStocked()) {
					temp  = items.get(i);
					items.set(i, items.get(j));
					items.set(j, temp);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Inventory [items=" + items + "]";
	}
}
