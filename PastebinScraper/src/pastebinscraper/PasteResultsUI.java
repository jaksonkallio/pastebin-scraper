package pastebinscraper;

import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PasteResultsUI extends Pane {
	public PasteResultsUI(List<PasteResult> results){
		this.results = results;
		title = new Label("Results");
		title.setFont(MainUI.TITLE_FONT);
	}
	
	public Pane getPane(){
		VBox pane = new VBox(MainUI.STD_SPACING);
		pane.setPadding(MainUI.STD_INSETS);
		pane.getChildren().add(title);
		
		for(PasteResult result : results){
			VBox result_box = new VBox(MainUI.STD_SPACING / 2);
			result_box.setPadding(MainUI.STD_INSETS);
			Label line_number_label = new Label("Line " + result.line_number);
			
			VBox context_box = new VBox();
			for(int i = 0; i < result.context.length; i++){
				context_box.getChildren().add(new Label(result.context[i]));
			}
			
			result_box.getChildren().addAll(result_box, context_box);
			pane.getChildren().add(result_box);
		}
		
		return pane;
	}
	
	private final Label title;
	private final List<PasteResult> results;
}
