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
 * Junit test class for AST class.
 */
public class ASTTester {

  //class variables
  List<String> emptyList;
  Map<String,Quantity> db;
  QuantityDB database;
  Quantity num0;
  Quantity num1;
  Quantity num2;
  Quantity num3;
  Quantity num4;

  //class variables that are going to be tested
  Value val0;
  Value val1;
  Value val2;
  Value val3;
  Value val4;

  /**
   * Set up tests and initialize class variables.
   */
  @Before
  public void setUp() {
    //empty list
    emptyList = Collections.<String>emptyList();

    //initialize class variables
    num0 = new Quantity();
    num1 = new Quantity(5, Arrays.asList("meter"), emptyList);
    num2 = new Quantity(10, Arrays.asList("year"), emptyList);
    num3 = new Quantity(-5, Arrays.asList("meter"), emptyList);
    num4 = new Quantity(-10, Arrays.asList("miles"), Arrays.asList("second"));

    //get the evaluation database
    database = new QuantityDB();
    db = database.getDB();

    //create new AST objects
    val0 = new Value(num0);
    val1 = new Value(num1);
    val2 = new Value(num2);
    val3 = new Value(num3);
    val4 = new Value(num4);
  }

  /**
   * Tester for product class.
   */
  @Test
  public void testProduct() {
    //create new objects of product
    Product mul0 = new Product(val2, val4);
    Product mul1 = new Product(val0, val1);
    Product mul2 = new Product(val3, val3);

    //evaluate the product
    assertEquals(new Quantity(-100, Arrays.asList("year", "miles"),
          Arrays.asList("second")), mul0.eval(db));
    assertEquals(new Quantity(5, Arrays.asList("meter"), emptyList),
          mul1.eval(db));
    assertEquals(new Quantity(25, Arrays.asList("meter", "meter"), emptyList),
          mul2.eval(db));

    //test the toString method
    assertEquals("Product(Value(10.0 year),Value(-10.0 miles second^-1))",
          mul0.toString());
    assertEquals("Product(Value(1.0),Value(5.0 meter))", mul1.toString());
    assertEquals("Product(Value(-5.0 meter),Value(-5.0 meter))", mul2.toString());

    //test the equals method
    assertFalse(mul1.equals(mul2));
    assertFalse(mul0.equals(mul1));
    assertTrue(mul0.equals(mul0));
    assertTrue(mul2.equals(mul2));
  }

  /**
   * Tester for quotient class.
   */
  @Test
  public void testQuotient() {
    //create new objects of Quotient
    Quotient div0 = new Quotient(val2, val3);
    Quotient div1 = new Quotient(val0, val1);
    Quotient div2 = new Quotient(val2, val2);

    //evaluate the Quotient
    assertEquals(new Quantity(-2, Arrays.asList("year"), Arrays.asList("meter")),
          div0.eval(db));
    assertEquals(new Quantity(0.2, emptyList, Arrays.asList("meter")), div1.eval(db));
    assertEquals(new Quantity(1, emptyList, emptyList), div2.eval(db));

    //test the toString method
    assertEquals("Quotient(Value(10.0 year),Value(-5.0 meter))", div0.toString());
    assertEquals("Quotient(Value(1.0),Value(5.0 meter))", div1.toString());
    assertEquals("Quotient(Value(10.0 year),Value(10.0 year))", div2.toString());

    //test the equals method
    assertFalse(div2.equals(div1));
    assertFalse(div0.equals(val0));
    assertTrue(div0.equals(div0));
    assertTrue(div2.equals(div2));
  }

