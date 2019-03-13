package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Book;
import Model.Client;
import Model.Library;
import MyEstructures.HashMap;
import MyEstructures.PriorityQueue;
import MyEstructures.Queue;

class LibraryTest {
	Library testLib;
	void scene1() {
		Queue<Client> Clients  = new Queue<>();
		
		HashMap<String,Book> lib = new HashMap<>();
		
		for (int K = 0; K < 4; K++) {
			String key = String.valueOf(((int)(Math.random()*5)));
			lib.put(key, new Book( key, 1000, (int)(Math.random()*5), (int)(Math.random()*5)));
		}
		
		for (int i = 0; i < 10; i++) {
			PriorityQueue<Book> books = new PriorityQueue<>(true);
			for (int K = 0; K < 4; K++) {
				books.offer(new Book(String.valueOf(((int)(Math.random()*5))), 1000, 0, 0));
			}
			Clients.offer(new Client(books, (int)(Math.random()*1000), 0));
		}

		testLib = new Library(Clients, lib, 3);
	}
	
	void scene2() {
		Queue<Client> Clients  = new Queue<>();
		
		HashMap<String,Book> lib = new HashMap<>();
		

		String key = "1";
		lib.put(key, new Book( key, 1000, 1, 1));
		key = "0";
		lib.put(key, new Book( key, 1000, 1, 4));
		key = "2";
		lib.put(key, new Book( key, 1000, 2, 2));
		key = "3";
		lib.put(key, new Book( key, 1000, 3, 3));
		key = "4";
		lib.put(key, new Book( key, 1000, 3, 4));
		key = "5";
		lib.put(key, new Book( key, 1000, 2, 5));
		
		for (int i = 0; i < 10; i++) {
			PriorityQueue<Book> books = new PriorityQueue<>(true);
			for (int K = 0; K < 4; K++) {
				books.offer(new Book(String.valueOf(((int)(Math.random()*5))), 1000, 0, 0));
			}
			Clients.offer(new Client(books, (int)(Math.random()*1000), 0));
		}

		testLib = new Library(Clients, lib, 2);
	}
	
	@Test
	void test() {
		scene1();
		
		System.out.println("OUT " + testLib.Facture());
	}

}
