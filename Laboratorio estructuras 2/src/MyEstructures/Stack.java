package MyEstructures;

public class Stack<E> implements MyStack<E>{
	
	Node<E> first;
	Node<E> Last;
	
	public Stack() {
		first = null;
	}

	@Override
	public void push(E obj) {
		if(first != null) {
			Node <E> c = new Node<E>(obj);
			c.addBefore(first);
			first = c;
		}else {
			first = new Node<E>(obj);
		}
		
	}

	@Override
	public E pop() {
		if(first != null) {
			E ref = (E) first.getInfo();
			first = first.before;
			return ref;
		}else {
			return null;
		}
	}

	@Override
	public E top() {
		if(first != null) {
			E ref = (E) first.getInfo();
			return ref;
		}else {
			return null;
		}
	}



}
