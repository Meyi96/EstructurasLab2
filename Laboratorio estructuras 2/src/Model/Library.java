package Model;

import MyEstructures.HashMap;
import MyEstructures.PriorityQueue;
import MyEstructures.Queue;

public class Library {
	private Queue<Client> staringLine = new Queue<>();
	private PriorityQueue<Client> payLine = new PriorityQueue<>(true);
	private HashMap<Book,Integer> catalog = new HashMap<>();
	private Queue<Client> payingCashier = new Queue<>();
	private int cashierCapacity;
	
	public Library(Queue<Client> staringLine, HashMap<Book, Integer> catalog, int cashierCapacity) {
		this.staringLine = staringLine;
		this.catalog = catalog;
		this.cashierCapacity = cashierCapacity;
	}
	
	
}
