package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import MyEstructures.MyQueue;
import MyEstructures.Queue;
import exceptions.InputNullException;
import exceptions.NoCashRegisterException;
import exceptions.NullClientsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.Main;

public class SimulatorBibliotecaController  implements Initializable{
	
	@FXML
    private TextField numberCashRegister;
    @FXML
    private TextArea listClients;
    @FXML
    private TextArea result;
    @FXML
    private TextArea result1;
    @FXML
    private TextArea inputDate;
    @FXML
    private Button SimulationButton;
    private int cashRegister;
    private String data;
    private int numberClients;
    
    @FXML
    void goInterface(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/SimulatorBiblioteca.fxml"));
    	Parent viewCampo = loader.load();
    	Scene scene = new Scene(viewCampo);
    	Stage windowCampo = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	windowCampo.setScene(scene);
    	windowCampo.show();
    }
    @FXML
    void goSimulationInputt(ActionEvent event) throws IOException {
    	result1.setVisible(true);
    	if(inputDate.getText().equals("")) {
    		try {
				throw new InputNullException();
			} catch (InputNullException e) {
				message(e);
			}
    	}else {
    		Main.getReception().setRawData(inputDate.getText());
    		result1.setText(Main.getReception().otherData());
    	}
    }
    @FXML
    void inputButton(ActionEvent event) {
    	inputDate.setVisible(true);
    	SimulationButton.setVisible(true);
    }
    @FXML
    void createClient(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/NewClient.fxml"));
    	Parent viewCampo = loader.load();
    	Scene scene = new Scene(viewCampo);
    	Stage windowCampo = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	windowCampo.setScene(scene);
    	windowCampo.show();
    }
    @FXML
    void goSimulation(ActionEvent event) throws IOException {
    	if(isCashregister()) {
    		data += cashRegister+"\n"+readDate();
    		addClientsData();
    		Main.getReception().setRawData(data);
    		result.setText(Main.getReception().otherData());
    	}
    }
	@FXML
    void lessCashRegister(ActionEvent event) {
    	if(cashRegister>1) { 
    		cashRegister--;
    		numberCashRegister.setText(cashRegister+"");
    	}
    }
    @FXML
    void moreCashRegister(ActionEvent event) {
    	if(cashRegister<10) { 
    		cashRegister++;
    		numberCashRegister.setText(cashRegister+"");
    	}
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cashRegister = 0;
		data = "1\n";
		searchClientsDada();
	}
	private boolean isCashregister() {
		if(cashRegister == 0) {
			try {
				throw new NoCashRegisterException();
			} catch (NoCashRegisterException e) {
				message(e);
			}
			return false;
		}else if(listClients.getText().equals("")){
			try {
				throw new NullClientsException();
			} catch (NullClientsException e) {
				message(e);
			}
			return false;
		}else
			return true;
	}
	private void message(Exception e) {
		JOptionPane.showMessageDialog(null,e.getMessage());
	}
	private String readDate() throws IOException {
		File file = new File("./Persistencia/books.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fileReader);
		String stop = buffer.readLine();
		String data="";
		while(stop!=null) {
			data += stop+"\n";
			stop = buffer.readLine();
		}
		return data;
	}
	private void searchClientsDada() {
		int nClients =1;
		MyQueue<String> auxi = new Queue<String>();
		while(!Main.getReception().getBooksClients().empty()) {
			listClients.setText(listClients.getText()+"Cliente: "+nClients+
					"\n"+Main.getReception().getBooksClients().peek()+"\n");
			nClients++;
			auxi.offer(Main.getReception().getBooksClients().poll());
		}
		numberClients = --nClients;
		Main.getReception().setBooksClients((Queue<String>) auxi);
	}
	private void addClientsData() {
		data += numberClients+"\n";
		while(!Main.getReception().getBooksClients().empty()) {
			data += Main.getReception().getBooksClients().poll()+"\n";
		}
	}
}
