/* CSE12 Homework 8
 * Brianna Torres Yamanaka: A10690742, cs12spq
 * Jessica Yang: A98071336, cs12sim
 * Jessica Sec A00
 * Brianna: Sec A01
 * 5.23.15
 */

package hw8solutions;

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
  private Unicalc unicalc1;
  private Unicalc unicalc2;
  private Unicalc unicalc3;
  private Unicalc unicalc4;
  private Unicalc unicalc5;
  private Unicalc unicalc6;
  private Unicalc unicalc7;
  private Unicalc unicalc8;
  private Unicalc unicalc9;

  private List<String> empty;
  private LinkedList<String> toks1;
  private LinkedList<String> toks2;
  private LinkedList<String> toks3;
  private Quantity quantity1;
  private Quantity quantity2;
  private Quantity quantity3;
  private Quantity quantity4;
  private Map<String,Quantity> database;

  /**
   * Setup the tests and initialize class variables.
   */
  @Before
    public void setUp()
    {
      empty = new ArrayList<String>();
      database = new HashMap<String,Quantity>();
      database.put("km", new Quantity(1000, Arrays.asList("meter"), empty));
      empty = Collections.<String>emptyList();
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

      quantity1 = new Quantity(10.0,Arrays.asList("meter"),
          Arrays.asList("second"));
      quantity2 = new Quantity(20.0,Arrays.asList("km"),Arrays.asList("hour"));
      quantity3 = new Quantity(30.0,Arrays.asList("smoot"),
          Arrays.asList("second"));
      quantity4 = new Quantity(2.0,empty,empty);
    }

  /** This method checks if R method correctly deals with exponents */
  @Test
    public void testR()
    {
      //pass in string "2^3" or or "wm + 3m" ...
      assertEquals((unicalc1.R()),(new Power(new Value(new Quantity(2.0,empty,
                  empty)),3)));
    }

  /** This method checks if Q method correctly multiples with parentheses */
  @Test
    public void testQ()
    {
      assertEquals((unicalc2.Q()),(new Product((new Value(new Quantity(2.0,
                    empty,empty))), (new Value(new Quantity(3.0,empty,empty))))));
    }

  /** This method checks if K method correctly negates */
  @Test
    public void testK()
    {
      assertEquals((unicalc3.K()),(new Negation(new Value(new Quantity(2.0,
                  empty,empty)))));
    }

  /** This method checks if P method correctly deals with * and / */
  @Test
    public void testP()
    {
      assertEquals((unicalc4.P()),(new Product((new Value(new Quantity(2.0,
                    empty,empty))), (new Value(new Quantity(3.0,empty,empty))))));
      assertEquals((unicalc5.P()),(new Quotient((new Value(new Quantity(2.0,
                    empty,empty))), (new Value(new Quantity(3.0,empty,empty))))));
    }

  /** This method checks if E method correctly deals with + and - */
  @Test
    public void testE()
    {
      assertEquals((unicalc6.E()),(new Sum((new Value(new Quantity(2.0,
                    empty,empty))), (new Value(new Quantity(3.0,empty,empty))))));
      assertEquals((unicalc7.E()),(new Difference((new Value(new Quantity(2.0,
                    empty,empty))), (new Value(new Quantity(3.0,empty,empty))))));
    }

  /** This method checks if L method correctly normalizes values */
  @Test
    public void testL()
    {
      assertEquals((unicalc8.L()),(new Normalize(new Product(new Value(new 
                  Quantity(3.0,empty,empty)),new Value(new Quantity(1.0,
                    Arrays.asList("km"),empty))))));
    }

  /** This method checks if S method correctly defines 1st unit as 2nd unit*/
  @Test
    public void testS()
    {
      assertEquals((unicalc9.S()),(new Define("km",new Product(new Value(new
                  Quantity(3.0,empty,empty)),new Value(new Quantity(1.0,
                    Arrays.asList("m"),empty))))));
    }
}
