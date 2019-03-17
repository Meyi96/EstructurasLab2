package Model;

import java.util.Arrays;

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
//				System.out.print(" FOUND: "+ firstBookName + "  " + firstBook + " ");
				
				if(firstBook != null && firstBook.getAmount() > 0) {
					firstBook.setAmount(firstBook.getAmount()-1);
					catalog.changeValue(firstBookName,firstBook);
					auxiliar.offer(firstBook);
				}
//				System.out.println();
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
		int minutes[] = new int[cashierCapacity];
		int a = 0;
		while(keepG || a<=1) {
			keepG = false;
			a++;
			for (int i = 0; i < Cashiers.length; i++) {
				if(Cashiers[i] == null) {
					if(payLine.getSize() > 0) {
						Cashiers[i] = payLine.poll();
						minutes[i] = Cashiers[i].getBooks().getSize(); 
						keepG = true;
					}
				}else{
					if(minutes[i] - 1 <= 0) {
						payingOut.offer(Cashiers[i]);
						Cashiers[i] = null;
						minutes[i] = 0;
					}else {
						minutes[i] = minutes[i]-1;
					}
					keepG = true;
				}
			}
//			System.out.println("Out 1 "+ Arrays.toString(Cashiers));
//			System.out.println("Out 2 "+ Arrays.toString(minutes));
//			System.out.println("No Stop " + " " + keepG	+ " " + a);
		}
		
	}

	public String Facture() {
		StringBuilder out = new StringBuilder();
		while(payingOut.getSize() != 0) {
			Client actual = payingOut.poll();
			String bill = actual.getBill();
			out.append(actual.getiD() + bill);
		}
		return out.toString();
	}
}
