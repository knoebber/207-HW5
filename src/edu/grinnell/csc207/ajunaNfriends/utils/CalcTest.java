package edu.grinnell.csc207.ajunaNfriends.utils;

import java.io.PrintWriter;
/**
 * Some testing for a simple calculator.
 *
 * @author Ajuna Kyaruzi and Hattie Zucker 
 *
 */
public class CalcTest
{

  public static void main(String[] args)
  throws Exception
  {
    PrintWriter pen = new PrintWriter (System.out, true);
    pen.println("Test " + Calculator2.eval1(" "));
    pen.println("Test " + Calculator2.eval1("1/2 / 3/2 ^ 2 + 3 + r0"));
  }

}
