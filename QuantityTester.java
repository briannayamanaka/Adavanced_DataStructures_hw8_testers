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





//XXX change package to hw8
package hw8solutions;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Junit test class for Quantity class.
 */
public class QuantityTester {

  //create some new Quantities for tests
  List<String> emptyList;
  Map<String,Quantity> db;
  Map<String,Quantity> extend;
  List<String> emp;
  QuantityDB database;
  Quantity empty;
  Quantity centimeter;
  Quantity horsepower;
  Quantity day;
  Quantity year;
  Quantity gravC; //gravitational constant

  /**
   * Setup the tests and initialize them.
   */
  @Before
  public void setUp() {
    //empty list
    emptyList = Collections.<String>emptyList();

    //initializes the instance variables
    empty = new Quantity();
    centimeter = new Quantity(0.01, Arrays.asList("meter"), emptyList);
    horsepower = new Quantity(550.0, Arrays.asList("foot", "pound_force"), Arrays.asList("second"));
    day = new Quantity(24.0, Arrays.asList("hour"), emptyList);
    year = new Quantity(365.25, Arrays.asList("day"), emptyList);
    gravC = new Quantity(6.67259e-11, Arrays.asList("meter", "meter", "newton"), 
        Arrays.asList("kg", "kg"));

    //setup map database
    db = new HashMap<String,Quantity>();
    emp = new ArrayList<String>();
    db.put("km", new Quantity(1000, Arrays.asList("meter"), emp));
    db.put("day", new Quantity(24, Arrays.asList("hour"), emp));
    db.put("hour", new Quantity(60, Arrays.asList("minute"), emp));
    db.put("minute", new Quantity(60, Arrays.asList("second"), emp));
    db.put("hertz", new Quantity(1, emp, Arrays.asList("second")));
    db.put("kph", new Quantity(1, Arrays.asList("km"), Arrays.asList("hour")));

    database = new QuantityDB();
    extend = database.getDB();
  }

  /**
   * Tester for the no argument constructor.
   */
  @Test
  public void testConstruct1() {
    Quantity noConstruct = new Quantity();
    assertTrue(noConstruct.equals(empty));

    //since the no argument constructor creates default quantity of
    //value 1 and no units, adding them will result in 2
    Quantity addEmptys = empty.add(empty);
    assertTrue(addEmptys.equals(new Quantity(2, emptyList, emptyList)));

    //1 * 1 = 1
    Quantity mulEmptys = empty.mul(empty);
    assertTrue(mulEmptys.equals(new Quantity(1, emptyList, emptyList)));
  }

  /**
   * Tester for the constructor that takes a single Quantity
   * argument.
   */
  @Test
  public void testConstruct2() {
    Quantity copied0 = new Quantity(horsepower);
    Quantity copied1 = new Quantity(day);
    Quantity copied2 = new Quantity(gravC);

    //compare the original to copied object
    assertTrue(copied0.equals(horsepower));
    assertTrue(copied1.equals(day));
    assertTrue(copied2.equals(gravC));
  }

  /**
   * Tester for the 3-argument constructor.
   */
  @Test
  public void testConstruct3() {
    //create new object and compare it to expected ones
    Quantity newObj0 = new Quantity(550.0, Arrays.asList("foot", "pound_force"), Arrays.asList("second"));
    assertTrue(newObj0.equals(horsepower));

    Quantity newObj1 = new Quantity(6.67259e-11, Arrays.asList("meter", "meter", "newton"),
        Arrays.asList("kg", "kg"));
    assertTrue(newObj1.equals(gravC));
  }

  /**
   * Tester for the 3-argument exception.
   */
  @Test
  public void testConstructException() {
    //catch if first list is null
    try {
      Quantity exception = new Quantity(0, null, emptyList);
      fail();
    } catch(IllegalArgumentException e) {}

    //catch if second list is null
    try {
      Quantity exception = new Quantity(0, emptyList, null);
      fail();
    } catch(IllegalArgumentException e) {}

    //catch if both lists are null
    try {
      Quantity exception = new Quantity(0, null, null);
      fail();
    } catch(IllegalArgumentException e) {}

    //doesnt fail if both lists are empty
    try {
      Quantity exception = new Quantity(0, emptyList, emptyList);
    } catch(IllegalArgumentException e) {}

  }

