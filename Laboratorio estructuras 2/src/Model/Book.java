package Model;

public class Book implements Comparable<Book> {
	
	private String ISBN;
	private double price;
	private int height;
	private int depth;
	private int amount;
	
	public Book(String ISBN, double price, int height,int depth,int amount) {
		this.ISBN = ISBN;
		this.price = price;
		this.height = height;
		this.depth = depth;
		this.amount = amount;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getDepth() {
		return depth;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public int compareTo(Book o) {
		if(depth < o.getDepth()) {
			return 1;
		}else if(depth > o.getDepth()){ 
			return -1;
		}else {
			if(height < o.getHeight()) {
				return 1;
			}else if(height > o.getHeight()){ 
				return -1;
			}
		}
		return 0;
	}
	 @Override
	public java.lang.String toString() {
		return ISBN;
	}
	
	

}
