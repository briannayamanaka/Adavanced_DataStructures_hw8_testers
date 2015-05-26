/* CSE12 Homework 8
 * Brianna Torres Yamanaka: A10690742, cs12spq
 * Jessica Yang: A98071336, cs12sim
 * Jessica Sec A00
 * Brianna: Sec A01
 * 5.23.15
 */

package hw8;

import java.util.*;
import java.text.DecimalFormat;

/**
 * Quantity is a class that implements a quantity object.
 * <p>
 * An object of class Quantity should represent a numerical
 * value having numerical value and attached units.
 * <p>
 * A quantity object always cons a value and some units though
 * in some cases the collection of units might be empty.
 */
public class Quantity
{
  //instance variable to represent the numerical value itself
  private double numericalValue;

  //instance variable to represent the string unit of a quantity
  private Map<String,Integer> units;

  /** 0-argument constructor. Creates a default quantity of value
   * 1 and no units. Even when there are no units the object should
   * still contain a map object (map with no entries).
   */
  public Quantity()
  {
    //set quantity to be of value one
    numericalValue = 1;
    //create a new hashmap with no entries
    units = new HashMap();
  }

  /** 1-arg constructor. Creates a deep copy ie the new Quantity will
   * be a dif object with its own instance variables and will contain
   * a copy of the Map object referenced by the argument Quantity.
   * @param toCopy A Quantity argument
   */
  public Quantity(Quantity toCopy) throws IllegalArgumentException
  {
    //if passed in map is null, throw exception
    if(toCopy == null)
    {
      throw new IllegalArgumentException("1-arg constructor passing in null");
    }
    //set numerical value to be passed in quantity's numerical value
    this.numericalValue = toCopy.numericalValue;

    //create a new map with toCopy's datafield
    this.units = new HashMap(toCopy.units);
  }

  /** 3-arg constructor. Creates a quantity with three passed in paramaters.
   * @param numericValue
   * @param posExpUnits
   * @param negExpUnits
   */
  public Quantity(double paramNumericalValue, List<String> posExpUnits,
      List<String> negExpUnits) throws IllegalArgumentException
  {
    //if unit with negative exponent is null throw exception
    if(negExpUnits == null)
    {
      throw new IllegalArgumentException("3-arg constructor passing in" +
          "null unit with negative exponent");
    }
    //if unit with positive exponent is null throw exception
    if(posExpUnits == null)
    {
      throw new IllegalArgumentException("3-arg constructor passing in" +
          "null unit with positve exponent");
    }
    //create a new unit
    this.setUnits(new HashMap());

    //set the numerical value to be passed in numerical value
    this.setNumericalValue(paramNumericalValue);

    //create string for positive exponential unit
    String posExpString = posExpUnits.get(0);

    //create string for negative exponential unit
    String negExpString = negExpUnits.get(0);

    //create an int for the initial pos exponent
    int posExponentValue = 0;

    //create an int for the initial neg exponent
    int negExponentValue = 0;

    //calculate the exponent numerical value by counting strings
    calculateExponentInConstructor(posExpString, negExpString,
        posExpUnits, negExpUnits, 0, 0);
  }

  /** This method returns the quantity as a String
   * @return String quantity
   */
 public String toString()
{
  double valueOfTheQuantity = this.numericalValue;
  Map<String,Integer> mapOfTheQuantity = this.units;

  // Ensure we get the units in order
  TreeSet<String> orderedUnits =  
      new TreeSet<String>(mapOfTheQuantity.keySet());

  StringBuffer unitsString = new StringBuffer();

  for (String key : orderedUnits) {
    int expt = mapOfTheQuantity.get(key);
    unitsString.append(" " + key);
    if (expt != 1)
         unitsString.append("^" + expt);
  }
  // Used to convert doubles to a string with a 
  //   fixed maximum number of decimal places.
  DecimalFormat df = new DecimalFormat("0.0####");

  // Put it all together and return.
  return df.format(valueOfTheQuantity) 
           + unitsString.toString();
  }

