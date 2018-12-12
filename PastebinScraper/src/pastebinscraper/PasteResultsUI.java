package pastebinscraper;
//kevin jakson
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PasteResultsUI extends Pane {
        //constructor for the results. 
	public PasteResultsUI(List<PasteResult> results){
		this.results = results;
		title = new Label("Results");
		title.setFont(MainUI.TITLE_FONT);
	}
	//gets the actuat pane. 
	public Pane getPane(){
                //creates the main vbox for the result menu. 
		VBox pane = new VBox(MainUI.STD_SPACING);
                //sets the padding
		pane.setPadding(MainUI.STD_INSETS);
                //addes the title. 
		pane.getChildren().add(title);
		//will check the results list and cycle through for all the data. 
		for(PasteResult result : results){
                        //sets the main vbox for the result menu
			VBox result_box = new VBox(MainUI.STD_SPACING / 2);
			result_box.setPadding(MainUI.STD_INSETS);
                        //will set the label for the line numbers
			Label line_number_label = new Label("Line " + result.line_number);
			//creates the vbox to store all the content.
			VBox context_box = new VBox();
                        //will go through the results. 
			for(int i = 0; i < result.context.length; i++){
                                //The varible that the results are stored in. 
				Label context_label = new Label(result.context[i]);
				context_label.setFont(MainUI.CODE_FONT);
				//will display if it contain the password in green. 
				if(i == 1){
					context_label.setTextFill(Color.web("#00b894"));
				}else{
					context_label.setTextFill(Color.web("#636e72"));
				}
				
                                //adds all the contents to the vbox.
				context_box.getChildren().add(context_label);
			}
			//Adds to the main vbox
			result_box.getChildren().addAll(line_number_label, context_box);
			pane.getChildren().add(result_box);
		}
		//returns the whole pane to be displayed in main. 
		return pane;
	}
	
	private final Label title;
	private final List<PasteResult> results;
}