  /**
   * Tester for sum class.
   */
  @Test
  public void testSum() {
    //create new objects of Sum
    Sum add0 = new Sum(val0, val0);
    Sum add1 = new Sum(val1, val3);
    Sum add2 = new Sum(val2, val2);

    //evaluate the Sum
    assertEquals(new Quantity(2, emptyList, emptyList), add0.eval(db));
    assertEquals(new Quantity(0, Arrays.asList("meter"), emptyList), add1.eval(db));
    assertEquals(new Quantity(20, Arrays.asList("year"), emptyList), add2.eval(db));

    //test the toString method
    assertEquals("Sum(Value(1.0),Value(1.0))", add0.toString());
    assertEquals("Sum(Value(5.0 meter),Value(-5.0 meter))", add1.toString());
    assertEquals("Sum(Value(10.0 year),Value(10.0 year))", add2.toString());

    //test the equals method
    assertFalse(add0.equals(val2));
    assertFalse(add0.equals(add2));
    assertTrue(add0.equals(add0));
    assertTrue(add1.equals(add1));
  }

  /**
   * Tester for difference class.
   */
  @Test
  public void testDifference() {
    //create new objects of Difference
    Difference sub0 = new Difference(val1, val3);
    Difference sub1 = new Difference(val3, val1);
    Difference sub2 = new Difference(val4, val4);

    //evaluate the difference
    assertEquals(new Quantity(10, Arrays.asList("meter"), emptyList), sub0.eval(db));
    assertEquals(new Quantity(-10, Arrays.asList("meter"), emptyList), sub1.eval(db));
    assertEquals(new Quantity(0, Arrays.asList("miles"), Arrays.asList("second")),
          sub2.eval(db));

    //test the toString method
    assertEquals("Difference(Value(5.0 meter),Value(-5.0 meter))", sub0.toString());
    assertEquals("Difference(Value(-5.0 meter),Value(5.0 meter))", sub1.toString());
    assertEquals("Difference(Value(-10.0 miles second^-1),Value(-10.0 miles second^-1))",
          sub2.toString());

    //test the equals method
    assertFalse(sub1.equals(val1));
    assertFalse(sub2.equals(sub0));
    assertTrue(sub2.equals(sub2));
    assertTrue(sub0.equals(sub0));
  }

  /**
   * Tester for power class.
   */
  @Test
  public void testPower() {
    //create new objects of Power
    Power pow0 = new Power(val0, 5);
    Power pow1 = new Power(val3, -2);
    Power pow2 = new Power(val4, 0);

    //evaluate the power
    assertEquals(new Quantity(1, emptyList, emptyList), pow0.eval(db));
    assertEquals(new Quantity(0.04, emptyList, Arrays.asList("meter", "meter")),
          pow1.eval(db));
    assertEquals(new Quantity(1, emptyList, emptyList), pow2.eval(db));

    //test the toString method
    assertEquals("Power(Value(1.0),5)", pow0.toString());
    assertEquals("Power(Value(-5.0 meter),-2)", pow1.toString());
    assertEquals("Power(Value(-10.0 miles second^-1),0)", pow2.toString());

    //test the equals method
    assertFalse(pow2.equals(pow1));
    assertFalse(pow0.equals(val2));
    assertTrue(pow1.equals(pow1));
    assertTrue(pow2.equals(pow2));
  }

  /**
   * Tester for negation class.
   */
  @Test
  public void testNegation() {
    //create new objects of Negation
    Negation neg0 = new Negation(val0);
    Negation neg1 = new Negation(val2);
    Negation neg2 = new Negation(val3);

    //evaluate the negation
    assertEquals(new Quantity(-1, emptyList, emptyList), neg0.eval(db));
    assertEquals(new Quantity(-10, Arrays.asList("year"), emptyList), neg1.eval(db));
    assertEquals(new Quantity(5, Arrays.asList("meter"), emptyList), neg2.eval(db));

    //test the toString method
    assertEquals("Negation(Value(1.0))", neg0.toString());
    assertEquals("Negation(Value(10.0 year))", neg1.toString());
    assertEquals("Negation(Value(-5.0 meter))", neg2.toString());

    //test the equals method
    assertFalse(neg0.equals(neg2));
    assertFalse(neg2.equals(neg1));
    assertTrue(neg0.equals(neg0));
    assertTrue(neg1.equals(neg1));
  }

