package pastebinscraper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class Paste {
    String url;
    URL website;
    String text;
    List keys;
    String good_output;
    Paste(String url){
        this.url=url;
    }
    
   public static void geturl(String url){
       
   }
   public String connect(String url){
        text="";
        keys = new ArrayList();
        int length = keys.size();
        int counter_of_words=0;
        
        try{
        URL website = new URL(url);  
        BufferedReader reader = new BufferedReader(new InputStreamReader(website.openStream()));
        String input;
        while((input = reader.readLine())!= null)
        {
            text+=reader;
            counter_of_words++;
            for(int i=0; i<length; i++)
            {
              if(input.equals(keys.get(i))){
                  good_output=text.substring(counter_of_words);
              }
       
            }
            //System.out.println(input);
        }
       }
       catch(Exception ex){
           
           System.err.println("error connecting to url");
       }
       return text;
       
       
   }
   public String search_for(String something,String search_parameter){
       something+='\n';
       String argument;
       
       if(something.equals(search_parameter)){
           argument=something;
       }
       else{
           argument=" ";
       }
       
       
       return argument;
   }
   
    
    
}
