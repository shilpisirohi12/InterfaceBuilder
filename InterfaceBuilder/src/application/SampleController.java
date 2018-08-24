package application;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SampleController {
	private List elementList=new ArrayList();
	
	private Set<String>elements=new HashSet<String>();
		

	
	@FXML
	private TextField elementName;
	
	
	
	@FXML
	protected void addMoreBtnAction(ActionEvent e) {
		System.out.println("Add More Button Clicked "+ elementName.getText());
		if(!elementName.getText().isEmpty())
			elements.add(elementName.getText());
		elementName.clear();

		System.out.println("Values in the Set: "+ elements);

		
		
	}
	
	@FXML
	protected void submitBtnAction(ActionEvent e) {
		System.out.println("Submit Button Clicked");
		elements.clear();
		System.out.println("Values in the Set: "+ elements);
		
	}
}
