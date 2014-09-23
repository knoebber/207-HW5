package edu.grinnell.csc207.ajunaNfriends.utils;

/**
 * An implementation of a simple calculator.
 *
 * @author Ajuna Kyaruzi and Hattie Zucker 
 *
 */
public class Calculator2
{
  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
  Fraction[] state=new Fraction[8];
  
  public Calculator2()
  {    
    for(int i=0;i<8;i++)
      state[i]= new Fraction("0");
  } //Calculator2

  public static String[] evalStart (String input)
  {
    //Split input into array
    String[] array = input.split(" +");
    //if array is empty, then return 0/1
    
    return array ;
  } //evalStart
  
    public static Fraction evaluateIt(String[] array, int BegIndex, int EndIndex)
    {
      if (array.length == 0 || BegIndex >= EndIndex)
        return (new Fraction(0, 1));
   
    Fraction result = new Fraction(array[0]);
    //move through array performing indicated operations
    for (int i = BegIndex; i < EndIndex; i++)
      {
        if ((array[i].compareTo("+")) == 0)
          {
            Fraction next = new Fraction(array[i + 1]);
            result = result.add(next);
            i++;
          }// if adding fractions
        if ((array[i].compareTo("-")) == 0)
          {
            Fraction next = new Fraction(array[i + 1]);
            result = result.subtract(next);
            i++;
          }// if subtracting fractions
        if ((array[i].compareTo("*")) == 0)
          {
            Fraction next = new Fraction(array[i + 1]);
            result = result.multiply(next);
            i++;
          }// if multiplying fractions
        if ((array[i].compareTo("/")) == 0)
          {
            Fraction next = new Fraction(array[i + 1]);
            result = result.divide(next);
            i++;
          }// if dividing fractions
        if ((array[i].compareTo("^")) == 0)
          {
            int next2 = Integer.parseInt(array[i + 1]);
            result = result.pow(next2);
            i++;
          }// if using exponents on fractions
      }//for loop

    return result;
  }// evaluateIt 
    
    public static Fraction eval1 (String input)
    {
      
      String[] array2 = evalStart(input) ;
      
      Fraction result = evaluateIt(array2, 1, array2.length) ;
      
      //Go through the array and try to find the equal sign.
      //If there is no equal sign, go through the array and look for the r1 or r2 or ..
      
      for (int i = 0 ; i < array2.length ; i++)
        {
          //Find an r0 or r1 or r2
          
          if ((array2[i].compareTo("r*")) == 0)
            {
              System.out.println("Hey guess who found an r!") ;
              //Check if there is an equal sign coming up next
              //If there isn't then get the value of the second number of r.
            }
        }
      
      return result ;
    } //eval1
    
}// class Calculator2
