package Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import MyEstructures.HashMap;
import MyEstructures.Heap;
import MyEstructures.Queue;
import MyEstructures.Stack;

class Estructures_test {

	@Test
	void testQueue1() {
		Queue<Integer> Q = new Queue<>();
		Q.offer(3);
		Q.offer(4);
		Q.offer(5);
		Q.offer(77);
		if(Q.poll() == 3) {
			assertTrue(true);
		}else {
			fail("Not yet implemented");
		}
		if(Q.poll() == 4) {
			assertTrue(true);
		}else {
			fail("Not yet implemented");
		}
		if(Q.poll() == 5) {
			assertTrue(true);
		}else {
			fail("Not yet implemented");
		}
		if(Q.poll() == 77) {
			assertTrue(true);
		}else {
			fail("Not yet implemented");
		}
		if(Q.poll() == null) {
			assertTrue(true);
		}else {
			fail("LOL");
		}
	}
	
	@Test
	void testStack1() {
		Stack<Integer> S = new Stack<>();
		S.push(3);
		S.push(5);
		S.push(7);
		int a = S.pop();
		if(a == 7) {
			assertTrue(true);
		}else {
			fail("Therr is no honor");
		}
		
		a = S.pop();
		
		if(a == 5) {
			assertTrue(true);
		}else {
			fail("Therr is no honor");
		}
		S.push(7);
		a = S.pop();
		
		if(a == 7) {
			assertTrue(true);
		}else {
			fail("Therr is no honor");
		}
	}
	
	@Test
	void TestHashMap1() {
		HashMap<Integer,String> HM = new HashMap<>();
		HM.put(2, "LOL");
		HM.put(4, "LOL2");
		HM.put(5, "LOL4");
		if(HM.get(2) == "LOL") {
			assertTrue(true);
		}else {
			fail("Me la jugue");
		}
		if(HM.get(5) == "LOL4") {
			assertTrue(true);
		}else {
			fail("Me la jugue");
		}
	}

	@Test
	void TestHeap1() {
		Integer lol = new Integer(2);
		Integer lol2 = new Integer(3);
		Heap<Integer> HP = new Heap<>(true);
		HP.add(new Integer(4));
		HP.add(new Integer(2));
		HP.add(new Integer(5));
		HP.add(new Integer(1));
		HP.add(new Integer(50));
		
		if(HP.obtain() == 50) {
			assertTrue(true);
		}else {
			fail("Me la jugue");
		}
		if(HP.obtain() == 5) {
			assertTrue(true);
		}else {
			fail("Me la jugue");
		}
		
		if(HP.obtain() == 4) {
			assertTrue(true);
		}else {
			fail("Me la jugue");
		}
		
		if(HP.getTop() == 2) {
			assertTrue(true);
		}else {
			fail("Me la jugue");
		}
		
		if(HP.obtain() == 2) {
			assertTrue(true);
		}else {
			fail("Me la jugue");
		}
		
		if(HP.obtain() == 1) {
			assertTrue(true);
		}else {
			fail("Me la jugue");
		}
		
		if(HP.obtain() == null) {
			assertTrue(true);
		}else {
			fail("Me la jugue");
		}
	}
}
