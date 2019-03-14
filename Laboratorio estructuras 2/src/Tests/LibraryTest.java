package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

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
			lib.put(key, new Book( key, 1000, (int)(Math.random()*5), (int)(Math.random()*5), (int)(Math.random()*10)));
		}
		
		for (int i = 0; i < 10; i++) {
			PriorityQueue<Book> books = new PriorityQueue<>(true);
			for (int K = 0; K < 4; K++) {
				books.offer(new Book(String.valueOf(((int)(Math.random()*5))), 1000, 0, 0 ,0));
			}
			Clients.offer(new Client(books, (int)(Math.random()*1000), 0));
		}

		testLib = new Library(Clients, lib, 3);
	}
	
	void scene2() {
		Queue<Client> Clients  = new Queue<>();
		
		HashMap<String,Book> lib = new HashMap<>();
		

		String key = "1";
		lib.put(new String("1"), new Book( key, 1000, 1, 1, 10));
		key = "0";
		lib.put(new String("0"), new Book( key, 1000, 1, 4 , 10));
		key = "2";
		lib.put(new String("2"), new Book( key, 1000, 2, 2 , 10));
		key = "3";
		lib.put(new String("3"), new Book( key, 1000, 3, 3 , 10));
		key = "4";
		lib.put(new String("4"), new Book( key, 1000, 3, 4 , 10));
		key = "5";
		lib.put(new String("5"), new Book( key, 1000, 2, 5 , 10));

		PriorityQueue<Book> books1;
		Book b;
		for (int i = 0; i < 10; i++) {
			books1 = new PriorityQueue<>(true);
			for (int K = 0; K < 4; K++) {
				String k = String.valueOf(((int)(Math.random()*5))+1);
				b = new Book(k, 1000, 0, 0 , 0);
				books1.offer(b);
			}
			
			Client c = new Client(books1, (int)(Math.random()*1000)+1, 0);
			
			Clients.offer(c);
		}

		testLib = new Library(Clients, lib, 8);
	}
	
	@Test
	void test() {
		scene2();
		
		System.out.println("OUT: \n" + testLib.Facture());
	}

}
