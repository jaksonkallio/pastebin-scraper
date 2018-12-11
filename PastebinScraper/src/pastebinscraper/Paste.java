package pastebinscraper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Paste {
    
    public Paste(String url){
		paste_id = parsePasteID(url);
		lines = new ArrayList<>();
		readPaste();
	}
    
    public final void readPaste(){
        List<PasteResults> results = new ArrayList<>();
        
		try{
            URL website = new URL("https://pastebin.com/raw/" + getPasteID());
            BufferedReader reader = new BufferedReader(new InputStreamReader(website.openStream()));
            
			String input;
            while((input = reader.readLine())!=null){
                lines.add(input);
            }
        } catch(IOException ex){
            System.out.println("Could not read paste: " + ex.getMessage());
        }
    }
    
    public List<PasteResult> search(List<String> keys){
        List<PasteResult> search_results = new ArrayList<>();
        
		for(int i = 0; i < lines.size(); i++){
			String line = lines.get(i);
			
			for(int j = 0; j < keys.size(); j++){
				if(line.contains(keys.get(j))){
					PasteResult result = new PasteResult();
					
					// i + 1 for readability
					result.line_number = i + 1;
					
					if(i == 0){
						result.context[0] = "[Start of File]";
					}else{
						result.context[0] = lines.get(i - 1);
					}
					
					result.context[1] = line;
					
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
		if(paste_id.equals("")){
			return "hvDQ9S31";
		}
		
		return paste_id;
	}
	
	public static String parsePasteID(String url){
		// https://pastebin.com/hvDQ9S31
		String[] url_parts = url.split("/");
		if(url_parts.length == 4){
			return url_parts[3];
		}
		
		return "";
	}
    
    private final String paste_id;
	private final List<String> lines;
}