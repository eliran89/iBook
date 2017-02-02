/**
 * Generated by FITpro Fixture Generator
 */
package Fixtures;

import fit.ActionFixture;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import boundry.MainWindowGUI;
import boundry.userBookGUI;
import boundry.workerBookGUI;
import controller.DBController;
import controller.bookController;
import controller.loginController;
import entity.User;

/*
 * TODO: modify class to match the FIT test - edit and add methods as required.
 */
public class addNewBook extends ActionFixture {
	private DBController dbhandler;
	private workerBookGUI panelTest ;
	/*public JTextField textFieldTitle;
	public JTextField textFieldAuthor;
	public JTextField textFieldLangu;
	public JTextPane textFieldBrief;
	public JTextField textFieldScope;
	public JTextField textFieldKey;
	public JTextPane textFieldAppen;
	public JTextField textFieldCost;*/
	public void startAddBook() {
		dbhandler = new DBController("localhost",5555);
		loginController.use = new User();
		loginController.use.setUsername("test");
		loginController.use.setprivilege(6);
		panelTest = new workerBookGUI("test", "test");
		panelTest.addBook();
		loginController.mainG = new MainWindowGUI(panelTest);
		
	}
	
	public void addAuthor() {
		panelTest.btnAddAuthor.doClick();
	}
  
    
	public void addBook() {
		panelTest.btnNewButton.doClick();
	}
  
    
	public void addKeyword() {
		panelTest.btnAddKeyword.doClick();
	}
  
    
	public void addScope() {
		panelTest.btnAddScope.doClick();
	}
  
    
	public void setAppendix(String setAppendix) {
		panelTest.textAppendix.setText(setAppendix);
	}
  
    
	public void setAuther(String setAuther) {
		panelTest.textFieldAuthor.setText(setAuther);
	}
  
    
	public void setBrief(String setBrief) {
		panelTest.textFieldBrief.setText(setBrief);
	}
  
    
	public void setCost(String setCost) {
		panelTest.textFieldCost.setText(setCost);
	}
  
    
	public void setDocx(String setDocx) {
		panelTest.textFieldDocx.setText(setDocx);
	}
  
    
	public void setFb2(String setFb2) {
		panelTest.textFieldFb.setText(setFb2);
	}
  
    
	public void setKeyword(String setKeyword) {
		panelTest.textFieldKey.setText(setKeyword);
	}
  
    
	public void setLanguage(String setLanguage) {
		panelTest.textFieldLangu.setText(setLanguage);
	}
  
    
	public void setPdf(String setPdf) {
		panelTest.textFieldPdf.setText(setPdf);
	}
  
    
	public void setScope(String setScope) {
		panelTest.textFieldScope.setText(setScope);
	}
  
	public void setSubject(String setSubject) {
		panelTest.textFieldSubject.setText(setSubject);
	}
  
    
	public void setTitle(String setTitle) {
		panelTest.textFieldTitle.setText(setTitle);
	}
  

}