  /**
   * Tester for normalize class.
   */
  @Test
  public void testNormalize() {
    //create new objects of Normalize
    Normalize norm0 = new Normalize(val0);
    Normalize norm1 = new Normalize(val1);
    Normalize norm2 = new Normalize(val2);
    Normalize norm3 = new Normalize(val3);
    Normalize norm4 = new Normalize(val4);

    //evaluate the Normalize
    assertEquals(new Quantity(1, emptyList, emptyList), norm0.eval(db));
    assertEquals(new Quantity(5, Arrays.asList("meter"), emptyList), norm1.eval(db));
    assertEquals(new Quantity(315576000, Arrays.asList("second"), emptyList),
          norm2.eval(db));
    assertEquals(new Quantity(-5, Arrays.asList("meter"), emptyList), norm3.eval(db));
    assertEquals(new Quantity(-10.0, Arrays.asList("miles"), Arrays.asList("second")),
          norm4.eval(db));

    //test the toString method
    assertEquals("Normalize(Value(1.0))", norm0.toString());
    assertEquals("Normalize(Value(5.0 meter))", norm1.toString());
    assertEquals("Normalize(Value(10.0 year))", norm2.toString());
    assertEquals("Normalize(Value(-5.0 meter))", norm3.toString());
    assertEquals("Normalize(Value(-10.0 miles second^-1))", norm4.toString());

    //test the equals method
    assertFalse(norm1.equals(val1));
    assertFalse(norm2.equals(norm0));
    assertFalse(norm3.equals(norm2));
    assertFalse(norm4.equals(norm1));
    assertFalse(norm0.equals(db));
    assertTrue(norm1.equals(norm1));
    assertTrue(norm3.equals(norm3));
  }

  /**
   * Tester for define class.
   */
  @Test
  public void testDefine() {
    //create new objects of Define
    Define def0 = new Define("empty", val0);
    Define def1 = new Define("10 year", val2);
    Define def2 = new Define("-5 meter", val3);
    Define def3 = new Define("-10 miles/second", val4);

    //evaluate the Define
    assertEquals(new Quantity(1, emptyList, emptyList), def0.eval(db));
    assertEquals(new Quantity(10, Arrays.asList("year"), emptyList), def1.eval(db));
    assertEquals(new Quantity(-5, Arrays.asList("meter"), emptyList), def2.eval(db));
    assertEquals(new Quantity(-10, Arrays.asList("miles"), Arrays.asList("second")),
          def3.eval(db));

    //test the toString method
    assertEquals("Define(empty,Value(1.0))", def0.toString());
    assertEquals("Define(10 year,Value(10.0 year))", def1.toString());
    assertEquals("Define(-5 meter,Value(-5.0 meter))", def2.toString());
    assertEquals("Define(-10 miles/second,Value(-10.0 miles second^-1))", def3.toString());

    //test the equals method
    assertFalse(def0.equals(def1));
    assertFalse(def3.equals(def2));
    assertFalse(def1.equals(def3));
    assertTrue(def1.equals(def1));
    assertTrue(def3.equals(def3));
  }

  /**
   * Tester for value class/
   */
  @Test
  public void testValue() {
    //test method eval
    assertEquals(num0, val0.eval(db));
    assertEquals(num1, val1.eval(db));
    assertEquals(num2, val2.eval(db));
    assertEquals(num3, val3.eval(db));
    assertEquals(num4, val4.eval(db));

    //test to string method
    assertEquals("Value(1.0)",val0.toString());
    assertEquals("Value(5.0 meter)",val1.toString());
    assertEquals("Value(10.0 year)",val2.toString());
    assertEquals("Value(-5.0 meter)",val3.toString());
    assertEquals("Value(-10.0 miles second^-1)",val4.toString());

    //test equals method
    assertFalse(val0.equals(val1));
    assertFalse(val3.equals(val4));
    assertFalse(val2.equals(val3));
    assertTrue(val1.equals(val1));
    assertTrue(val4.equals(val4));
  }
}