  /** This method multiplies this by the argument and returns the result
   *  Returned value should be a brand new Quantity object
   *  Neither this quantity nor the argument quantity should cnage
   *  @param Quantity paramQuantity. to multiply this by
   *  @return Quantity newQuantity with multiplied numercal values and units
   */
  public Quantity mul(Quantity paramQuantity) throws IllegalArgumentException
  {
    if(paramQuantity == null)
    {
      throw new IllegalArgumentException("mul method in Quantity.java passing"+
          "in null Quantity");
    }
    //create the new quantity we are to return
    Quantity newQuantity = new Quantity();

    //create double to hold calling object's numerical value
    double thisNumericalValue = this.getNumericalValue();

    //create double to hold param object's numerical value
    double paramNumericalValue = paramQuantity.getNumericalValue();

    //create double to hold value of two prev values multiplied
    double product = thisNumericalValue * paramNumericalValue;

    //create a map to hold calling object's units with exp's
    //Map<String,Integer> thisQuantityUnits = this.getUnits();

    //create a map to hold parm object's units with exp's
    //Map<String,Integer> paramQuantityUnits = paramQuantity.getUnits();

    //concatenate dif strings?
    //insert code here

    //set new quantity's numerical value to be the product
    newQuantity.setNumericalValue(product);

    //HELP should we concatenate paramQuantity's units to this???
    
    //set new quantity's units to hold calling object's units with exp's
    newQuantity.setUnits(new HashMap(this.getUnits()));

    //calculate exponents (ie count strings)
    calculateExponentInMul(paramQuantity);

    return newQuantity;
  }

  /** this method divides this by the argument and returns the result
   * Returned value should be a brand new Quantity object
   * Neither this quantity nor the argument quantity should change
   * @param Quantity paramQuantity. to divide this by
   * @return Quantity newQuantity with divided numerical values and units
   */
  public Quantity div(Quantity paramQuantity) throws IllegalArgumentException
  {
    if(paramQuantity == null || paramQuantity.getNumericalValue() == 0)
    {
      throw new IllegalArgumentException("div method in Quantity.java passing" +
          "in null quantity or trying to divide by 0");
    }
    //create the new quantity we're gonna return
    Quantity newQuantity = new Quantity();

    //create double to hold calling object's numerical value
    double thisNumericalValue = this.getNumericalValue();

    //create double to hold param object's numerical value
    double paramNumericalValue = paramQuantity.getNumericalValue();

    //create a double to hold value of two prev values divided
    double quotient = thisNumericalValue/paramNumericalValue;

    //set new quantity's numerical value to be the product
    newQuantity.setNumericalValue(quotient);

    //HELP should i concatenate units ???

    //set new quantity's units to hold calling object's units with exp's
    newQuantity.setUnits(new HashMap(this.units));

    //calculate exponents
    calculateExponentInDiv(paramQuantity);

    return newQuantity;
  }

  /** This method raises this to the given power and returns the result
   * It takes in a single int argument (positive, negative, or zero)
   * The result should be a brand new Quantity object
   * This quantity should not change
   * @param int powerInt
   * @return Quantity newQuantity
   */
  public Quantity pow(int powerInt)
  {
    Quantity newQuantity = new Quantity();

    return newQuantity;
  }

  ///////////////////////////////helper methods////////////////////////////////

  /** calculate exponent in the div method */
  public void calculateExponentInDiv(Quantity paramQuantity)
  {
    //loop through ever string in units hash map
    for(String string : paramQuantity.units.keySet())
    {
      //if there's nothing mapped to our current key
      if(((Integer)paramQuantity.units.get(string)) == null)
      {
        //map a zero to it
        paramQuantity.units.put(string,new Integer(0));
      }
      //if paramQuantity's map has this current key
      if(paramQuantity.units.containsKey(string))
      {
        //get the value to which the string is mapped
        int keysMappedValue =
          ((Integer)paramQuantity.units.get(string)).intValue();

        //HELP how do i know whether to increment or decrement
        //ie how do i know ifim working with pos or neg exponent
        //how do i make my helper method so it works with both pos and neg exp's

        //adjust the exponent's value count (first time keysMappedvalue == 0)
        int exponentsValue = keysMappedValue++;

        //add new integer to quantity hash map ie either increase or decrease it
        paramQuantity.units.put(string,new Integer(exponentsValue));
      }
      //if our units map doesnt have this key (string) put it in
      else
      {
        //HELP how do i know whether im adding a key that has
        //a neg exponent or a pos exponent???
        //put it in and set its key to map to the integer 1 or -1
        this.units.put(string,new Integer(1));
      }
    }
  }

