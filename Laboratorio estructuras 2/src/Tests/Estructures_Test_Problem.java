package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Book;
import MyEstructures.HashMap;
import MyEstructures.PriorityQueue;
import MyEstructures.Queue;
import MyEstructures.Stack;
import junit.framework.Assert;

class Estructures_Test_Problem {
	HashMap<String,Book> lib;
	PriorityQueue<Book> books;
	Queue<Book> books2;
	Stack<Book> Sbooks;
	
	void setup1() {
		lib = new HashMap<>();
		
		lib.put(new String("331"), new Book( "331", 17000, 4, 1 , 3));
		lib.put(new String("456"), new Book( "465", 60000, 3, 1 , 6));
		lib.put(new String("612"), new Book( "612", 80000, 2, 1 , 2));
		lib.put(new String("971"), new Book( "971", 70000, 1, 1 , 6));
	}
	
	
	void setup2() {
		books = new PriorityQueue<>(true);
		for (int K = 0; K < 5; K++) {
			books.offer(new Book(String.valueOf(((int)(Math.random()*5)))+"a", 1000, K, K ,0));
		}
	}
	
	void setup3() {
		books = new PriorityQueue<>(true);
		books.offer(new Book(String.valueOf(((int)(Math.random()*5)))+"a", 1000, 0, 0 ,0));
	}

	void setup4() {
		books = new PriorityQueue<>(true);
		books.offer(new Book(String.valueOf(((int)(Math.random()*5)))+"a", 1000, 0, 0 ,0));
		books.offer(new Book(String.valueOf(((int)(Math.random()*5)))+"a", 1000, 1, 0 ,1));
	}
	
	void setup5() {
		books2 = new Queue<>();
	}
	
	void setup6() {
		books2 = new Queue<>();
	}
	
	@Test
	void test1() {
		setup1();
		if(lib.get("331") == null) {
			fail("This book exist");
		}else {
			assertTrue(true);
		}
		
		if(lib.get("332") != null) {
			fail("This book doesn´t exist");
		}else {
			assertTrue(true);
		}
	}
	
	@Test
	void test2() {
		setup1();
		lib.changeValue("331", new Book( "331", 18000, 4, 1 , 3));
		if(lib.get("331").getPrice() == 17000) {
			fail("This book didnt change");
		}else {
			assertTrue(true);
		}
		
		lib.changeValue("332", new Book( "332", 18001, 4, 1 , 3));
		
		if(lib.get("332") != null && lib.get("332").getPrice() == 18001) {
			assertTrue(true);
		}else {
			fail("This book should exist");
		}
	}
	
	@Test
	void test3() {
		setup1();
		if(lib.contains("331") == false) {
			fail("This book should exist");
		}else {
			assertTrue(true);
		}
		
		
		if(lib.contains("332") == false) {
			assertTrue(true);
		}else {
			fail("This book does not exists");
		}
	}
	
	@Test
	void test4() {
		setup1();
		if(lib.delete("331") == false) {
			fail("This book exist");
		}else {
			assertTrue(true);
		}
		
		if(lib.contains("331") != false) {
			fail("This book should not exist");
		}else {
			assertTrue(true);
		}
		
		if(lib.delete("332") == false) {
			assertTrue(true);
		}else {
			fail("This book should exists");
		}
	}
	
	@Test
	void test6() {
		setup1();
		lib.put("2", new Book("2",0.0,0,0,0));
		if(lib.get("2") == null) {
			fail("This book exist");
		}else {
			assertTrue(true);
		}
		
		lib.put("311", new Book("311",0.0,0,0,0));
		
		if(lib.get("331").getPrice() == 0) {
			fail("This book shouldn't be this one");
		}else {
			assertTrue(true);
		}
	}
	
	@Test
	void test7() {
		setup2();
		int a = books.getSize();
		books.offer(new Book("2",0.0,0,0,0));
		if(books.getSize() != a+1) {
			fail("Did not add");
		}else {
			assertTrue(true);
		}
		
		books.offer(new Book("2",0.0,0,-1,-1));
		
		if(books.poll().getAmount() != -1) {
			fail("Did not add correctly");
		}else {
			assertTrue(true);
		}
	}
	
	@Test
	void test8() {
		setup3();
		if(books.peek().getAmount() != 0) {
			fail("Does exist");
		}else {
			assertTrue(true);
		}
		
		
		if(books.poll().getAmount() != 0) {
			fail("Did not extract correctly");
		}else {
			assertTrue(true);
		}
		
		if(books.poll() != null) {
			fail("Did not extract correctly");
		}else {
			assertTrue(true);
		}
	}
	
	@Test
	void test9() {
		setup4();
		if(books.poll().getAmount() != 0) {
			fail("Did not extract correctly");
		}else {
			assertTrue(true);
		}
		
		
		if(books.poll().getAmount() != 1) {
			fail("Did not extract correctly");
		}else {
			assertTrue(true);
		}
		
		if(books.poll() != null) {
			fail("Did not extract correctly");
		}else {
			assertTrue(true);
		}
	}
	
	@Test
	void test10() {
		setup5();
		books2.offer(new Book(String.valueOf(((int)(Math.random()*5)))+"a", 1000, 0, 0 ,0));
		
		if(books2.getSize() != 1) {
			fail("Did not add correctly");
		}else {
			assertTrue(true);
		}

		books2.offer(new Book(String.valueOf(((int)(Math.random()*5)))+"a", 1000, 1, 0 ,1));
		
		if(books2.getSize() != 2) {
			fail("Did not add correctly");
		}else {
			assertTrue(true);
		}
		
		if(books2.poll().getAmount() != 0) {
			fail("Did not add correctly");
		}else {
			assertTrue(true);
		}
	}
	
	@Test
	void test11() {
		setup5();
		books2.offer(new Book(String.valueOf(((int)(Math.random()*5)))+"a", 1000, 0, 0 ,0));
		
		if(books2.getSize() != 1 && books2.peek().getAmount() != 0) {
			fail("Did not add correctly");
		}else {
			assertTrue(true);
		}
		
		if(books2.poll() == null) {
			fail("Did not extract correctly");
		}else {
			assertTrue(true);
		}
		
		if(books2.poll() != null) {
			fail("Did not extract correctly");
		}else {
			assertTrue(true);
		}
	}
	
	@Test
	void test12() {
		setup5();
		books2.offer(new Book(String.valueOf(((int)(Math.random()*5)))+"a", 1000, 0, 0 ,0));

		books2.offer(new Book(String.valueOf(((int)(Math.random()*5)))+"a", 1000, 1, 0 ,1));
		
		if(books2.getSize() != 1 && books2.poll().getAmount() != 0) {
			fail("Did not add correctly");
		}else {
			assertTrue(true);
		}
		
		if(books2.poll() == null) {
			fail("Did not extract correctly");
		}else {
			assertTrue(true);
		}
		
		if(books2.poll() != null) {
			fail("Did not extract correctly");
		}else {
			assertTrue(true);
		}
	}
	
	@Test
	void test13() {
		setup6();
		
	}
	
	@Test
	void test14() {
		setup6();
		
	}
	
	@Test
	void test15() {
		setup6();
		
	}

}
