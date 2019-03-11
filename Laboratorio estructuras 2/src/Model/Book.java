package Model;

public class Book {
	
	private int ISBN;
	private double price;
	
	public Book(int iSBN, double price) {
		super();
		ISBN = iSBN;
		this.price = price;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
