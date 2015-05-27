/* CSE12 Homework 8
 * Brianna Torres Yamanaka: A10690742, cs12spq
 * Jessica Yang: A98071336, cs12sim
 * Jessica Sec A00
 * Brianna: Sec A01
 * 5.23.15
 */

package hw8;

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
