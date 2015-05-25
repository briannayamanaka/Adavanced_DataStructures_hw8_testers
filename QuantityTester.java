/* CSE12 Homework 8
 * Brianna Torres Yamanaka: A10690742, cs12spq
 * Jessica Yang: A98071336, cs12sim
 * Jessica Sec A00
 * Brianna: Sec A01
 * 5.23.15
 */

package hw8

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/**
 * @author Brianna Torres Yamanaka, A10690742, cs12spq
 * @author Jessica Yang, A98071336, cs12sim
 */

public class QuantityTester
{
  //instance variables
  Map<String,Quantity> database;
  List<String> empty;

  /**
   * Standard Test Fixture.
   */

  @Before
    public void setUp()
    {
      database = new HashMap<String,Quantity>();
      empty = new ArrayList<String>();

      database.put("km", new Quantity(1000, Arrays.asList("meter"), empty));
      database.put("day", new Quantity(24, Arrays.asList("hour"), empty));
      database.put("hour", new Quantity(60, Arrays.asList("minute"), empty));
      database.put("minute", new Quantity(60, Arrays.asList("second"), empty));
      database.put("hertz", new Quantity(1, empty, Arrays.asList("second")));
      database.put("kph", new Quantity(1, Arrays.asList("km"),
            Arrays.asList("hour")));
    }

  /** Test if multiply method correctly multiplies values */
  @Test
    public void testMul()
    {

    }

  /** Test if divide method correctly divides values */
  @Test
    public void testDiv()
    {

    }

  /** Test if add method correctly adds values */
  @Test
    public void testAdd()
    {

    }

  /** Test if subtract method correctly subtracts values */
  @Test
    public void testSub()
    {

    }

  /** Test if negate method correctly negates values*/
  @Test
    public void testNegate()
    {

    }

  /** Test if NormalizeUnit method correctly normalizes unties */
  @Test
    public void testNormalizeUnit()
    {

    }

  /** Test if normalize method correctly normalizes values */
  @Test
    public void testNormalize()
    {

    }

  /** Test if power method correctly takes the powers of values*/
  @Test
    public void testPow()
    {

    }

  /** Test if equals method returns correctly returns true or false */
  @Test
    public void testEquals()
    {

    }

  /** Test if hashCode method correctly returns proper integer*/
  @Test
    public void testHashCode()
    {

    }
}
