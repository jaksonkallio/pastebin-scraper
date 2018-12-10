package pastebinscraper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
public class Paste {
    String url;
    URL website;
    String text;
    Paste(String url){
        this.url=url;
    }
    
   public static void geturl(String url){
       
   }
   public static void connect(String url){
        try{
        URL website = new URL(url);  
        BufferedReader reader = new BufferedReader(new InputStreamReader(website.openStream()));
        String input = "";
        while((input = reader.readLine())!= null)
        {
            System.out.println(input);
        }
       }
       catch(Exception ex){
           
           System.err.println("error connecting to url");
       }
        
   }
   public boolean finddata(String link)
   {
       
       return false;
   }
   
    
    
}
