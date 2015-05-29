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

/*Start with testing the lowest level rules (farthest away from the start).
  You'll need to manually create the Quantities you expect to get back,and then
  call the methods, and compare what actually comes back with the Quantities
  you manually created. */

/*You need to create a Unicalc object to test with
  and a list of tokens. */

/* HINT: You can have your Unicalc object call Tokenize.  Where you give it your
   desired list as a String.  This beats having to make separate linkedlists for
   each test. */

/**
 * Junit test class for Unicalc class.
 */
public class UnicalcTester
{
  //create new objects to test
  private Unicalc multiply;
  private Unicalc multiply2;
  private Unicalc divide;
  private Unicalc add;
  private Unicalc minus;
  private Unicalc power;
  private Unicalc negative;
  private Unicalc value;
  private Unicalc norm;
  private Unicalc define;

  //combination of arithmetics
  private Unicalc equation1;
  private Unicalc equation2;
  private Unicalc equation3;
  private Unicalc equation4;
  private Unicalc equation5;
  private Unicalc equation6;
  private Unicalc equation7;

  private Unicalc unicalc1;
  private Unicalc unicalc2;
  private Unicalc unicalc3;
  private Unicalc unicalc4;
  private Unicalc unicalc5;
  private Unicalc unicalc6;
  private Unicalc unicalc7;
  private Unicalc unicalc8;
  private Unicalc unicalc9;

  //objects other than unicalc
  private QuantityDB database;
  private Map<String,Quantity> db;
  private List<String> empty;

  /**
   * Setup the tests and initialize class variables.
   */
  @Before
  public void setUp()
  {
    //construct new object and assign strings
    multiply = new Unicalc();
    multiply.tokenize("9 * 8");
    multiply2 = new Unicalc();
    multiply2.tokenize("9(8)");
    divide = new Unicalc();
    divide.tokenize("4 / 2");
    add = new Unicalc();
    add.tokenize("1 + 1");
    minus = new Unicalc();
    minus.tokenize("2 - 0");
    power = new Unicalc();
    power.tokenize("5 ^ 7");
    negative = new Unicalc();
    negative.tokenize("-8");
    value = new Unicalc();
    value.tokenize("5");
    norm = new Unicalc();
    norm.tokenize("# 60Hz * 30s");
    define = new Unicalc();
    define.tokenize("def iphone 600 dollar");

    equation1 = new Unicalc();
    equation1.tokenize("6(2 + 8) - (30 / 6) ^ 5");
    equation2 = new Unicalc();
    equation2.tokenize("30 m + 20 cm - 10 km");
    equation3 = new Unicalc();
    equation3.tokenize("60 Hz * 30s / 60 km");
    equation4 = new Unicalc();
    //dividing by 0
    equation4.tokenize("2 ^ 2 - 3 / 0");
    equation5 = new Unicalc();
    equation5.tokenize("(-2) + (-2) - (-3) * 9");
    equation6 = new Unicalc();
    equation6.tokenize("3 iphone * 100 dollar - 10 dollar");
    equation7 = new Unicalc();
    equation7.tokenize("# 10 phone");

    unicalc1 = new Unicalc();
    unicalc1.tokenize("2^3");
    unicalc2 = new Unicalc();
    unicalc2.tokenize("2(3)");
    unicalc3 = new Unicalc();
    unicalc3.tokenize("-2");
    unicalc4 = new Unicalc();
    unicalc4.tokenize("2*3");
    unicalc5 = new Unicalc();
    unicalc5.tokenize("2/3");
    unicalc6 = new Unicalc();
    unicalc6.tokenize("2+3");
    unicalc7 = new Unicalc();
    unicalc7.tokenize("2-3");
    unicalc8 = new Unicalc();
    unicalc8.tokenize("# 3km");
    unicalc9 = new Unicalc();
    unicalc9.tokenize("def km 3 m");

    //initialize other objects
    database = new QuantityDB();
    db = database.getDB();
    empty = new ArrayList<String>();
  }

  /**
   * This method checks if R method correctly deals with exponents.
   */
  @Test
  public void testR()
  {
    //pass in string "2^3" or or "wm + 3m" ...
    assertEquals(new Power(new Value(new Quantity(2.0,empty,empty)),3),
        unicalc1.R());
    assertEquals(new Power(new Value(new Quantity(5,empty,empty)),7),
        power.R());
    assertEquals(new Value(new Quantity(6, empty, empty)),equation1.R());
    assertEquals(new Value(new Quantity(30, empty, empty)),equation2.R());
    assertEquals(new Value(new Quantity(60, empty, empty)),equation3.R());
    assertEquals(new Power(new Value(new Quantity(2, empty, empty)), 2),
        equation4.R());
    assertEquals(new Negation(new Value(new Quantity(2, empty, empty))),
        equation5.R());
    assertEquals(new Value(new Quantity(3, empty, empty)),equation6.R());
  }

