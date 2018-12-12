package pastebinscraper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
//kevin jakson
public class Paste {
    
    public Paste(String url){
		paste_id = parsePasteID(url);
		lines = new ArrayList<>();
		readPaste();
	}
    
    public final void readPaste(){
        
		try{
            //sets the url to the raw pastebin data. 
            URL website = new URL("https://pastebin.com/raw/" + getPasteID());
            //this is the reader that will read the stream of website data. 
            BufferedReader reader = new BufferedReader(new InputStreamReader(website.openStream()));
                        //normal input
			String input;
            //will store the input of the reader line by line into the input varible. 
            while((input = reader.readLine())!=null){
                //adds the input.
                lines.add(input);
            }
            //will throw an error if it can not connect to a webiste. 
        } catch(IOException ex){
            System.out.println("Could not read paste: " + ex.getMessage());
        }
    }
    //Search function 
    public List<PasteResult> search(List<String> keys){
        //Search Result is where the result will be stored in the type of paste results. 
        List<PasteResult> search_results = new ArrayList<>();
        
		for(int i = 0; i < lines.size(); i++){
                        
			String line = lines.get(i);
			
			for(int j = 0; j < keys.size(); j++){
                             // checks to see if the line of input contians the key
				if(line.contains(keys.get(j))){
					PasteResult result = new PasteResult();
					
					// i + 1 for readability
					result.line_number = i + 1;
					//will set the results to the corisponding line number
					if(i == 0){
						result.context[0] = "[Start of File]";
					}else{
						result.context[0] = lines.get(i - 1);
					}
					
					result.context[1] = line;
					//will set the two line of the results. 
					if(i == (lines.size() - 1)){
						result.context[2] = "[End of File]";
					}else{
						result.context[2] = lines.get(i + 1);
					}
					
					search_results.add(result);
				}
			}
		}
		
		return search_results;
    }
	
	public String getPasteID(){
                //gets the end of the paste bin url to check that pastebin site. 
		if(paste_id.equals("")){
			return "tDU7mmVv";
		}
		
		return paste_id;
	}
	
	public static String parsePasteID(String url){
		// https://pastebin.com/hvDQ9S31
                //will split the pastebim to add the url and the raw part
		String[] url_parts = url.split("/");
		if(url_parts.length == 4){
			return url_parts[3];
		}
		
		return "";
	}
    
    private final String paste_id;
	private final List<String> lines;
}