  /**
   * Tester for multiply.
   */
  @Test
  public void testMul() {
    //test multiple combination of multiplies
    assertEquals(empty, empty.mul(empty));
    assertEquals(new Quantity(0.24, Arrays.asList("meter", "hour"), emptyList), day.mul(centimeter));
    assertEquals(new Quantity(8766, Arrays.asList("hour", "day"), emptyList), year.mul(day));
    assertEquals(new Quantity(0, Arrays.asList("foot", "pound_force", "meter", "meter", "newton"),
          Arrays.asList("second", "kg", "kg")), horsepower.mul(gravC));
  }

  /**
   * Tester for multiply exception.
   */
  @Test
  public void testMulException() {
    //fail if the multiplying object is null
    try {
      Quantity exception = empty.mul(null);
      fail();
    } catch(IllegalArgumentException e) {}

    try {
      Quantity exception = horsepower.mul(null);
    } catch(IllegalArgumentException e) {}
  }

  /**
   * Tester for divide.
   */
  @Test
  public void testDiv() {
    //test multiple combination of divisions
    assertEquals(empty, empty.div(empty));
    assertEquals(new Quantity(0.06571, Arrays.asList("hour"), Arrays.asList("day")), day.div(year));
    assertEquals(new Quantity(0.00002, Arrays.asList("meter", "second"), Arrays.asList("foot", 
            "pound_force")), centimeter.div(horsepower));
    assertEquals(empty, gravC.div(gravC));
  }

  /**
   * Tester for divide exception.
   */
  public void testDivException() {
    //catch exception if dividing null object
    try {
      Quantity exception = year.div(null);
      fail();
    } catch(IllegalArgumentException e) {}

    try {
      Quantity exception = gravC.div(null);
      fail();
    } catch(IllegalArgumentException e) {}

    //catch exception of dividing a 0 value
    try {
      Quantity exception = horsepower.div(new Quantity(0, Arrays.asList("hour"), emptyList));
      fail();
    } catch(IllegalArgumentException e) {}

    try {
      Quantity exception = empty.div(new Quantity(0, emptyList, Arrays.asList("ThisProgramIsSoLong")));
      fail();
    } catch(IllegalArgumentException e) {}
  }

  /**
   * Tester for power.
   */
  @Test
  public void testPow() {
    //test couple combinations of powers
    assertEquals(empty, empty.pow(50));
    assertEquals(new Quantity(0, emptyList, Arrays.asList("day", "day", "day")), year.pow(-3));
    assertEquals(new Quantity(0, Arrays.asList("meter", "meter", "meter", "meter", "meter"),
          emptyList), centimeter.pow(5));
    assertEquals(new Quantity(0.00182, Arrays.asList("second"), Arrays.asList("foot", "pound_force")),
          horsepower.pow(-1));
  }

  /**
   * Tester for add.
   */
  @Test
  public void testAdd() {
    //add several combinations of Quantity
    assertEquals(new Quantity(1100, Arrays.asList("foot", "pound_force"), Arrays.asList("second")),
          horsepower.add(horsepower));
    assertEquals(new Quantity(48, Arrays.asList("hour"), emptyList), day.add(day));
    assertEquals(new Quantity(730.5, Arrays.asList("day"), emptyList), year.add(year));
    assertEquals(new Quantity(0, Arrays.asList("meter", "meter", "newton"), Arrays.asList("kg",
          "kg")), gravC.add(gravC));
  }

  /**
   * Tester for add exception.
   */
  @Test
  public void testAddException() {
    //catch exception when adding null object
    try {
      Quantity exception = empty.add(null);
      fail();
    } catch(IllegalArgumentException e) {}

    try {
      Quantity exception = gravC.add(null);
      fail();
    } catch(IllegalArgumentException e) {}

    //catch exception when adding different units
    try {
      Quantity exception = horsepower.add(year);
      fail();
    } catch(IllegalArgumentException e) {}

    try {
      Quantity exception = day.add(centimeter);
      fail();
    } catch(IllegalArgumentException e) {}
  }

