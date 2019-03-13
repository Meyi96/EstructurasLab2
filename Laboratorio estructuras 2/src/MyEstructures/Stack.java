package MyEstructures;

public class Stack<E> implements MyStack<E>{
	
	private Node<E> first;
	private Node<E> Last;
	private int size;
	
	public Stack() {
		first = null;
		size = 0;
	}

	@Override
	public void push(E obj) {
		size++;
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
		size--;
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

	public int getSize() {
		return size;
	}

}
