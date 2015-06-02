/* CSE12 Homework 8
 * Brianna Torres Yamanaka: A10690742, cs12spq
 * Jessica Yang: A98071336, cs12sim
 * Jessica Sec A00
 * Brianna: Sec A01
 * 5.23.15
 */

package hw8;

import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
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
  private static double num;

  //instance variable to represent the string unit of a quantity
  private Map<String,Integer> units;

  /** 0-argument constructor. Creates a default quantity of value
   * 1 and no units. Even when there are no units the object should
   * still contain a map object (map with no entries).
   */
  public Quantity()
  {
    //set quantity to be of value one
    num = 1;
    //create a new hashmap with no entries
    units = new HashMap();
  }

  /**
   * 1-arg constructor. Creates a deep copy ie the new Quantity will
   * be a dif object with its own instance variables and will contain
   * a copy of the Map object referenced by the argument Quantity.
   * @param copy the Quantity object that will be deep copied.
   */
  public Quantity(Quantity toCopy)
  {
    //set numerical value to be passed in quantity's numerical value
    this.num = toCopy.getNum();
    //create a new map with toCopy's datafield
    this.units = new HashMap(toCopy.getUnits());
  }

  /**
   * 3-argument constructor. Creates a quantity with 3 passed in
   * parameters, one list representing the numerator units and the
   * other representing the denominator units.
   * @throws IllegalArgumentException if either of the list argument is null.
   * @param num the numeric value.
   * @param numerator units in the numerator(positive exponents).
   * @param denominator units in the denominator(negative exponents).
   */
  public Quantity(double value, List<String> numerator,
      List<String> denominator) throws IllegalArgumentException
  {
    //throw new illegal argument exception when trying to pass in null
    if(numerator == null || denominator == null)
      throw new IllegalArgumentException("Units cannot be null.");
    //set numerical value to be passed
    num = value;
    //create a new hashmap
    units = new HashMap();
    //create an interator for each list to traverse through the elements
    Iterator numerIter = numerator.iterator();
    Iterator denomIter = denominator.iterator();
    //create holder instance variables for the elements
    String numerUnit = "";
    String denomUnit = "";
    //a while loop that loops through the numerator list
    while(numerIter.hasNext())
    {
      //numerUnit stores the string value of unit that is going to be mapped
      numerUnit = (String)numerIter.next();
      //call the method to store in the hashmap
      //the numerator list has positive 1 value of the exponent
      adjustExponentBy(numerUnit, 1);
    }
    //a while loop that loops through the denominator list
    while(denomIter.hasNext())
    {
      denomUnit = (String)denomIter.next();
      //the denominator list has negative 1 value of the exponent
      adjustExponentBy(denomUnit, -1);
    }
  }

  /**
   * Method that takes a single Quantity argument, multiplies this by the
   * argument and returns the result.
   * @throws IllegalArgumentException if its argument is null.
   * @param multiple the Quantity that is going to be multiplied to.
   * @return brand new Quantity object of the result.
   */
  public Quantity mul(Quantity multiple) throws IllegalArgumentException
  {
    //if statement that checks the exception
    if(multiple == null)
      throw new IllegalArgumentException("Cannot multiply null.");

    //create new Quantity that's going to be returned
    Quantity temp = new Quantity();
    //multiply the numerical values of each quantity
    temp.setNum((double)(multiple.getNum() * getNum()));
    //create new hashmap with same mappings as this quantity
    temp.setUnits(new HashMap(units));

    //create an iterator to traverse through the set of parameters map
    Iterator setIter = multiple.getUnits().keySet().iterator();
    //create a holer variable while traversing through the set
    String unit = "";
    //a while loop that loops through each element in the set
    while(setIter.hasNext())
    {
      //store the next value in the holder created earlier
      unit = (String)setIter.next();
      //get the int value(exponent) corresponding to the string value
      Integer exponent = multiple.getUnits().get(unit).intValue();
      //call the method and combine with existing values
      //positive exponent adding onto current one beacuse multiplying
      temp.adjustExponentBy(unit, exponent);
    }

    return temp;
  }

  /**
   * Method that takes a single Quantity argument, divides this by the
   * argument, and returns the result.
   * @throws IllegalArgumentException if its argument is null or value is 0.
   * @param divide the Quantity that is going to be divided.
   * @return brand new Quantity object of the result.
   */
  public Quantity div(Quantity divide) throws IllegalArgumentException
  {
    //check exceptions
    if(divide == null)
      throw new IllegalArgumentException("Cannot divide null.");
    if(divide.getNum() == 0)
      throw new IllegalArgumentException("Cannot divide by 0.");

    //create new quantity that's going to be returned
    Quantity temp = new Quantity();
    //calculate the numerical values of each quantity
    temp.setNum((double)(getNum() / divide.getNum()));
    //create new hashmap with same mappings as this quantity
    temp.setUnits(new HashMap(units));

    //create an iterator to traverse through the set of parameters map
    Iterator setIter = divide.getUnits().keySet().iterator();
    //create holder variable while traversing
    String unit = "";
    //while loop that loops through
    while(setIter.hasNext())
    {
      //store the next value in holder
      unit = (String)setIter.next();
      //get the int value(exponent) corresponding to string value
      Integer exponent = divide.getUnits().get(unit).intValue();
      //call the method and combine with existing with existing value
      //use negative exponent and substracting fromg current one
      //because it is dividing
      temp.adjustExponentBy(unit, -exponent);
    }

    return temp;
  }

  /**
   * Method that takes a single int argument and raises this to the given
   * power.
   * @param power the Quantity that is going to be raised to.
   * @return brand new Quantity object of the result.
   */
  public Quantity pow(int power)
  {
    //create new quantity thats going to be returned
    Quantity temp = new Quantity();
    //calculate the numerical values of each quantity
    temp.setNum((double)Math.pow(getNum(), power));
    //create a fresh empty hashmap without same mapping as this
    temp.setUnits(new HashMap());

    //create iterator traverse through the map
    Iterator setIter = getUnits().keySet().iterator();
    //holder variable for traversing
    String unit = "";

    //for loop that traverse through the set
    while(setIter.hasNext())
    {
      //store the next value
      unit = (String)setIter.next();
      //get the exponent value from the list
      //the set returns Integer object but automatically unwraps to
      //primitive int
      int exponent = getUnits().get(unit);
      //call the method and calculate the new value of quantity
      temp.adjustExponentBy(unit, exponent * power);
    }

    return temp;
  }

  /**
   * Method that takes a single Quantity argument and adds this to it.
   * @throws IllegalArgumentException if its argument is null or different units.
   * @param add the Quantity that is going to be added.
   * @return brand new Quantity object of the result.
   */
  public Quantity add(Quantity add) throws IllegalArgumentException
  {
    //check for exceptions
    if(add == null)
      throw new IllegalArgumentException();
    if(!add.getUnits().equals(getUnits()))
      throw new IllegalArgumentException();

    //create new quantity that's going to be returned
    Quantity temp = new Quantity();
    //add the numerical values, since we're not changing the units here, so
    //no need to call the adjust method
    temp.setNum((double)(add.getNum() + getNum()));
    //the quantity has a new hashmap that has the same mapping as this
    temp.setUnits(new HashMap(units));

    return temp;
  }

  /**
   * Method that takes a single Quantity argument and subtracts it from this.
   * @throws IllegalArgumentException if its argument is null or different units.
   * @param subtract the Quantity that is going to be subtracted.
   * @return brand new Quantity object of the result.
   */
  public Quantity sub(Quantity subtract) throws IllegalArgumentException
  {
    //check for exceptions
    if(subtract == null)
      throw new IllegalArgumentException();
    if(!subtract.getUnits().equals(getUnits()))
      throw new IllegalArgumentException();

    //create new quantity that's going to be returned
    Quantity temp = new Quantity();
    //calculate the numerical value of the new quantity
    temp.setNum((double)(getNum() - subtract.getNum()));
    //set the quantity's hashmap to be the same mapping as this
    //since we're not changing the unit in subtraction, we do not
    //need to adjust the exponents like divide and multiply
    temp.setUnits(new HashMap(units));

    return temp;
  }

  /**
   * Method that takes no arguments and negates this Quantity.
   * @return the negation of this Quantity.
   */
  public Quantity negate() {
    //create a new holder quantity that's going to be returned
    Quantity temp = new Quantity();
    //negate the numerical value by calculating a negative of current
    //numerical value
    temp.setNum(-temp.getNum());
    //since we're not changing the unit values in the hashmap, just
    //copy the current map value
    temp.setUnits(new HashMap(units));

    return temp;
  }

  /**
   * Method that returns the Quantity as a string.
   * @return the string of the Quantity.
   */
  public String toString() {
    double valueOfTheQuantity = this.num;
    Map<String,Integer> mapOfTheQuantity = this.units;

    // Ensure we get the units in order
    TreeSet<String> orderedUnits =
        new TreeSet<String>(mapOfTheQuantity.keySet());
    StringBuffer unitsString = new StringBuffer();

    for (String key : orderedUnits) {
      int expt = mapOfTheQuantity.get(key);
      unitsString.append(" " + key);
      if (expt != 1) unitsString.append("^" + expt);
    }
    // Used to convert doubles to a string with a 
    //   fixed maximum number of decimal places.
    DecimalFormat df = new DecimalFormat("0.0####");

    // Put it all together and return.
    return df.format(valueOfTheQuantity) + unitsString.toString();
  }

  /**
   * Method that takes any single object and returs true if and only if
   * the object is a Quantity whose units are exactly the same as the
   * calling object and whose value is the same when rounded to five places
   * after decimal point.
   * @param compare the object that is compared to.
   * @return true if the object is same or not.
   */
  public boolean equals(Object compare)
  {
    //check if the comparing object is null or not and is an object of
    //Quantity, if not, then theyre not equal at first place
    if((compare != null) && (compare instanceof Quantity))
    {
      //compare the string value of both objects and if theyre equal,
      //then return true.
      boolean result = toString().equals(compare.toString());
      return result;
    }
    else
      return false;
  }

  /**
   * Method that returns an integer such that equal Quantities always returns
   * the same integer.
   * @return the hash code of the Quantity.
   */
  public int hashCode()
  {
    //return the hashcode of the string value
    return this.toString().hashCode();
  }

  /**
   * Method that takes a string(name of a unit) and a map(a units database),
   * and create a brand-new normalized Quantity equivalent to one of the given
   * unit.
   * @param name the name of the unit.
   * @param data units database.
   * @return a brand-new normalized Quantity.
   */
  public static Quantity normalizedUnit(String name, Map<String, Quantity> data)
  {
    //create new quantity that stores the returning quantity
    Quantity temp;

    //check if the database contains the unit already
    if(data.containsKey(name))
    {
      //get the data value value and store in holder
      temp = data.get(name);
      //normalize the quantity that matches the string value
      temp = temp.normalize(data);
    }
    else
    {
      //If the unit does not appear as a key in the database returns
      //a new Quantity representing 1 of the argument unit
      List<String> empty = Collections.<String>emptyList();
      temp = new Quantity(1,Arrays.asList(name),empty);
    }

    return temp;
  }

  /**
   * Method that takes in a database and returns a copy of this but normalized
   * form (with all defined units expanded out into primitive units).
   * @param data the database of the unit.
   * @return the copy of this Quantity in normalized form.
   */
  public Quantity normalize(Map<String, Quantity> data)
  {
    //create a new holder temp quantity that's going to be returned
    //in the end of method
    Quantity temp = new Quantity();
    //set the numerical value the same as this quantity
    temp.setNum(getNum());

    //create an iterator used to traverse through the map set
    Iterator setIter = getUnits().keySet().iterator();
    //holder variable while traversing
    String unit = "";

    //while loop that traverse through the set
    while(setIter.hasNext())
    {
      //put the next value in the holder variable
      unit = (String)setIter.next();
      //get the value corresponding to the current key
      //the set returns Integer object, but it is automatically
      //unwrapped to primitive integer
      int exponent = getUnits().get(unit);
      //normalize the unit by calling the normalized unit method on
      //the string value and database
      Quantity normalized = normalizedUnit(unit, data);
      //if the exponent value of the string is positive, then add
      //the units onto the returning quantity
      if(exponent > 0)
      {
        //multiply(add units) depending on the exponent value
        for(int i = 0; i < exponent; i++)
          temp = temp.mul(normalized);
      }
      //if the exponent value of the string is negative, then subtract
      //the units from the returning quantity
      if(exponent < 0)
      {
        //divide(subtract units) depending on the exponent value
        for(int i = 0; i > exponent; i--)
          temp = temp.div(normalized);
      }
    }

    return temp;
  }

  /* **************************\
   *       HELPER METHODS      *
   \***************************/

  /**
   * Gets the numerical value of quantity.
   * @return double referencing calling object's numerical value.
   */
  public double getNum()
  {
    return num;
  }

  /**
   * Gets the units of a quantity.
   * @return Map<String,Integer> referencing calling object's units.
   */
  public Map<String,Integer> getUnits()
  {
    return units;
  }

  /**
   * Sets the numerical value of a quantity.
   */
  public static void setNum(double value)
  {
    num = value;
  }

  /**
   * Sets the units of a quantity.
   */
  public void setUnits(Map<String, Integer> unit)
  {
    units = unit;
  }

  /**
   * Private helper method that adds to the existing exponent in the
   * units map; It adds the unit to the map if it wasnt there already,
   * and deletes it from the map, if the adjusted exponent is 0.
   * @param unit the string name of the unit
   * @param exponent the exponent value of the unit
   */
  private void adjustExponentBy(String unit, int exponent)
  {
    //if the string name is already contained in the map, then add onto
    //the current map
    if(units.containsKey(unit))
    {
      //get the existing exponent value thats stored in the map already
      //the map returns Integer object, but automatically unwraps to
      //primitive integer
      int currentPow = units.get(unit);
      //add the exponent to the existing one, this is the adjusted exponent
      currentPow += exponent;
      //if the resulting value is 0, then delete it from the map
      if(currentPow == 0)
        units.remove(unit);
      //if not 0, then update the unit to the hashmap
      else
        //add the updated version of the unit and its value
        //If the map previously contained a mapping for the key,
        //the old value is replaced.
        units.put(unit, new Integer(currentPow));
    }
    //if the string name is not on the map, then create a new key, value
    //and add to the map.
    else
    {
      units.put(unit, new Integer(exponent));
    }
  }
}
