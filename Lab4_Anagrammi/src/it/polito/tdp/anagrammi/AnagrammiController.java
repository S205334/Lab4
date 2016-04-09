/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AnagrammiController {

	private AnagrammiModel model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtAnagramma"
    private TextField txtAnagramma; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextFlow txtResult; // Value injected by FXMLLoader

    @FXML
    void btCalcola(ActionEvent event) {
    	String txtIns = txtAnagramma.getText();
    	
    	model.loadDictionary();   	
    	List<String> anag = model.permuta(txtIns);
    	
    	for( String w : anag) {
    		Text word = new Text();
    		
    		if(!model.spellCheckText(w)) {
    			word.setFill(Color.RED);
    		} else {
    			word.setFill(Color.BLACK);
    		}	
    		word.setText(w + "\n");
    		txtResult.getChildren().add(word);
    	}
    	
    	
    }

    @FXML
    void btReset(ActionEvent event) {
    	txtAnagramma.clear();
    	txtResult.getChildren().clear();
    }
    
    public void setModel(AnagrammiModel model) {
    	this.model = model;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtAnagramma != null : "fx:id=\"txtAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Anagrammi.fxml'.";
    }
}