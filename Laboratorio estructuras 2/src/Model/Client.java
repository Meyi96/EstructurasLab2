package Model;

import MyEstructures.PriorityQueue;
import MyEstructures.Queue;
import MyEstructures.Stack;

public class Client implements Comparable<Client>{
	private PriorityQueue<Book> books;
	private String bill; 
	private int iD;
	private int timeW;
	
	
	
	public Client(PriorityQueue<Book> books, int iD, int timeW) {
		this.books = books;
		bill = "";
		this.iD = iD;
		this.timeW = timeW;
	}
	
	public PriorityQueue<Book> getBooks() {
		return books;
	}
	public void setBooks(PriorityQueue<Book> books) {
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
		if(timeW < o.getTimeW()) {
			return 1;
		}else if(timeW > o.getTimeW()){
			return -1;
		}
		return 0;
	}
	
	public String getBill()
	{
		String out = "";
		int total = 0;
		StringBuilder helper = new StringBuilder();
		while(books.getSize() != 0) {
			Book actual = books.poll();
			total += (int)actual.getPrice();
			 helper.append(actual.getISBN() + " ");
		}
		out = " " + String.valueOf(total) + "\n" + helper.toString() + "\n";
		
		return out;
	}	
	
}
