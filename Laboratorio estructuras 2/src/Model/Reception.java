package Model;
import MyEstructures.HashMap;
import MyEstructures.MyQueue;
import MyEstructures.PriorityQueue;
import MyEstructures.Queue;

public class Reception {
	private String rawData;
	private Queue<Client> clients;
	private HashMap<String,Book> catalog;
	private Queue<Library> librarys;
	private MyQueue<String> booksClients;
	private int testSimulation;
	private int cashRegister;
	private int shelf;
	private int index;
	private String allData[];
	
	
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
	private String result() {
		String result = "";
		int test =1;
		while(!librarys.empty()) {
			result += "prueba número "+ test +":\n"+ librarys.poll().Facture()+"\n"; 
			test++;
		}
		return result;
	}
	public String otherData() {
		allData=rawData.split("\n");
		testSimulation = Integer.parseInt(allData[0].trim());
		index = 0;
		for (int i = 0; i < testSimulation&& index< allData.length; i++) {
			 divideShelf();
			 librarys.offer(new Library(clients, catalog, cashRegister));
			 clients = new Queue<Client>();
			 catalog = new HashMap<String,Book>();
		}
		
		return result();
	}
	private void divideShelf() {
		cashRegister=Integer.parseInt(allData[++index].trim());
		shelf = Integer.parseInt(allData[++index].trim());
		for (int i = 0; i < shelf; i++) {
			divideBooks(i+1);
		}
		int numberClients = Integer.parseInt(allData[++index].trim());
		for (int i = 0; i < numberClients; i++) {
			addClients(i+1);
		}
	}
	private void divideBooks(int shelfActual) {
		int numberBooks = Integer.parseInt(allData[++index].split(" ")[1]);
		for (int i = 0; i < numberBooks; i++) {
			index++;
			String isbn = allData[index].split(" ")[0];
			double price = Double.parseDouble(allData[index].split(" ")[1]);
			int number = Integer.parseInt(allData[index].split(" ")[2]);
			catalog.put(isbn, new Book(isbn, price, numberBooks-i, shelfActual, number));
		}
	}
	private void addClients(int arrivalOrder){
		index++;
		String[] dataOrder = allData[index].split(" ");
		int id = Integer.parseInt(dataOrder[0]);
		PriorityQueue<Book> books = new PriorityQueue<>(true);
		for (int i = 1; i < dataOrder.length; i++) {
			if(catalog.get(dataOrder[i])!=null){
				books.offer(catalog.get(dataOrder[i]));
			}
		}
		clients.offer(new Client(books, id,arrivalOrder));
	}
}
