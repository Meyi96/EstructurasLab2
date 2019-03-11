package Model;

import MyEstructures.Queue;

public class Client implements Comparable<Client>{
	private Queue<Book> books = new Queue<>();
	private int iD;
	private int timeW;
	
	
	
	public Client(Queue<Book> books, int iD, int timeW) {
		this.books = books;
		this.iD = iD;
		this.timeW = timeW;
	}
	
	public Queue<Book> getBooks() {
		return books;
	}
	public void setBooks(Queue<Book> books) {
		this.books = books;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public int getTimeW() {
		return timeW;
	}
	public void setTimeW(int timeW) {
		this.timeW = timeW;
	}


	@Override
	public int compareTo(Client o) {
		
		return 0;
	}
	
	
	
}
