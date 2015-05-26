//XXX change package
package hw8solutions;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Junit test class for AST class.
 */
public class ASTTester {

  //class variables
  Unicalc calculator0;
  Unicalc calculator1;
  Unicalc calculator2;
  Quantity quant0;
  Quantity quant1;
  AST tree0;
  AST tree1;
  AST tree2;

  //class variables that are going to be tested
  Product mul0;
  Product mul1;
  Quotient div0;
  Quotient div1;
  Sum add0;
  Sum add1;
  Difference sub0;
  Difference sub1;
  Power pow0;
  Power pow1;
  Negation neg0;
  Negation neg1;
  Normalize norm0;
  Normalize norm1;
  Define def0;
  Define def1;
  Value val0;
  Value val1;

  /**
   * Set up tests and initialize class variables.
   */
  @Before
  public void setUp() {
    //initialize instance variables
    calculator0 = new Unicalc();
    calculator1 = new Unicalc();
    calculator2 = new Unicalc();
    calculator0.tokenize("(2 + 3) * 5 + 4");
    calculator1.tokenize("6 * 2 + 7");
    calculator2.tokenize("9 / 3 - 1");
    tree0 = calculator0.parse();
    tree1 = calculator1.parse();
    tree2 = calculator2.parse();
    quant0 = new Quantity();
    quant1 = new Quantity(24, Arrays.asList("hour"),
        Collections.<String>emptyList());

    //set up each instance for each testing class
    mul0 = new Product(tree0, tree2);
    mul1 = new Product(tree1, tree2);
    div0 = new Quotient(tree0, tree1);
    div1 = new Quotient(tree1, tree1);
    add0 = new Sum(tree2, tree2);
    add1 = new Sum(tree1, tree2);
    sub0 = new Difference(tree0, tree2);
    sub1 = new Difference(tree0, tree1);
    pow0 = new Power(tree1, 3);
    pow1 = new Power(tree0, -2);
    neg0 = new Negation(tree1);
    neg1 = new Negation(tree2);
    norm0 = new Normalize(tree0);
    norm1 = new Normalize(tree2);
    def0 = new Define("km", tree2);
    def1 = new Define("year", tree2);
    val0 = new Value(quant0);
    val1 = new Value(quant1);
  }

  /**
   * Tester for product class.
   */
  @Test
  public void testProduct() {
  }

  /**
   * Tester for quotient class.
   */
  @Test
  public void testQuotient() {
  }

  /**
   * Tester for sum class.
   */
  @Test
  public void testSum() {
  }

  /**
   * Tester for difference class.
   */
  @Test
  public void testDifference() {
  }

  /**
   * Tester for power class.
   */
  @Test
  public void testPower() {
  }

  /**
   * Tester for negation class.
   */
  @Test
  public void testNegation() {
  }

  /**
   * Tester for normalize class.
   */
  @Test
  public void testNormalize() {
  }

  /**
   * Tester for define class.
   */
  @Test
  public void testDefine() {
  }

  /**
   * Tester for value class/
   */
  @Test
  public void testValue() {
  }
}
