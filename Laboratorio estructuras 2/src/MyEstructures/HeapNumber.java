package MyEstructures;

public class HeapNumber<V extends Number> implements MyHeap<V>{
	
	protected Number elements[];
	public int size;
	private int maxSize = 1000001;
	// true Max - false Min
	protected boolean type;
	
	public HeapNumber (boolean Type) {
		elements = new Number[maxSize];
		if(Type) {
			for (int i = 0; i < elements.length; i++) {
				elements[i] = Double.MIN_VALUE;
			}
		}else {
			for (int i = 0; i < elements.length; i++) {
				elements[i] = Double.MAX_VALUE;
			}
		}
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
			if(type) {
				maxHeapifyUp(size);
			}else {
				minHeapifyUp(size);
			}
		}
		
	}
	
	private void minHeapifyUp(int size2) {
		if((int)(elements[size2]) < (int)(elements[getParent(size2)])) {
			V aux = (V) elements[size2];
			elements[size2] = elements[getParent(size2)];
			elements[getParent(size2)] = aux;
			maxHeapifyUp(getParent(size2));
		}else {
			minHeapifyDown(size2);
		}
	}

	private void minHeapifyDown(int size2) {
		double right = (double)(elements[getRight(size2)]);
		double left = (double)(elements[getLeft(size2)]);
		double winner = 0;
		int dir = 0;
		if(right < left) {
			winner = right;
			dir = getRight(size2);
		}else {
			winner = left;
			dir = getLeft(size2);
		}
		
		if((double)(elements[size2]) > winner) {
			V aux = (V) elements[size2];
			elements[size2] = elements[dir];
			elements[getParent(size2)] = aux;
			maxHeapifyDown(dir);
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
		if(type) {
			maxHeapifyUp(1);
		}else {
			minHeapifyDown(1);
		}
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
		
		HeapNumber<V> aux = new HeapNumber<>(true);
		
		for (int i = 0; i < arr.length; i++) {
			aux.add(arr[i]);
		}
		
		arr = ((V[])aux.getElements()).clone();
	}

	public Number[] getElements() {
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
