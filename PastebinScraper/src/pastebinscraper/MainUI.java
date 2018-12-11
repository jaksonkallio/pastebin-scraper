package pastebinscraper;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainUI {
	public MainUI(){
		title = new Label("Pastebin Scraper");
		title.setFont(TITLE_FONT);
		paste_url_label = new Label("Paste URL: ");
		keywords_label = new Label("Keywords: ");
		paste_url_field = new TextField();
		keywords_field = new TextField();
		scrape_button = new Button("Scrape");
	}
	
	public Pane getPane(){
		VBox pane = new VBox(STD_SPACING);
		pane.setPadding(STD_INSETS);
		pane.setPrefWidth(400);
		
		HBox paste_url_group = new HBox(STD_SPACING);
		paste_url_group.getChildren().addAll(paste_url_label, paste_url_field);
		
		HBox keywords_group = new HBox(STD_SPACING);
		keywords_group.getChildren().addAll(keywords_label, keywords_field);

		scrape_button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				doScrapeClick();
			}
		});
		
		pane.getChildren().addAll(title, paste_url_group, keywords_group, scrape_button);
		return pane;
	}
	
	public void doScrapeClick(){
		String scrape_url = "";
		scrape_url = paste_url_field.getText();
		System.out.println("Scrape clicked: " + scrape_url);
		List<PasteResult> sample_results = new ArrayList<>();
		
		PasteResult pr1 = new PasteResult();
		pr1.line_number = 5;
		pr1.context[0] = "previous found line 1";
		pr1.context[1] = "result in this line 1";
		pr1.context[2] = "next found line 1";
		
		PasteResult pr2 = new PasteResult();
		pr2.line_number = 102;
		pr2.context[0] = "previous found line 2";
		pr2.context[1] = "result in this line 2";
		pr2.context[2] = "next found line 2";
		
		sample_results.add(pr1);
		sample_results.add(pr2);
		
		spawnPasteResultsWindow(sample_results);
	}
	
	private void spawnPasteResultsWindow(List<PasteResult> results){
		System.out.println(javafx.scene.text.Font.getFamilies());
		Stage stage = new Stage();
		PasteResultsUI paste_results_ui = new PasteResultsUI(results);
		Scene scene = new Scene(paste_results_ui.getPane(), 500, 500);
		stage.setTitle("Scrape Results");
		stage.setScene(scene);
		stage.show();
	}
	
	public static final Font TITLE_FONT = new Font("Arial", 18.0);
	public static final Font STD_FONT = new Font("Arial", 14.0);
	public static final Font CODE_FONT = new Font("Courier", 14.0);
	public static final int STD_SPACING = 10;
	public static final Insets STD_INSETS = new Insets(10,10,10,10);
	
	private final Label title;
	private final Label paste_url_label;
	private final Label keywords_label;
	private final TextField paste_url_field;
	private final TextField keywords_field;
	private final Button scrape_button;
}
