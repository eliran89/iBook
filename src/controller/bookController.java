package controller;


import boundry.userBookGUI;

public class bookController {

	public void newOrder() {
		// TODO - implement bookController.newOrder
		throw new UnsupportedOperationException();
	}

	public void addBook() {
		// TODO - implement bookController.addBook
		throw new UnsupportedOperationException();
	}

	public void removeBook() {
		// TODO - implement bookController.removeBook
		throw new UnsupportedOperationException();
	}

	public void removeBookFromCatalog() {
		// TODO - implement bookController.removeBookFromCatalog
		throw new UnsupportedOperationException();
	}

	public void lockBook() {
		// TODO - implement bookController.lockBook
		throw new UnsupportedOperationException();
	}

	/**Book Search*/
	public static void searchBook() {
		
		userBookGUI panel;
		if(loginController.use.getprivilege() == 1)
			panel = new userBookGUI(loginController.use.getUsername(),"Interested Reader");
		else
			panel = new userBookGUI(loginController.use.getUsername(),"Reader");
		
		panel.displaySearch();
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
	}
	/**Book Search END*/
	
	
	public static void displayResults(String brief,String title,String langu,String keyWord,String author,String appendix,String scope ){
		
		
	}
	

	public void chooseBook() {
		// TODO - implement bookController.chooseBook
		throw new UnsupportedOperationException();
	}

	public void editBookinfo() {
		// TODO - implement bookController.editBookinfo
		throw new UnsupportedOperationException();
	}

	public void setAbsRank() {
		// TODO - implement bookController.setAbsRank
		throw new UnsupportedOperationException();
	}

	public void setScopeRank() {
		// TODO - implement bookController.setScopeRank
		throw new UnsupportedOperationException();
	}

}