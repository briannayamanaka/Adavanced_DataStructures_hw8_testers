/* CSE12 Homework 8
 * Brianna Torres Yamanaka: A10690742, cs12spq
 * Jessica Yang: A98071336, cs12sim
 * Jessica Sec A00
 * Brianna: Sec A01
 * 5.23.15
 */

package hw8; 

import java.util.*;

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
    this.units = new HashMap();

    //set the numerical value to be passed in numerical value
    this.numericalValue = paramNumericalValue;

    //create string for positive exponential unit
    String posExpString = posExpUnits.get(0);

    //create string for negative exponential unit
    String negExpString = negExpUnits.get(0);

    //create an int for the initial pos exponent
    int posExponentValue = 0;

    //create an int for the initial neg exponent
    int negExponentValue = 0;


    //loop through pos exp list and count how many of each string 
    for(int i = 0; i < posExpUnits.size(); i++)
    {
      //set string to next string in list
      posExpString = posExpUnits.get(i);

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

          //remove string from the list so it doesnt get recounted
          posExpUnits.remove(posExpString);
      }
      //if our units map doesnt have this key (string) put it in
      else
      {
        //put it in and set its kep to map to the integer 1
        this.units.put(posExpString,new Integer(1));

        //remove it so as to not recount it
        posExpUnits.remove(posExpString);
      }
    }
    //loop through neg exp list and count how many items are in each list
    for(int i = 0; i < negExpUnits.size(); i++)
    {
      negExpString = negExpUnits.get(i);
    }
  }

  /** This method multiplies this by the argument and returns the result
   *  Returned value should be a brand new Quantity object
   *  Neither this quantity nor the argument quantity should cnage
   *  @param value
   */
  public Quantity mul(Quantity paramQuantity)
  {
    double thisNumericalValue;

    double paramNumericalValue;

    thisNumericalValue = this.getNumericalValue();

    paramNumericalValue = paramQuantity.getNumericalValue();
     return new Quantity();
  }

  ///////////////////////////////helper methods////////////////////////////////

  /** counts how many time each unit repeats to calculate exponent
   * @param unitString the unit we are counting
   * @param exponent the exponent (pos or neg)
   */
/*
     private void calculateExponent(String unitString, int exponent)
     {
        //if list contains unitString, keep count and remove it
        if(this.units.containsKey(unitString))
          {

          }
     }
*/

  /** gets numerical value of a quantity */
  public double getNumericalValue()
  {
    return this.numericalValue;
  }
}
