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
  private List<String> empty;
  private LinkedList<String> toks1;
  private LinkedList<String> toks2;
  private LinkedList<String> toks3;
  private Quantity  quantity1;
  private Quantity  quantity2;
  private Quantity  quantity3;
  private Quantity  quantity4;

  /**
   * Setup the tests and initialize class variables.
   */
  @Before
  public void setUp()
  {
    unicalc1 = new Unicalc();
    unicalc1.tokenize("2^3");
    unicalc2 = new Unicalc();
    unicalc2.tokenize("2(3)");
    toks1 = new LinkedList<String>( Tokenizer.tokenize("meter"));
    toks2 = new LinkedList<String>( Tokenizer.tokenize("hour"));
    toks3 = new LinkedList<String>( Tokenizer.tokenize("day"));
    quantity1 = new Quantity(10.0,Arrays.asList("meter"),Arrays.asList("second"));
    quantity2 = new Quantity(20.0,Arrays.asList("km"),Arrays.asList("hour"));
    quantity3 = new Quantity(30.0,Arrays.asList("smoot"),Arrays.asList("second"));
    quantity4 = new Quantity(2.0);
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
