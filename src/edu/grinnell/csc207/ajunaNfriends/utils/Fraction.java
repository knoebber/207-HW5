package edu.grinnell.csc207.ajunaNfriends.utils;

import java.math.BigInteger;

/**
 * A simple implementation of Fractions.
 *
 * @author Samuel A. Rebelsky
 * @author Ajuna Kyaruzi, Hattie Zucker and Albert Owusu-Asare
 * @author CSC152 2005S
 * @version 2.0 of September 2014
 * From HW4
 */
public class Fraction
{
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are
   * represented with a negative numerator. Similarly, if a fraction has a
   * negative numerator, it is negative.
   *
   * (2) Fractions are not necessarily stored in simplified form. To obtain a
   * fraction in simplified form, one must call the simplify method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * In the simplest form
   */
  public Fraction(BigInteger num, BigInteger denom)
  {

    BigInteger gcd = num.gcd(denom);
    this.num = num.divide(gcd);
    this.denom = denom.divide(gcd);
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * In the simplest form
   */
  public Fraction(int num, int denom)
  {

    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
    BigInteger gcd = this.num.gcd(this.denom);
    this.num = this.num.divide(gcd);
    this.denom = this.denom.divide(gcd);

  } //Fraction (int, int)

  /**
   * Build a new fraction from given String str.
   * 
   */
  public Fraction(String str)
  {
    String str2[] = str.split("/");
    int top = Integer.parseInt(str2[0]);
    int bottom = Integer.parseInt(str2[1]);
    this.num = BigInteger.valueOf(top);
    this.denom = BigInteger.valueOf(bottom);

  } // Fraction(BigInteger, BigInteger)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   */
  public double doubleValue()
  {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction other to this fraction.
   */
  public Fraction add(Fraction addMe)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator =
        (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// add(Fraction)

  /**
   * Subtract the fraction other from this fraction.
   */
  public Fraction subtract(Fraction subtractMe)
  {
    BigInteger bottom = this.denom.multiply(subtractMe.denom);
    // The numerator is more complicated
    BigInteger top =
        (this.num.multiply(subtractMe.denom)).subtract(subtractMe.num.multiply(this.denom));

    return new Fraction(top, bottom);
  }// subtract(Fraction)

  /**
   * Multiply the fraction other to this fraction.
   */
  public Fraction multiply(Fraction multiplyme)
  {
    BigInteger top = (this.num.multiply(multiplyme.num));
    BigInteger bottom = (this.denom.multiply(multiplyme.denom));
    return new Fraction(top, bottom);

  }// multiply(Fraction)

  /**
   * Divide the fraction other to this fraction.
   */
  public Fraction divide(Fraction divideme)
  {
    BigInteger top = (this.num.multiply(divideme.denom));
    BigInteger bottom = (this.denom.multiply(divideme.num));
    return new Fraction(top, bottom);

  }// divide(Fraction)

  /**
   * Raises fraction this to int expt power.
   */
  public Fraction pow(int expt)
  {
    BigInteger top = (this.num.pow(expt));
    BigInteger bottom = (this.denom.pow(expt));
    return new Fraction(top, bottom);

  }// pow(int)

  /**
   * Simplifies the given fraction.
   */
  public Fraction fractional()
  {
    BigInteger top = (this.num.mod(this.denom));
    BigInteger bottom = this.denom;
    return new Fraction(top, bottom);
  }// fractional()

  /**
   * Negates the given fraction.
   */
  public Fraction negate()
  {
    BigInteger factor = BigInteger.valueOf(-1);
    BigInteger top = (this.num.multiply(factor));
    return new Fraction(top, this.denom);
  }// negate()

  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString()
  {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO))
      {
        return "0/1";
      } // if it's zero

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  public static void main(String[] args)
  {
  }

} // class Fraction