  /**
   * This method checks if Q method correctly multiples with parentheses 
   */
  @Test
  public void testQ()
  {
    assertEquals(new Product(new Value(new Quantity(2.0,empty,empty)),
        new Value(new Quantity(3.0,empty,empty))), unicalc2.Q());
    assertEquals(new Product(new Value(new Quantity(9,empty,empty)),
        new Value(new Quantity(8,empty,empty))),multiply2.Q());
    assertEquals(new Product(new Value(new Quantity(6, empty, empty)),
        new Sum(new Value(new Quantity(2, empty, empty)),
        new Value(new Quantity(8, empty, empty)))),equation1.Q());
    assertEquals(new Product(new Value(new Quantity(30, empty, empty)),
        new Value(new Quantity(1, Arrays.asList("m"), empty))), equation2.Q());
    assertEquals(new Product(new Value(new Quantity(60, empty, empty)),
        new Value(new Quantity(1, Arrays.asList("Hz"), empty))),equation3.Q());
    assertEquals(new Power(new Value(new Quantity(2, empty, empty)), 2),
        equation4.Q());
    assertEquals(new Negation(new Value(new Quantity(2, empty, empty))),
        equation5.Q());
    assertEquals(new Product(new Value(new Quantity(3, empty, empty)),
        new Value(new Quantity(1, Arrays.asList("iphone"), empty))),
        equation6.Q());
  }

  /**
   * This method checks if K method correctly negates.
   */
  @Test
  public void testK()
  {
    assertEquals(new Negation(new Value(new Quantity(2.0,empty,empty))),
        unicalc3.K());
    assertEquals(new Negation(new Value(new Quantity(8,empty,empty))),
        negative.K());
    assertEquals(new Product(new Value(new Quantity(6, empty, empty)),
        new Sum(new Value(new Quantity(2, empty, empty)),
        new Value(new Quantity(8, empty, empty)))), equation1.K());
    assertEquals(new Product(new Value(new Quantity(30, empty, empty)),
        new Value(new Quantity(1, Arrays.asList("m"), empty))), equation2.K());
    assertEquals(new Product(new Value(new Quantity(60, empty, empty)),
        new Value(new Quantity(1, Arrays.asList("Hz"), empty))),equation3.K());
    assertEquals(new Power(new Value(new Quantity(2, empty, empty)), 2),
        equation4.K());
    assertEquals(new Negation(new Value(new Quantity(2, empty, empty))),
        equation5.K());
    assertEquals(new Product(new Value(new Quantity(3, empty, empty)),
        new Value(new Quantity(1, Arrays.asList("iphone"), empty))),
        equation6.K());
  }

  /**
   * This method checks if P method correctly deals with * and /.
   */
  @Test
  public void testP()
  {
    assertEquals(new Product(new Value(new Quantity(2.0,empty,empty)),
        new Value(new Quantity(3.0,empty,empty))), unicalc4.P());
    assertEquals(new Quotient(new Value(new Quantity(2.0,empty,empty)),
        new Value(new Quantity(3.0,empty,empty))), unicalc5.P());
    assertEquals(new Product(new Value(new Quantity(9,empty,empty)),
        new Value(new Quantity(8,empty,empty))), multiply.P());
    assertEquals(new Quotient(new Value(new Quantity(4,empty,empty)),
        new Value(new Quantity(2,empty,empty))), divide.P());
    assertEquals(new Product(new Value(new Quantity(6, empty, empty)),
        new Sum(new Value(new Quantity(2, empty, empty)),
        new Value(new Quantity(8, empty, empty)))), equation1.P());
    assertEquals(new Product(new Value(new Quantity(30, empty, empty)),
        new Value(new Quantity(1, Arrays.asList("m"), empty))), equation2.P());
    assertEquals(new Product(new Product(new Value(new Quantity(60,empty,empty)),
        new Value(new Quantity(1,Arrays.asList("Hz"),empty))), new Quotient(
        new Product(new Value(new Quantity(30,empty,empty)), new Value(
        new Quantity(1,Arrays.asList("s"),empty))), new Product(new Value(
        new Quantity(60,empty,empty)), new Value(new Quantity(1,
        Arrays.asList("km"),empty))))), equation3.P());
    assertEquals(new Power(new Value(new Quantity(2, empty, empty)), 2),
        equation4.P());
    assertEquals(new Negation(new Value(new Quantity(2, empty, empty))),
        equation5.P());
    assertEquals(new Product(new Product(new Value(new Quantity(3.0,empty,empty)),
        new Value(new Quantity(1,Arrays.asList("iphone"),empty))),
        new Product(new Value(new Quantity(100,empty,empty)), new Value(
        new Quantity(1,Arrays.asList("dollar"),empty)))), equation6.P());
  }

