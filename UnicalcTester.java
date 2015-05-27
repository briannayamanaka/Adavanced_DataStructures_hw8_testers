/* CSE12 Homework 8
 * Brianna Torres Yamanaka: A10690742, cs12spq
 * Jessica Yang: A98071336, cs12sim
 * Jessica Sec A00
 * Brianna: Sec A01
 * 5.23.15
 */

//XXX change package
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

  private List<String> empty;
  private Quantity two;
  private Quantity three;
  private Quantity fiveMeter;
  private Quantity twoMeter;
  private Quantity sixSecond;
  private Quantity threeSecond;
  private Quantity fourPound;
  private Quantity zeroFeet;
  private Quantity oneYear;

  /**
   * Setup the tests and initialize class variables.
   */
  @Before
  public void setUp()
  {
    //create empty list
    empty = Collections.<String>emptyList();

    //create new unicalc objects and its tokens
    unicalc1 = new Unicalc();
    unicalc1.tokenize("2 ^ 3");
    unicalc2 = new Unicalc();
    unicalc2.tokenize("2(3)");
    unicalc3 = new Unicalc();
    unicalc3.tokenize("5 meter + 2 meter");
    unicalc4 = new Unicalc();
    unicalc4.tokenize("(6 second - 3 second) * 4 pound");
    unicalc5 = new Unicalc();
    unicalc5.tokenize("0 feet / 1 year");

    two = new Quantity(2, empty, empty);
    three = new Quantity(3, empty, empty);
    fiveMeter = new Quantity(5, Arrays.asList("meter"), empty);
    twoMeter = new Quantity(2, Arrays.asList("meter"), empty);
    sixSecond = new Quantity(6, Arrays.asList("second"), empty);
    threeSecond = new Quantity(3, Arrays.asList("second"), empty);
    fourPound = new Quantity(4, Arrays.asList("pound"), empty);
    zeroFeet = new Quantity(0, Arrays.asList("feet"), empty);
    oneYear = new Quantity(1, Arrays.asList("year"), empty);
  }

  /**
   *
   */
  @Test
  public void testR()
  {
    //pass in string "2^3" or or "wm + 3m" ...
    //assertEquals((unicalc1.R()),(new Power(new Value(new Quantity(2.0)),3)));
    assertEquals((unicalc1.R()),(new Power(new Value(quantity(2.0),3))));
  }
  
  /**
   *
   */
  @Test
  public void testQ()
  {
    //assertEquals( ( unicalc2.Q() ), ( new Product( (new Power), (new Value) ) ) );
  }
  
  /**
   *
   */
  @Test
  public void testK()
  {

  }
  
  /**
   *
   */
  @Test
  public void testP()
  {

  }
  
  /**
   *
   */
  @Test
  public void testE()
  {

  }
  
  /**
   *
   */
  @Test
  public void testL()
  {

  }
  
  /**
   *
   */
  @Test
  public void testS()
  {

  }
}
