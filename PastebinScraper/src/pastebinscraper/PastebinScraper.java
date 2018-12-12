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
 * @author Kevin Krauel Jakson Kalio
 */
public class PastebinScraper extends Application {
	
	@Override
        //main program 
	public void start(Stage primaryStage) {
                //sets the main gui. 
		MainUI main_ui = new MainUI();
                //will set the main gui
		Scene scene = new Scene(main_ui.getPane(), 300, 250);
                //sets the title
		primaryStage.setTitle("Pastebin Scraper");
                
		primaryStage.setScene(scene);
                //display it 
		primaryStage.show();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