  /** calculate exponent in the mul method */
  public void calculateExponentInMul(Quantity paramQuantity)
  {
    //loop through ever string in units hash map
    for(String string : paramQuantity.units.keySet())
    {
      //if there's nothing mapped to our current key
      if(((Integer)paramQuantity.units.get(string)) == null)
      {
        //map a zero to it
        paramQuantity.units.put(string,new Integer(0));
      }
      //if paramQuantity's map has this current key
      if(paramQuantity.units.containsKey(string))
      {
        //get the value to which the string is mapped
        int keysMappedValue =
          ((Integer)paramQuantity.units.get(string)).intValue();

        //HELP how do i know whether to increment or decrement
        //ie how do i know ifim working with pos or neg exponent
        //how do i make my helper method so it works with both pos and neg exp's

        //adjust the exponent's value count (first time keysMappedvalue == 0)
        int exponentsValue = keysMappedValue++;

        //add new integer to quantity hash map ie either increase or decrease it
        paramQuantity.units.put(string,new Integer(exponentsValue));
      }
      //if our units map doesnt have this key (string) put it in
      else
      {
        //HELP how do i know whether im adding a key that has
        //a neg exponent or a pos exponent???
        //put it in and set its key to map to the integer 1 or -1
        this.units.put(string,new Integer(1));
      }
    }
  }

  /** calculate exponent in the 3 arg constructor
   *@param String for the positive exponent unit
   *@param String for the negative exponent unit
   *@param List for the positive exponent strings
   *@param List for the negative exponent strings
   *@param int for the value of the positive exponent
   *@param int for the value of the negative exponent
   */
  public void calculateExponentInConstructor(String posExpString,
      String negExpString, List posExpUnits, List negExpUnits,
      int posExponentValue, int negExponentValue)
  {
    //loop through pos exp list and count how many of each string 
    for(int i = 0; i < posExpUnits.size(); i++)
    {
      //set string to next string in list
      posExpString = ((String)posExpUnits.get(i));

      //if there's nothing mapped to our key
      if(((Integer)this.units.get(posExpString)) == null)
      {
        //map zero to it
        this.units.put(posExpString,new Integer(0));
      }
      //if our units map has this key (string) (ie m for meter)
      if(this.units.containsKey(posExpString))
      {
          //get the value to which the string is mapped or null if not mapping
          int keysMappedValue = ((Integer)this.units.get(posExpString)).intValue();

          //adjust the exponent's value count (first time keysMappedValue == 0)
          posExponentValue = keysMappedValue++;

          //add new integer to our quantity hash map..aka increase it
          this.units.put(posExpString,new Integer(posExponentValue));
      }
      //if our units map doesnt have this key (string) put it in
      else
      {
        //put it in and set its kep to map to the integer 1
        this.units.put(posExpString,new Integer(1));
      }
    }
    //loop through neg exp list and count how many items are in each list
    for(int i = 0; i < negExpUnits.size(); i++)
    {
      //set string to next string in list
      negExpString = ((String)negExpUnits.get(i));

      //if there's nothing mapped to our key
      if(((Integer)this.units.get(negExpString)) == null)
      {
        //map zero to it
        this.units.put(negExpString,new Integer(0));
      }
      //if our units map has this key (string) (ie m for meter)
      if(this.units.containsKey(negExpString))
      {
          //get the value to which the string is mapped or null if not mapping
          int keysMappedValue = ((Integer)this.units.get(negExpString)).intValue();

          //adjust the exponent's value count (first time keysMappedValue == 0)
          posExponentValue = keysMappedValue--;

          //add new integer to our quantity hash map..aka decrease it
          this.units.put(posExpString,new Integer(negExponentValue));
      }
      //if our units map doesnt have this key (string) put it in
      else
      {
        //put it in and set its kep to map to the integer 1
        this.units.put(negExpString,new Integer(-1));
      }
    }
  }

  /** gets numerical value of a quantity 
   * @return double referencing calling object's numerical value
   * */
  public double getNumericalValue()
  {
    return this.numericalValue;
  }

  /** gets units of a quantity 
   * @return Map<String,Integer> referencing calling object's units
   */
  public Map<String,Integer> getUnits()
  {
    return this.units;
  }

  /** sets numerical value of a quantity
   * @param double the numerical value we're setting to
   */
  public void setNumericalValue(double paramNumericalValue)
  {
    this.numericalValue = paramNumericalValue;
  }

  /** sets units of a quantity
   * @param Map<String,Integer> the units we are to set to
   */
  public void setUnits(Map<String,Integer> paramUnits)
  {
    this.units = paramUnits;
  }
}

