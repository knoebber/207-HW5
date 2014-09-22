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
    CalculatorHW4 calc = new CalculatorHW4();
    Fraction f1;
    calc.eval1("r0=1/2+1/2");
    
 
    
    pen.close() ;
    

  }

}
