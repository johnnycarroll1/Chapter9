package application;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dbLogic.ConnectDatabase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class dbGUIController implements Initializable {
	
	Connection conn = ConnectDatabase.dbConnect("jdbc:sqlserver://192.168.1.127:1433","ch2","password");
	
	@FXML
	private Label lblCustomerCount;
		
	@FXML
	private TextArea txtFieldLastNames;
	
	@FXML
	void setCount() {
		lblCustomerCount.setText(ConnectDatabase.getCount(conn,"Use Northwind; SELECT COUNT(*) FROM Customers"));
	}
	
	@FXML
	void setLastNames() {
		ArrayList lastNames = ConnectDatabase.getCustomerLastNames(conn, "Use Northwind; SELECT * FROM Customers","ContactName");
		for (Object name : lastNames) {
			txtFieldLastNames.appendText(name.toString() + "\n");
		}
	}

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}


}
