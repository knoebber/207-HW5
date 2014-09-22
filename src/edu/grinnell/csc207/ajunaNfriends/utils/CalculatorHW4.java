package edu.grinnell.csc207.ajunaNfriends.utils;

import java.math.BigInteger;

/**
 * An implementation of a simple calculator.
 *
 * @author Ajuna Kyaruzi and Hattie Zucker 
 * From HW4
 *
 */
public class CalculatorHW4
{
  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
   Fraction[] state=new Fraction[8];


  public CalculatorHW4()
  {
    
    for(int i=0;i<8;i++)
      state[i]= new Fraction("0");
    
  }

  public Fraction eval1(String str)
  {
    Fraction result = new Fraction("0");
    char curr;
    int last = 0;
    char op = '+';
    Fraction currFrac = new Fraction("0");
    /*
    * Go through the string and calculate the result using the given fractions
    * and operators.
    */
    for (int i = 0; i < str.length(); i++)
      {
        curr = str.charAt(i);
        if ((curr == '*' || curr == '/' || curr == '+' || curr == '-' || curr == '^')
            && str.charAt(i + 1) == ' ')
          {
            currFrac = new Fraction(str.substring(last, i).trim());
            result = operate(result, op, currFrac);
            last = i + 1;
            op = curr;
          } // if
        else if(curr== '=')
          {
            String expres=str.substring(i+1);
            int index = str.charAt(i-1)-48; //subtracting 48 changes char to int
            
            state[index]=eval1(expres);
            
          }//else if =
        
        else if(curr=='r')
          {
            
          }
      } // for
    /*
    * Find and operate on the last fraction in the string.
    */
    currFrac = new Fraction(str.substring(last).trim());
    result = operate(result, op, currFrac);
    return result;
  } // eval1(String)

  /**
  * Performs an operation between two fractions using the given operator.
  * @param first
  * @param op
  * @param second
  * @return Fraction
  */
  public static Fraction operate(Fraction first, char op, Fraction second)
  {
    Fraction result = new Fraction("0");
    
    switch (op)
      {
        case '+':
          result = first.add(second);
          break;
        case '-':
          result = first.subtract(second);
          break;
        case '*':
          result = first.multiply(second);
          break;
        case '/':
          result = first.divide(second);
          break;
      } // switch
    return result;
  }//operate

}
