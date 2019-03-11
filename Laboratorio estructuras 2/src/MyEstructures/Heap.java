package MyEstructures;

public class Heap<V> implements MyHeap<V>{
	protected Object elements[];
	public int size;
	private int maxSize = 1000001;
	// true Max - false Min
	protected boolean type;
	
	public Heap (boolean Type) {
		elements = new Object[maxSize];
		size = 1;
		type =  Type;
	}

	@Override
	public void add(V element) {
		if(size == 1) {
			elements[1] = element;
			size++;
		}else {
			elements[size] = element;
			maxHeapifyUp(size);
		}
		
	}
	

	private void maxHeapifyUp(int size2) {
		if((int)(elements[size2]) > (int)(elements[getParent(size2)])) {
			V aux = (V) elements[size2];
			elements[size2] = elements[getParent(size2)];
			elements[getParent(size2)] = aux;
			maxHeapifyUp(getParent(size2));
		}else {
			maxHeapifyDown(size2);
		}
	}
	
	private void maxHeapifyDown(int size2) {
		double right = (double)(elements[getRight(size2)]);
		double left = (double)(elements[getLeft(size2)]);
		double winner = 0;
		int dir = 0;
		if(right > left) {
			winner = right;
			dir = getRight(size2);
		}else {
			winner = left;
			dir = getLeft(size2);
		}
		
		if((double)(elements[size2]) < winner) {
			V aux = (V) elements[size2];
			elements[size2] = elements[dir];
			elements[getParent(size2)] = aux;
			maxHeapifyDown(dir);
		}
	}	

	private int getParent(int i) {
		return (int)Math.floor(i/2);
	}
	
	private int getLeft(int i) {
		return (int)Math.floor(i*2);
	}
	
	private int getRight(int i) {
		return (int)Math.floor(i*2 + 1);
	}
	
	
	@Override
	public V obtain(V element) {
		V out = (V)elements[1];
		elements[1] = elements[size];
		elements[size] = Double.MIN_VALUE;
		size--;
		maxHeapifyUp(1);
		return out;
		
	}

	@Override
	public void buidHeap(V[] Nelemnts, boolean type) {
		
		elements = new Number[maxSize];
		size = 0;
		
		for (int i = 0; i < Nelemnts.length; i++) {
			add(Nelemnts[i]);
		}
		
	}

	@Override
	public V getTop() {
		V out = (V)elements[1];
		return out;
	}

	@Override
	public void haepSort(V arr[]) {
		
		Heap<V> aux = new Heap<>(true);
		
		for (int i = 0; i < arr.length; i++) {
			aux.add(arr[i]);
		}
		
		arr = ((V[])aux.getElements()).clone();
	}

	public Object[] getElements() {
		return elements;
	}

	public void setElements(Number[] elements) {
		this.elements = elements;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
}
