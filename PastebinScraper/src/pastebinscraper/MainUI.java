package pastebinscraper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

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
	}
	
	public static final Font TITLE_FONT = new Font("Arial", 18.0);
	public static final Font STD_FONT = new Font("Arial", 14.0);
	public static final int STD_SPACING = 10;
	public static final Insets STD_INSETS = new Insets(10,10,10,10);
	
	private final Label title;
	private final Label paste_url_label;
	private final Label keywords_label;
	private final TextField paste_url_field;
	private final TextField keywords_field;
	private final Button scrape_button;
}
