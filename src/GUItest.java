
public class GUItest {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		
		Music m1 = new Music("Submarine", 1, 20, "Indie", 2011, 10, 100, "Alex Turner");
		Music m2 = new Music("AM", 2, 10, "Indie", 2013, 5.5, 10, "Arctic Monkeys");
		Music m3 = new Music("Tranquility Base Hotel and Casino", 3, 23, "Indie", 2018, 7.5, 500, "Arctic Monkeys");
		
		Movie v1 = new Movie("Good Will Hunting", 7, 12, "Drama", 1997, 5.4, 123, "Gus Van Sant");
		Movie v2 = new Movie("Life Is Beautiful", 8, 20, "Comedy-Drama", 1997, 2.6, 126, "Roberto Benigni");
		Movie v3 = new Movie("what's eating gilbert grape", 9, 20, "Drama", 1993, 6.4, 122 ,"Lasse Hallstrom");
		
		Game g1 = new Game("Red Dead Redemption 2", 14, 29, "Survival", 2018, 3.7, 560, "RockStar");
		Game g2 = new Game("God of War", 15, 12, "Action", 2018, 5.6, 567, "Javaground");
		Game g3 = new Game("Grand Theft Auto V", 16, 13, "Action", 2017, 2.3, 565, "RockStar");
			
		inventory.addItem(m1);
		inventory.addItem(m2);
		inventory.addItem(m3);
		inventory.addItem(v1);
		inventory.addItem(v2);
		inventory.addItem(v3);
		inventory.addItem(g1);
		inventory.addItem(g2);
		inventory.addItem(g3);
		
//		for(StockableProduct product : inventory) {
//			System.out.println(product.getInfo() + "\n");
//		}
		
//		File invFile = new File("testInv.txt");
//		
//		Inventory temp = new Inventory();
//		try {
//			ObjectInputStream input = new ObjectInputStream(new FileInputStream(invFile));
//			while(true) {
//				try {
//					temp.addItem((StockableProduct)input.readObject());
//				}catch(java.io.EOFException eofe) {
//					break;
//				}
//			}
//			input.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		temp.addItem(m1);
//		try {
//			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(invFile));
//				for(StockableProduct product : temp) {
//					objOut.writeObject(product);
//				}
//			objOut.close();
//		} catch (IOException e) {
//		}
//		
		
		
		
		
		
		
		
		
//		File inv = new File("inventory.txt");
//		Inventory fileInventory = new Inventory();
//		try {
//			ObjectInputStream input = new ObjectInputStream(new FileInputStream(inv));
//			while(true) {
//				try {
//					fileInventory.addItem((StockableProduct)input.readObject());
//				}catch(java.io.EOFException eofe) {
//					break;
//				}
//			}
//			input.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		for(StockableProduct product: fileInventory) {
//			System.out.println(product.getInfo());
//		System.out.println("");
//	}
		
		
		
		Invoice invoice = new Invoice();
		
		inventory.getItem(m1.getProductId());
		invoice.addProduct(m1);
		inventory.getItem(m2.getProductId());
		invoice.addProduct(m2);
		inventory.getItem(v1.getProductId());
		invoice.addProduct(v1);
		inventory.getItem(v2.getProductId());
		invoice.addProduct(v2);
		inventory.getItem(g1.getProductId());
		invoice.addProduct(g1);
		
		
		System.out.println(invoice.getInvoice());
		System.out.println("");
		
		
		Invoice invoice2 = new Invoice(); 
		
		inventory.getItem(m1.getProductId());
		invoice2.addProduct(m1);
		inventory.getItem(m2.getProductId());
		invoice2.addProduct(m2);
		inventory.getItem(v1.getProductId());
		invoice2.addProduct(v1);
		inventory.getItem(v2.getProductId());
		invoice2.addProduct(v2);
		inventory.getItem(g1.getProductId());
		invoice2.addProduct(g1);
		inventory.getItem(g2.getProductId());
		invoice2.addProduct(g2);
		
		System.out.println(invoice2.getInvoice());
		System.out.println("");
//		
//		for(StockableProduct product: inventory) {
//			if(product.getClass().getSimpleName() == "Game") {
//				System.out.println(product.getName()); 
//			}
//		}
//		
//		inventory.sortByPrice();
//		System.out.println("");
//		for(StockableProduct product: inventory) {
//			if(product.getClass().getSimpleName() == "Music") {
//				System.out.println("Name: " + product.getName() + " Price: " + product.getPrice());
//				break;
//			}
//		}
//		
//		System.out.println("");
//		for(StockableProduct product: inventory) {
//			if((product.getClass().getSimpleName() == "Movie") && ((product.getInfo().contains("Gus Van Sant"))==true)){
//				System.out.println(product.getName());
//			}
//		}
	}
} 
