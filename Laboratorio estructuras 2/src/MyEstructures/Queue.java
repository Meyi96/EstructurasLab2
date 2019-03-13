package MyEstructures;

public class Queue<E> implements MyQueue<E>{
	
	private Node<E> first;
	private Node<E> Last;
	private int size;
	
	public Queue() {
		first = null;
		Last = null;
	}
	
	@Override
	public void offer(E obj) {
		size++;
		if(Last != null && first != null) {
			Node<E> ref= new Node<E>(obj);
			Last.addBefore(ref);
			ref.addNext(Last);
			Last = ref;
		}else if(first == null && Last == null) {
			first = new Node<E>(obj);
		}else if(Last == null){
			Node<E> ref= new Node<E>(obj);
			ref.addNext(first);
			Last = ref;
			first.addBefore(Last);
		}
		
	}

	@Override
	public E poll() {
		size--;
		if(first == null && Last == null) {
			return null;
		}
		
		if(first != null) {
			E ref = (E) first.getInfo();
			first = first.before;
			return ref;
		}else if(Last.next == null) {
			E ref = Last.getInfo();
			Last = null;
			return ref;
		}
		
		return null;
		
	}

	@Override
	public E peek() {
		if(first == null && Last == null) {
			return null;
		}
		
		if(first != null) {
			E ref = (E) first.getInfo();
			return ref;
		}else if(Last.next == null) {
			E ref = Last.getInfo();
			return ref;
		}
		
		return null;
	}

	public int getSize() {
		return size;
	}
}
