package edu.grinnell.csc207.ajunaNfriends.utils;

import java.io.PrintWriter;

public class UtilsExpt
{

  public static void main(String[] args)
  throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    //BigDecimal first = new BigDecimal(2) ;
    //BigDecimal approx = new BigDecimal (0.0000005) ;
    //BigDecimal answer =  Utils.sqrt(first, approx) ;
    pen.println(Utils.expt(2, 7)); 
    
    
    pen.close() ;
    

  }

}
