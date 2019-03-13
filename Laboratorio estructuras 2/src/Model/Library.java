package Model;

import MyEstructures.HashMap;
import MyEstructures.PriorityQueue;
import MyEstructures.Queue;

public class Library {
	private Queue<Client> staringLine = new Queue<>();
	private PriorityQueue<Client> payLine = new PriorityQueue<>(true);
	private HashMap<String,Book> catalog = new HashMap<>();
	private Queue<Client> payingOut = new Queue<>();
	private int cashierCapacity;
	
	public Library(Queue<Client> staringLine, HashMap<String, Book> catalog, int cashierCapacity) {
		this.staringLine = staringLine;
		this.catalog = catalog;
		this.cashierCapacity = cashierCapacity;
		getBooks();
	}
	
	//De izquierda a derecha y de abajo a arriba?
	//Si no esta el libro se le suma tiempo?
	private void getBooks() {
		int aTime = 1;
		while(staringLine.getSize() != 0) {
			Client entering = staringLine.poll();
			entering.setTimeW(aTime);
			aTime++;
			PriorityQueue<Book> auxiliar = new PriorityQueue<>(true);
			
			while(entering.getBooks().getSize() != 0) {
				String firstBookName = entering.getBooks().poll().getISBN();
				Book firstBook = catalog.get(firstBookName);
				if(firstBook.getAmount() > 0) {
					firstBook.setAmount(firstBook.getAmount()-1);
					catalog.changeValue(firstBookName,firstBook);
					auxiliar.offer(firstBook);
				}

				entering.setTimeW(entering.getTimeW()+1);
			}
			
			entering.setBooks(auxiliar);
			payLine.offer(entering);
		}
		startPaying();
	}
	
	private void startPaying() {
		Client Cashiers[] = new Client [cashierCapacity];
		boolean keepG = true;
		
		while(keepG) {
			keepG = false;
			for (int i = 0; i < Cashiers.length; i++) {
				if(Cashiers[i] == null) {
					Cashiers[i] = payLine.poll();
				}else{
					
				}
			}
		}
	}
}
