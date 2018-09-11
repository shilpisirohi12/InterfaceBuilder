package application;


import pojo.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;

public class MainController {
	//For Elements
	@FXML
	private TextField elementName;
	
	//For Variables
	@FXML
	private TextField variableName;
	@FXML
	private TextArea variableValue;
	@FXML
	private RadioButton flagTrueVar;
	@FXML
	private RadioButton flagFalseVar;

	//For Points
	@FXML
	private TextField pointID;
	@FXML
	private TextField ptc;
	@FXML
	private TextField pointLookup;
	@FXML
	private TextField pointName;
	@FXML
	private TextField pointTag;
	@FXML
	private TextField pointOffset;
	@FXML
	private TextField pointDesc;
	@FXML
	private RadioButton pointflagTrue;
	@FXML
	private RadioButton pointflagFalse;
	@FXML
	private ComboBox<String> pointType;
	@FXML
	private ToggleGroup isTruepoint;
	
	ObservableList<String> pointTypes=FXCollections.observableArrayList("point_lookup_type_ins","point_lookup_type");
	
//collection Objects
	private Set<String>elements=new HashSet<String>();
	private List<PointClass> pointLst=new LinkedList<PointClass>();
	
	
	@FXML
	public void initialize() {
		//pointType.setValue("Choose Any Point Type");
		pointType.setItems(pointTypes);
		pointflagTrue.setToggleGroup(isTruepoint);
		pointflagFalse.setToggleGroup(isTruepoint);
		
	}
	

	
	@FXML
	protected void addMoreBtnAction(ActionEvent e) {
		System.out.println("Add More Button Clicked "+ elementName+"   "+elementName.getText());
		if(!elementName.getText().isEmpty())
		   elements.add(elementName.getText());
		elementName.clear();
		System.out.println("Values in the Set: "+ elements);
		//System.out.println(tabPane.getSelectionModel().getSelectedItem());
	}
	
	
	@FXML
	protected void addVariableBtnAction(ActionEvent e) {
		System.out.println("Variable Name:"+ variableName.getText());
		System.out.println("Variable Value:"+variableValue.getText());


	}
	
	
	@FXML
	protected void addPointBtnAction(ActionEvent e) {
		System.out.println("pointID:"+ pointID.getText());
		System.out.println("setPointTypeCode:"+ptc.getText());
		System.out.println("point lookup: "+pointLookup.getText());
		System.out.println("point name: "+pointName.getText());
		System.out.println("point tag: "+pointTag.getText());
		System.out.println("point offset: "+ pointOffset.getText());
		System.out.println("Point Desc: "+pointDesc.getText());
		System.out.println("Flag: "+ ((RadioButton)isTruepoint.getSelectedToggle()).getText());
		System.out.println("point Type: "+ pointType.getValue());
		
		
		//Creating Point Object and setting its values
		PointClass point=new PointClass();
		point.setPointID(pointID.getText());
		point.setPointTypeCode(ptc.getText());
		point.setPointLookup(pointLookup.getText());
		point.setPointName(pointName.getText());
		point.setPointTag(pointTag.getText());
		point.setPtcOffset(pointOffset.getText());
		point.setPointDesc(pointDesc.getText());
		point.setFlag(((RadioButton)isTruepoint.getSelectedToggle()).getText());
		point.setPointType(pointType.getValue());
		
		//Adding Point Object in the List
		pointLst.add(point);
		
		System.out.println("Points: "+ pointLst.get(0));
		


	}
	
	@FXML
	protected void submitBtnAction(ActionEvent e) {
		System.out.println("Submit Button Clicked");
		XmlGenerator.elementsList(elements); 
		elements.clear();
		//selectionModel.select(3);
		System.out.println("Values in the Set: "+ elements);
	}
}
