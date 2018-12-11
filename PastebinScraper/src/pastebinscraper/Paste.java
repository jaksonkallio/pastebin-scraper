package pastebinscraper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Paste {
    private String url;
    private String stuff;
    public int counter_of_lines;
    List<String> keys;
    
    public Paste(String url)
    {
        this(url, null);
        
    }
    
    public Paste(String url,List<String>keys){
        this.url=url;
        this.keys=keys;
        this.counter_of_lines=0;
    }
    
    public List<PasteResults> getResults(){
        List results = new ArrayList<PasteResults>();
        List input_list = new ArrayList<String>();
        String result_stuff="";
        try{
            URL website = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(website.openStream()));
            String input;
            while((input = reader.readLine())!=null){
                input_list.add(input);
               
                
            }
        }
        catch(Exception ex){
            return null;
        }
        return search(input_list);
       
    }
    
    private List<PasteResults> search(List <String> input_list){
        List search_results = new ArrayList<PasteResults>();
        
        for(int i=0; i<keys.size();i++){
            if(input_list.contains(keys.get(i))){
                int line=input_list.indexOf(keys.get(i));
                String[] context = new String[3];
                context[0]=input_list.get(line-1);
                context[1]=input_list.get(line);
                context[2]=input_list.get(line+1);
                PasteResults search_item_found= new PasteResults(line,context);
                search_results.add(search_item_found);
                
            }
        }
        return search_results;
    }
    
    
}