  /**
   * Tester for subtract.
   */
  @Test
  public void testSub() {
    //subtract several combinations
    assertEquals(new Quantity(0, emptyList, emptyList), empty.sub(empty));
    assertEquals(new Quantity(0, Arrays.asList("day"), emptyList), year.sub(year));
    //add days by 3 and subtract
    Quantity tempDay = day.add(day).add(day);
    assertEquals(new Quantity(48, Arrays.asList("hour"), emptyList), tempDay.sub(day));
    assertEquals(new Quantity(24, Arrays.asList("hour"), emptyList), tempDay.sub(day).sub(day));
  }

  /**
   * Tester for subtract exception.
   */
  @Test
  public void testSubException() {
    //catch exception when subtracting null object
    try {
      Quantity exception = centimeter.sub(null);
      fail();
    } catch(IllegalArgumentException e) {}

    try {
      Quantity exception = horsepower.sub(null);
      fail();
    } catch(IllegalArgumentException e) {}

    //catch exception when subtracting different units
    try {
      Quantity exception = empty.sub(horsepower);
      fail();
    } catch(IllegalArgumentException e) {}

    try {
      Quantity exception = year.add(centimeter);
    } catch(IllegalArgumentException e) {}
  }

  /**
   * Tester for negate.
   */
  @Test
  public void testNegate() {
    assertEquals(new Quantity(-1, emptyList, emptyList), empty.negate());
    assertEquals(new Quantity(-550, Arrays.asList("foot", "pound_force"),
          Arrays.asList("second")), horsepower.negate());
    assertEquals(new Quantity(-0.01, Arrays.asList("meter"), emptyList)
          , centimeter.negate());
    assertEquals(new Quantity(-365.25, Arrays.asList("day"), emptyList)
          , year.negate());
  }

  /**
   * Tester for equals.
   */
  @Test
  public void testEquals() {
    assertEquals(new Quantity(1, emptyList, emptyList), empty);
    assertEquals(new Quantity(24, Arrays.asList("hour"), emptyList), day);
    assertEquals(new Quantity(0.01, Arrays.asList("meter"), emptyList), centimeter);
    assertEquals(new Quantity(550, Arrays.asList("foot", "pound_force"),
          Arrays.asList("second")), horsepower);
  }

  /**
   * Tester for hashCode.
   */
  @Test
  public void testHashCode() {
    assertEquals(48563, empty.hashCode());
    assertEquals(1281040251, year.hashCode());
    assertEquals(-119735459, gravC.hashCode());
    assertEquals(1227204776, centimeter.hashCode());
    assertEquals(-464128768, day.hashCode());
  }

  /**
   * Tester for normalized unit.
   */
  @Test
  public void testNormalizedUnit() {
    assertEquals(new Quantity(3600, Arrays.asList("second"), emptyList),
          day.normalizedUnit("hour", db));
    assertEquals(new Quantity(86400, Arrays.asList("second"), emptyList),
          year.normalizedUnit("day", extend));
    assertEquals(new Quantity(0.45359, Arrays.asList("kg"), emptyList),
          empty.normalizedUnit("pound", extend));
    assertEquals(new Quantity(1000, Arrays.asList("meter"), emptyList),
          centimeter.normalizedUnit("km", db));
    //Arrays.asList()
  }

  /**
   * Tester for normalize.
   */
  @Test
  public void testNormalize() {
    assertEquals(new Quantity(0, Arrays.asList("meter", "meter", "meter"),
          Arrays.asList("kg", "second", "second")), gravC.normalize(extend));
    assertEquals(new Quantity(31557600, Arrays.asList("second"), emptyList),
          year.normalize(db));
    assertEquals(new Quantity(86400, Arrays.asList("second"), emptyList),
          day.normalize(db));
    assertEquals(new Quantity(745.69987, Arrays.asList("kg", "meter", "meter"),
          Arrays.asList("second", "second", "second")), horsepower.normalize(extend));
    assertEquals(new Quantity(), empty.normalize(db));
  }

}