  /**
   * This method checks if E method correctly deals with + and -.
   */
  @Test
  public void testE()
  {
    assertEquals(new Sum(new Value(new Quantity(2.0,empty,empty)),
        new Value(new Quantity(3.0,empty,empty))), unicalc6.E());
    assertEquals(new Difference(new Value(new Quantity(2.0,
        empty,empty)), new Value(new Quantity(3.0,empty,empty))), unicalc7.E());
    assertEquals(new Sum(new Value(new Quantity(1,empty,empty)),
        new Value(new Quantity(1,empty,empty))), add.E());
    assertEquals(new Difference(new Value(new Quantity(2,
        empty,empty)), new Value(new Quantity(0,empty,empty))), minus.E());
    assertEquals(new Difference(new Product(new Value(new Quantity(6,empty,
        empty)), new Sum(new Value(new Quantity(2,empty,empty)),
        new Value(new Quantity(8,empty,empty)))), new Power(new Quotient(
        new Value(new Quantity(30,empty,empty)), new Value(new Quantity(6,
        empty,empty))), 5)), equation1.E());
    assertEquals(new Sum(new Product(new Value(new Quantity(30,empty,empty)),
        new Value(new Quantity(1,Arrays.asList("m"),empty))), new Difference(
        new Product(new Value(new Quantity(20,empty,empty)), new Value(
        new Quantity(1,Arrays.asList("cm"),empty))), new Product(new Value(
        new Quantity(10,empty,empty)), new Value(new Quantity(
        1,Arrays.asList("km"),empty))))), equation2.E());
    assertEquals(new Product(new Product(new Value(new Quantity(60,empty,empty)),
        new Value(new Quantity(1, Arrays.asList("Hz"), empty))), new Quotient(
        new Product(new Value(new Quantity(30,empty,empty)), new Value(
        new Quantity(1,Arrays.asList("s"),empty))),new Product(
        new Value(new Quantity(60,empty,empty)), new Value(new Quantity(1,
        Arrays.asList("km"),empty))))), equation3.E());
    assertEquals(new Difference(new Power(new Value(new Quantity(2,empty,empty)),
        2), new Quotient(new Value(new Quantity(3,empty,empty)),
        new Value(new Quantity(0,empty,empty)))), equation4.E());
    assertEquals(new Sum(new Negation(new Value(new Quantity(2, empty, empty))),
        new Difference(new Negation(new Value(new Quantity(2,empty,empty))),
        new Product(new Negation(new Value(new Quantity(3,empty,empty))),
        new Value(new Quantity(9,empty,empty))))), equation5.E());
    assertEquals(new Difference(new Product(new Product(new Value(new Quantity(
        3,empty,empty)), new Value(new Quantity(1, Arrays.asList("iphone"),
        empty))), new Product(new Value(new Quantity(100,empty,empty)),
        new Value(new Quantity(1,Arrays.asList("dollar"),empty)))), new
        Product(new Value(new Quantity(10,empty,empty)), new Value(new 
        Quantity(1,Arrays.asList("dollar"),empty)))), equation6.E());
  }

