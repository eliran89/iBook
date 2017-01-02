package boundry;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class mainWindow extends Application {
	
	private Stage PrimaryStage;
	private AnchorPane  mainLayout;
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		this.PrimaryStage = primaryStage;
		this.PrimaryStage.setTitle("IBook Main");
		showMainView();
		
	}
	private void showMainView() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(mainWindow.class.getResource("/views/mainWindow.fxml‬"));
		mainLayout = loader.load();
		Scene  scene = new Scene(mainLayout);
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
