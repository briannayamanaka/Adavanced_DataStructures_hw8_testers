/* CSE12 Homework 8
 * Brianna Torres Yamanaka: A10690742, cs12spq
 * Jessica Yang: A98071336, cs12sim
 * Jessica Sec A00
 * Brianna: Sec A01
 * 5.23.15
 */

package hw8solutions;

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
  //private Map<String,Quantity> meter10;
  //private Map<String,Quantity> meter2;

  private Quantity meter10;
  private Quantity meter2;
  private Quantity meter1;
  private Quantity quantity;
  private Quantity quantity2;
  private Quantity quantity3;

  private Map<String,Quantity> database;

  private List<String> empty;

  /**
   * Standard Test Fixture.
   */
  @Before
    public void setUp()
    {
      database = new HashMap<String,Quantity>();
      empty = new ArrayList<String>();

      //meter10 = new HashMap<String,Quantity>();
      //meter2 = new HashMap<String,Quantity>();;

      meter10 = new Quantity(10.0);
      meter2 = new Quantity(2.0);
      meter1 = new Quantity(1.0);
      quantity = new Quantity(60.0, Arrays.asList("kph"), empty);
      quantity2 = new Quantity(1.0, Arrays.asList("km"), empty);
      quantity3 = new Quantity(10.0, Arrays.asList("km"),
          Arrays.asList("second"));

      //meter10.put("m",new Quantity(5, Arrays.asList("meter"),empty));
      //meter2.put("m",new Quantity(5, Arrays.asList("meter"),empty));

      database.put("km", new Quantity(1000, Arrays.asList("meter"), empty));
      database.put("day", new Quantity(24, Arrays.asList("hour"), empty));
      database.put("hour", new Quantity(60, Arrays.asList("minute"), empty));
      database.put("minute", new Quantity(60, Arrays.asList("second"), empty));
      database.put("hertz", new Quantity(1, empty, Arrays.asList("second")));
      database.put("kph", new Quantity(1, Arrays.asList("km"),
            Arrays.asList("hour")));
    }

    //REMINDER: ASSERTEQUALS(EXPECTED, ACTUAL)

  /** Test if no arg constructor correctly creates a quantity */
  @Test
    public void testNoArgConstructor()
    {
      assertTrue(new Quantity().equals(new Quantity(1)));
    }

  /** Test if deep copy constructory correctly creates a deep copy */
  @Test
    public void testDeepCopyConstructor()
    {
      assertTrue(meter10.equals(new Quantity(meter10)));
    }

  /** Test if deep copy constructor correctly throws exception */
  @Test
    public void testDeepCopyConstructorException()
    {
      try
      {
        Quantity quantity = new Quantity(null);
        fail("Should throw IllegalArgumentException");
      }
      catch(IllegalArgumentException e) {}
    }

  /** Test if 3 arg constructor correctly creates a quantity */
  @Test
    public void testThreeArgConstructor()
    {
      Quantity quantity = new Quantity(10.0, Arrays.asList("m"),
          Arrays.asList("s","s"));
      assertTrue(quantity.equals(new Quantity(quantity)));
    }
 
  /** Test if multiply method correctly multiplies values */
  @Test
    public void testMul()
    {
      assertTrue(meter10.mul(meter2).equals(new Quantity(20.0)));
    }

  /** Test if divide method correctly divides values */
  @Test
    public void testDiv()
    {
      assertTrue(meter10.div(meter2).equals(new Quantity(5.0)));
    }

  /** Test if add method correctly adds values */
  @Test
    public void testAdd()
    {
      assertTrue(meter10.add(meter2).equals(new Quantity(12)));
    }

  /** Test if subtract method correctly subtracts values */
  @Test
    public void testSub()
    {
      assertTrue(meter10.sub(meter2).equals(new Quantity(8)));
    }

  /** Test if negate method correctly negates values*/
  @Test
    public void testNegate()
    {
      assertTrue(meter10.negate().equals(new Quantity(-10)));
    }

  /** Test if NormalizeUnit method correctly normalizes unties */
  @Test
    public void testNormalizeUnit()
    {
      assertTrue(Quantity.normalizedUnit("km",database).equals(new Quantity(1000,
              Arrays.asList("meter"),empty)));
    }

  /** Test if normalize method correctly normalizes values */
  @Test
    public void testNormalize()
    {
      assertTrue(quantity2.normalize(database).equals(new Quantity(1000,
              Arrays.asList("meter"), empty)));
    }

  /** Test if power method correctly takes the powers of values*/
  @Test
    public void testPow()
    {
      //positive exponent
      assertTrue(meter2.pow(2).equals(new Quantity(4.0)));

      //negative exponent
      assertTrue(meter1.pow(-1/5).equals(new Quantity(1.0)));
    }

  /** Test if equals method returns correctly returns true or false */
  @Test
    public void testEquals()
    {
      assertTrue(meter2.equals(new Quantity(2.0)));
    }

  /** Test if hashCode method correctly returns proper integer*/
  @Test
    public void testHashCode()
    {
      assertFalse((quantity.hashCode()) == (quantity2.hashCode()));
      assertTrue((quantity3.hashCode()) == (quantity3.hashCode()));
    }
}