  /**
   * This method checks if L method correctly normalizes values.
   */
  @Test
  public void testL()
  {
    assertEquals(new Normalize(new Product(new Value(new Quantity(3.0,empty,
        empty)),new Value(new Quantity(1.0,Arrays.asList("km"),empty)))),
        unicalc8.L());
    assertEquals(new Normalize(new Product(new Product(new Value(new 
        Quantity(60,empty,empty)),new Value(new Quantity(1.0,Arrays.asList("Hz"),
        empty))), new Product(new Value(new Quantity(30,empty,
        empty)),new Value(new Quantity(1.0,Arrays.asList("s"),empty))))),
        norm.L());
    assertEquals(new Difference(new Product(new Value(new Quantity(6,empty,
        empty)), new Sum(new Value(new Quantity(2,empty,empty)),
        new Value(new Quantity(8,empty,empty)))), new Power(new Quotient(
        new Value(new Quantity(30,empty,empty)), new Value(new Quantity(6,
        empty,empty))), 5)), equation1.L());
    assertEquals(new Sum(new Product(new Value(new Quantity(30,empty,empty)),
        new Value(new Quantity(1,Arrays.asList("m"),empty))), new Difference(
        new Product(new Value(new Quantity(20,empty,empty)), new Value(
        new Quantity(1,Arrays.asList("cm"),empty))), new Product(new Value(
        new Quantity(10,empty,empty)), new Value(new Quantity(
        1,Arrays.asList("km"),empty))))), equation2.L());
    assertEquals(new Product(new Product(new Value(new Quantity(60,empty,empty)),
        new Value(new Quantity(1, Arrays.asList("Hz"), empty))), new Quotient(
        new Product(new Value(new Quantity(30,empty,empty)), new Value(
        new Quantity(1,Arrays.asList("s"),empty))),new Product(
        new Value(new Quantity(60,empty,empty)), new Value(new Quantity(1,
        Arrays.asList("km"),empty))))), equation3.L());
    assertEquals(new Difference(new Power(new Value(new Quantity(2,empty,empty)),
        2), new Quotient(new Value(new Quantity(3,empty,empty)),
        new Value(new Quantity(0,empty,empty)))), equation4.L());
    assertEquals(new Sum(new Negation(new Value(new Quantity(2, empty, empty))),
        new Difference(new Negation(new Value(new Quantity(2,empty,empty))),
        new Product(new Negation(new Value(new Quantity(3,empty,empty))),
        new Value(new Quantity(9,empty,empty))))), equation5.L());
    assertEquals(new Difference(new Product(new Product(new Value(new Quantity(
        3,empty,empty)), new Value(new Quantity(1, Arrays.asList("iphone"),
        empty))), new Product(new Value(new Quantity(100,empty,empty)),
        new Value(new Quantity(1,Arrays.asList("dollar"),empty)))), new
        Product(new Value(new Quantity(10,empty,empty)), new Value(new 
        Quantity(1,Arrays.asList("dollar"),empty)))), equation6.L());
    assertEquals(new Normalize(new Product(new Value(new Quantity(10,empty,
        empty)),new Value(new Quantity(1,Arrays.asList("phone"),empty)))),
        equation7.L());
  }

  /**
   * This method checks if S method correctly defines 1st unit as 2nd unit.
   */
  @Test
  public void testS()
  {
    assertEquals(new Define("km",new Product(new Value(new Quantity(3.0,empty,
        empty)),new Value(new Quantity(1.0,Arrays.asList("m"),empty)))),
        unicalc9.S());
    assertEquals(new Define("iphone",new Product(new Value(new Quantity(600,
        empty,empty)), new Value(new Quantity(1,Arrays.asList("dollar"),
        empty)))), define.S());
        assertEquals(new Difference(new Product(new Value(new Quantity(6,empty,
        empty)), new Sum(new Value(new Quantity(2,empty,empty)),
        new Value(new Quantity(8,empty,empty)))), new Power(new Quotient(
        new Value(new Quantity(30,empty,empty)), new Value(new Quantity(6,
        empty,empty))), 5)), equation1.S());
    assertEquals(new Sum(new Product(new Value(new Quantity(30,empty,empty)),
        new Value(new Quantity(1,Arrays.asList("m"),empty))), new Difference(
        new Product(new Value(new Quantity(20,empty,empty)), new Value(
        new Quantity(1,Arrays.asList("cm"),empty))), new Product(new Value(
        new Quantity(10,empty,empty)), new Value(new Quantity(
        1,Arrays.asList("km"),empty))))), equation2.S());
    assertEquals(new Product(new Product(new Value(new Quantity(60,empty,empty)),
        new Value(new Quantity(1, Arrays.asList("Hz"), empty))), new Quotient(
        new Product(new Value(new Quantity(30,empty,empty)), new Value(
        new Quantity(1,Arrays.asList("s"),empty))),new Product(
        new Value(new Quantity(60,empty,empty)), new Value(new Quantity(1,
        Arrays.asList("km"),empty))))), equation3.S());
    assertEquals(new Difference(new Power(new Value(new Quantity(2,empty,empty)),
        2), new Quotient(new Value(new Quantity(3,empty,empty)),
        new Value(new Quantity(0,empty,empty)))), equation4.S());
    assertEquals(new Sum(new Negation(new Value(new Quantity(2, empty, empty))),
        new Difference(new Negation(new Value(new Quantity(2,empty,empty))),
        new Product(new Negation(new Value(new Quantity(3,empty,empty))),
        new Value(new Quantity(9,empty,empty))))), equation5.S());
    assertEquals(new Difference(new Product(new Product(new Value(new Quantity(
        3,empty,empty)), new Value(new Quantity(1, Arrays.asList("iphone"),
        empty))), new Product(new Value(new Quantity(100,empty,empty)),
        new Value(new Quantity(1,Arrays.asList("dollar"),empty)))), new
        Product(new Value(new Quantity(10,empty,empty)), new Value(new 
        Quantity(1,Arrays.asList("dollar"),empty)))), equation6.S());
    assertEquals(new Normalize(new Product(new Value(new Quantity(10,empty,
        empty)),new Value(new Quantity(1,Arrays.asList("phone"),empty)))),
        equation7.S());
  }
}
