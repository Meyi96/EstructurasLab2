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
			String key = String.valueOf(((int)(Math.random()*3))+1)+"a";
			lib.put(key, new Book( key, (int)(Math.random()*1000), (int)(Math.random()*5), (int)(Math.random()*5), (int)(Math.random()*15)));
		}
		
		for (int i = 0; i < 10; i++) {
			PriorityQueue<Book> books = new PriorityQueue<>(true);
			for (int K = 0; K < 5; K++) {
				books.offer(new Book(String.valueOf(((int)(Math.random()*5)))+"a", 1000, 0, 0 ,0));
			}
			Clients.offer(new Client(books, (int)(Math.random()*1000) + 12, i));
		}

		testLib = new Library(Clients, lib, 3);
	}
	
	void scene2() {
		Queue<Client> Clients  = new Queue<>();
		
		HashMap<String,Book> lib = new HashMap<>();
		

		lib.put(new String("331"), new Book( "331", 17000, 4, 1 , 3));
		lib.put(new String("456"), new Book( "465", 60000, 3, 1 , 6));
		lib.put(new String("612"), new Book( "612", 80000, 2, 1 , 2));
		lib.put(new String("971"), new Book( "971", 70000, 1, 1 , 6));
		
		lib.put(new String("441"), new Book( "441", 30000, 5, 2 , 3));
		lib.put(new String("112"), new Book( "112", 22000, 4, 2 , 6));
		lib.put(new String("229"), new Book( "229", 28000, 3, 2 , 6));
		lib.put(new String("281"), new Book( "281", 38000, 2, 2 , 2));
		lib.put(new String("333"), new Book( "333", 43000, 1, 2 , 6));
		
		lib.put(new String("767"), new Book( "767", 40000, 2, 3 , 2));
		lib.put(new String("287"), new Book( "287", 65000, 1, 3 , 6));
		
		Client c;
		PriorityQueue<Book> books1 = new PriorityQueue<>(true);
		books1.offer(new Book( "287", 65000, 1, 3 , 6));
		books1.offer(new Book( "612", 65000, 1, 3 , 6));
		c = new Client(books1,1627,1);
		Clients.offer(c);
		
		books1 = new PriorityQueue<>(true);
		books1.offer(new Book( "612", 65000, 1, 3 , 6));
		books1.offer(new Book( "333", 65000, 1, 3 , 6));
		books1.offer(new Book( "287", 65000, 1, 3 , 6));
		books1.offer(new Book( "456", 65000, 1, 3 , 6));
		c = new Client(books1,3456,2);
		Clients.offer(c);
		
		books1 = new PriorityQueue<>(true);
		books1.offer(new Book( "287", 65000, 1, 3 , 6));
		c = new Client(books1,3219,3);
		Clients.offer(c);
		
		books1 = new PriorityQueue<>(true);
		books1.offer(new Book( "767", 65000, 1, 3 , 6));
		books1.offer(new Book( "287", 65000, 1, 3 , 6));
		books1.offer(new Book( "229", 65000, 1, 3 , 6));
		books1.offer(new Book( "971", 65000, 1, 3 , 6));
		c = new Client(books1,3311,4);
		Clients.offer(c);
		
		books1 = new PriorityQueue<>(true);
		books1.offer(new Book( "331", 65000, 1, 3 , 6));
		c = new Client(books1,2100,5);
		Clients.offer(c);

		testLib = new Library(Clients, lib, 3);
	}
	
	void scene3() {
		Queue<Client> Clients  = new Queue<>();
		
		HashMap<String,Book> lib = new HashMap<>();
		

		lib.put(new String("331"), new Book( "331", 17000, 4, 1 , 3));
		lib.put(new String("456"), new Book( "465", 60000, 3, 1 , 6));
		lib.put(new String("612"), new Book( "612", 80000, 2, 1 , 2));
		lib.put(new String("971"), new Book( "971", 70000, 1, 1 , 6));
		
		lib.put(new String("441"), new Book( "441", 30000, 5, 2 , 3));
		lib.put(new String("112"), new Book( "112", 22000, 4, 2 , 6));
		lib.put(new String("229"), new Book( "229", 28000, 3, 2 , 6));
		lib.put(new String("281"), new Book( "281", 38000, 2, 2 , 2));
		lib.put(new String("333"), new Book( "333", 43000, 1, 2 , 6));
		
		lib.put(new String("767"), new Book( "767", 40000, 2, 3 , 2));
		lib.put(new String("287"), new Book( "287", 65000, 1, 3 , 6));
		
		Client c;
		PriorityQueue<Book> books1 = new PriorityQueue<>(true);
		books1.offer(new Book( "287", 65000, 1, 3 , 6));
		books1.offer(new Book( "612", 65000, 1, 3 , 6));
		c = new Client(books1,1627,1);
		Clients.offer(c);
		
		books1 = new PriorityQueue<>(true);
		books1.offer(new Book( "612", 65000, 1, 3 , 6));
		books1.offer(new Book( "333", 65000, 1, 3 , 6));
		books1.offer(new Book( "287", 65000, 1, 3 , 6));
		books1.offer(new Book( "456", 65000, 1, 3 , 6));
		c = new Client(books1,3456,2);
		Clients.offer(c);
		
		books1 = new PriorityQueue<>(true);
		books1.offer(new Book( "287", 65000, 1, 3 , 6));
		c = new Client(books1,3219,3);
		Clients.offer(c);
		
		books1 = new PriorityQueue<>(true);
		books1.offer(new Book( "767", 65000, 1, 3 , 6));
		books1.offer(new Book( "287", 65000, 1, 3 , 6));
		books1.offer(new Book( "229", 65000, 1, 3 , 6));
		books1.offer(new Book( "971", 65000, 1, 3 , 6));
		c = new Client(books1,3311,4);
		Clients.offer(c);
		
		books1 = new PriorityQueue<>(true);
		books1.offer(new Book( "331", 65000, 1, 3 , 6));
		c = new Client(books1,2100,5);
		Clients.offer(c);

		testLib = new Library(Clients, lib, 3);
	}
	
	
	@Test
	void test0() {
		scene2();
		
		System.out.println("OUT: \n" + testLib.Facture());
		System.out.println();
	}
	
	@Test
	void test1() {
		scene1();
		
		System.out.println("OUT: \n" + testLib.Facture());
		System.out.println();
	}
	
	@Test
	void test2() {
		scene3();
		
		System.out.println("OUT: \n" + testLib.Facture());
		System.out.println();
	}

}
