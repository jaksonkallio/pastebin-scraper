/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pastebinscraper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sabreok
 */
public class PastebinScraper extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		MainUI main_ui = new MainUI();
		Scene scene = new Scene(main_ui, 300, 250);
		primaryStage.setTitle("Pastebin Scraper");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
