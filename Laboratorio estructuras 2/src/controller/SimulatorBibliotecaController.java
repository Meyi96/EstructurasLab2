package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SimulatorBibliotecaController  implements Initializable{
	
	@FXML
    private TextField numberCashRegister;

    @FXML
    private ListView<?> listClients;

    @FXML
    private TextArea result;
    private int cashRegister;

    @FXML
    void createClient(ActionEvent event) {

    }

    @FXML
    void deleteClient(ActionEvent event) {

    }

    @FXML
    void goSimulation(ActionEvent event) {

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
    	if(cashRegister<4) { 
    		cashRegister++;
    		numberCashRegister.setText(cashRegister+"");
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cashRegister = 1;
		
		
	}
}
