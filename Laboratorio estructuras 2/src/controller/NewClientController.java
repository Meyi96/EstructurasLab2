package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import exceptions.idNullException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.Main;

public class NewClientController implements Initializable {

	@FXML
	private TextField idClient;
    @FXML
    private TextArea ListBook;
    @FXML
    private ComboBox<String> books;
    private ArrayList<String> booksArray;
    
    @FXML
    void addClient(ActionEvent event) throws IOException {
    	if(verificarId()) {
    		Main.getReception().getBooksClients().offer(idClient.getText()+" "+ListBook.getText());
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(getClass().getResource("/view/SimulatorBiblioteca.fxml"));
        	Parent viewCampo = loader.load();
        	Scene scene = new Scene(viewCampo);
        	Stage windowCampo = (Stage) ((Node) event.getSource()).getScene().getWindow();
        	windowCampo.setScene(scene);
        	windowCampo.show();
    	}
    }
    @FXML
    void cleanDates(ActionEvent event) {
    	ListBook.setText("");
    	searchData();
    }
    @FXML
    void goReturn(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/SimulatorBiblioteca.fxml"));
    	Parent viewCampo = loader.load();
    	Scene scene = new Scene(viewCampo);
    	Stage windowCampo = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	windowCampo.setScene(scene);
    	windowCampo.show();
    }
    @FXML
    void goBooks(ActionEvent event) {
    	if(books.getSelectionModel().getSelectedIndex()!=-1) {
    		if(!books.getSelectionModel().getSelectedItem().equals("Estanteria A")&&
    		!books.getSelectionModel().getSelectedItem().equals("Estanteria B")&&
    		!books.getSelectionModel().getSelectedItem().equals("Estanteria C")) {
    			ListBook.setText(ListBook.getText()+books.getSelectionModel().getSelectedItem()+" ");
        		booksArray.remove(books.getSelectionModel().getSelectedIndex());
    		}
    	}
    }
    @FXML
    void pushBook(MouseEvent event) {
    	books.getItems().clear();
    	books.getItems().addAll(booksArray);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		searchData();
	}
	private void searchData() {
		String[] a ={"Estanteria A","234","147","731","Estanteria B","385",
				     "629","204","484","Estanteria c","984","215","532"};
		booksArray = new ArrayList<>(Arrays.asList(a)); ;
		books.getItems().addAll(booksArray);
	}
	private boolean verificarId() {
		if(idClient.getText().equals("")|| ListBook.getText().equals("")) {
			try {
				throw new idNullException();
			} catch (idNullException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
			return false;
		}else
			return true;
	}
}
