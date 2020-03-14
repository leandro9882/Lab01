package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */

import java.util.*;
import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.Parolearray;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Parole elenco;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextArea txtTime;
    
    @FXML
    private TextField txtError;

    @FXML
    private Button btmCanc;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	double start=System.nanoTime();
    	String pattern = "[a-zA-Z ]*";
    	String parola=txtParola.getText();
    	if(!parola.matches(pattern)) {
    		this.txtParola.clear();
    		this.txtError.setText("Inserire solo caratteri alfabetici!");
    		return ;
    	}
    	elenco.addParola(parola);	
    
    	String risultato="";
    	for(String p:elenco.getElenco())
    		if(p!=null)
    			risultato+=p+"\n";
    		
    	txtResult.setText(risultato.trim());
    	txtParola.clear();
    	this.txtError.clear();
    	txtTime.appendText("Tempo di inserimento di \""+parola+"\": "+(System.nanoTime()-start)+"\n");
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	double start=System.nanoTime();
    	elenco.reset();
    	txtResult.clear();
    	txtTime.appendText("Tempo di Reset: "+(System.nanoTime()-start)+"\n");
    	this.txtError.clear();
    	// TODO
    }
    @FXML
    void doCanc(ActionEvent event) {
    	double start=System.nanoTime();
    	String parola=txtResult.getSelectedText();
    	elenco.getElenco().remove(parola);
    	String risultato="";
    	for(String p:elenco.getElenco())
    		if(p!=null)
    			risultato+=p+"\n";
    		
    	txtResult.setText(risultato.trim());
    	txtParola.clear();
    	txtTime.appendText("Tempo di cancellazione: "+(System.nanoTime()-start)+"\n");
    	this.txtError.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	 assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
         assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
         assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
         assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Parole.fxml'.";
         assert btmCanc != null : "fx:id=\"btmCanc\" was not injected: check your FXML file 'Parole.fxml'.";
         assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";
        elenco = new Parole() ;
        
    }
}