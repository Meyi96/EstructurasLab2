package Model;
import MyEstructures.HashMap;
import MyEstructures.MyQueue;
import MyEstructures.MyStack;
import MyEstructures.PriorityQueue;
import MyEstructures.Queue;

public class Reception {
	private String rawData;
	private Queue<Client> clients;
	private HashMap<String,Book> catalog;
	private Queue<Library> librarys;
	private MyQueue<String> booksClients;
	private int testSimulation;
	
	
	public Reception() {
		booksClients =  new Queue<String>();
		librarys = new Queue<>();
		catalog = new HashMap<>();
		clients = new Queue<>();
	}
	
	public Queue<String> getBooksClients(){
		return  (Queue<String>) booksClients;
	}
	
	public void setBooksClients(Queue<String> auxi) {
		booksClients = auxi;
	}

	public String getRawData() {
		return rawData;
	}

	public void setRawData(String rawData) {
		this.rawData = rawData;
	}
	public void divideData() {
		String allData[]=rawData.split("\n");
		testSimulation = Integer.parseInt(allData[0]);
		for (int i = 1; i+1 < allData.length; i++) {
			if(allData[i].split(" ").length ==1 && allData[i+1].split(" ").length ==1) {
				for (int j = i+1; j+1 < allData.length; j++) {
					if(allData[j].split(" ").length ==1 && allData[j+1].split(" ").length ==1) {
						createLibrary(allData, i, j-1);
					}else if(j+1 == allData.length-1 &&allData[allData.length-1].split(" ").length !=1){
						createLibrary(allData, i, j-1);
					}
				}
			}
		}
	}
	
	public void createLibrary(String[] data, int start, int end) {
		int cashRegister = Integer.parseInt(data[start]);
//		int shelving =  Integer.parseInt(data[start+1]);
		int height =0;
		int depth =0;
		int clients = 0;
		boolean change = false;
		for (int i = start+2; i <=end ; i++) {
			if(data[i].split(" ").length>1 && !change) {
				if(data[i].split(" ").length==2 ) {
					System.out.println("cantidad de libros");
					height = 0;
					depth++;
				}else {
					height++;
					String isbn = data[i].split(" ")[0];
					double price = Double.parseDouble(data[i].split(" ")[1]);
					int amount = Integer.parseInt(data[i].split(" ")[2]);
					System.out.println("libros de la repisa altura "+height+" profundo "+depth);
					catalog.put(isbn, new Book(isbn, price,amount, height, depth));
				}
			}else if(data[i].split(" ").length==1){
				System.out.println("cuantos clientes");
				clients = Integer.parseInt(data[i]);
				change = true;
			}else {
				System.out.println("cleinte");
				String[] orderClient = data[i].split(" ");
				PriorityQueue<Book> books = new PriorityQueue<>(true);
				for (int j = 1; j < orderClient.length; j++) {
					System.out.println(catalog.get(orderClient[j])+" no encontre");
					if(catalog.get(orderClient[j])!=null) {
						System.out.println(catalog.get(orderClient[j]));
						books.offer(catalog.get(orderClient[j]));
					}
				}
				this.clients.offer(new Client(books, Integer.parseInt(orderClient[0]), 0));
			}
		}
		librarys.offer(new Library(this.clients, catalog, cashRegister));
		this.clients = new Queue<Client>();
		catalog = new HashMap<String,Book>();
	}

	
	
	
}
