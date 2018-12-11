/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pastebinscraper;

/**
 *
 * @author Kevin
 */
class PasteResults {
   public int line_number;
   public String[] context;
   
   public PasteResults(int line_number,String[] context)
   {
       this.line_number=line_number;
       this.context=context;
   }
}
