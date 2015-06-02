/* CSE12 Homework 8
 * Brianna Torres Yamanaka: A10690742, cs12spq
 * Jessica Yang: A98071336, cs12sim
 * Jessica Sec A00
 * Brianna: Sec A01
 * 5.23.15
 */

// An AST is an abstract-syntax-tree
// Unicalc.java
// Original Author: Chris Stone, Harvey Mudd College

// Extended by:

package hw8solutions;

import java.util.*;
import java.util.regex.*;

class Unicalc
{
  //Used by the parser functions
  private LinkedList<String> toks;

  /**
   * Constructs a unicalc object that can be tokenized.
   * Nothing we need to do in the constructor.
   */
  public Unicalc()
  {

  }

  /**Method tokenize takes a string and sets this.toks
   * to be a linked list of all Unicalc tokens in this
   * string (ignoring whitespace, and other things that
   * can't be part of a token. 
   * @param String the input given by the user
   */
  public void tokenize(String input)
  {
    //create new linked list containing user input
    toks = new LinkedList<String>(Tokenizer.tokenize(input));

    //print out linked list
    System.out.println("Tokens: " + toks);

    //exit
    return;
  }

  /**Method parse tries to parse the contents of toks using
   * recursive descent, starting with the start symbol.
   * @return AST, an abstract syntax tree representing user input
   */
  public AST parse()
  {
    //Begin parsing with the start symbol
    AST answer = this.S();

    //Display results
    System.out.println("AST: " + answer);

    //if there are tokens still, print them out
    if (!toks.isEmpty()) {
      System.out.println("Extra tokens left over: " + toks);
    }
    //print new line and return AST
    System.out.println();
    return answer;
  }

  /* REMEMBER
   * I -> (any nonnegative integer)
   * D -> (any nonnegative number, integer, or floating-point)
   * W -> (any word that is a unit name)
   */

  /**Method S checks to see if we're defining and creates
   * a new Define object if we are.
   * @return AST, an abstract syntax tree representing a Define object
   * S -> def W L | L
   * do this method seventh
   */
  public AST S()
  {
    //create a string called defString
    String defString = "def";

    //if next token is the same as defString
    if(defString.equals(toks.peek()))
    {
      //remove "def" so we can check if next token is a unit
      toks.pop();

      //if the token after that is a letter (ie a unit)
      if(isAlphabetic((String)toks.peek()))
      {

        //create a string to hold next token/unit
        String string = (String)toks.peek();

        //remove the token/unit
        toks.pop();

        //return a new Define object with our string
        return new Define(string,L());
      }
      //if the token after def isn't a letter throw error
      else
      {
        throw new ParseError("S(). Next token isn't a unit name");
      }
    }
    //if our first token isn't "def" return an L()
    else
    {
      return L();
    }
  }

  /** Method L() checks to see if we're normalizing and creates
   * a new normalized object if we are.
   * @return AST, an abstract syntax tree representing a
   * normalized value or E().
   * L -> # E | E
   * do this one sixth
   */
  public AST L()
  {
    //create a new string for pound sign
    String normalizeString = "#";

    //if next token matches our normalizeString 
    if(normalizeString.equals(toks.peek()))
    {
      // Get rid of the #-sign token
      toks.pop();

      //return a new normalized object
      return new Normalize(E());
    }
    //if next token is something else return E()
    else
    {
      return E();
    }
  }

  /** Method E() checks to see if we're adding or subtracting  and creates
   * a new sum or difference if we are.
   * @return AST, an abstract syntax tree representing a
   * sum, a difference or a P()
   * E -> P + E | P - E | P
   * do this one fifth
   */
  public AST E()
  {
    //create a new AST P() 
    AST p = P();

    //create a new sumString
    String sumString = "+";

    //create a new diffString
    String diffString = "-";

    //if next token matches our sumString
    if(sumString.equals(toks.peek()))
    {
      //get rid of the "+" sign
      toks.pop();

      return new Sum(p,E());
    }

    //if next token is a minus sign return a difference
    else if (diffString.equals(toks.peek()))
    {
      //get rid of the "-" sign
      toks.pop();

      return new Difference(p,E());
    }
    //if next token is neither of the above return a p
    else
    {
      return p;
    }
  }

  /** Method P() checks to see if we're multiplying or dividing  and creates
   * a new product or quotient if we are.
   * @return AST, an abstract syntax tree representing a
   * product, a quotient or a K()
   * P -> K * P | K / P | K
   * do this one fourth
   */
  public AST P()
  {
    //create a new AST K()
    AST k = K();

    //create a new asteriskString
    String asteriskString = "*";

    //create a new divideString
    String divideString = "/";

    //if token matches asteriskString, return a product
    if(asteriskString.equals(toks.peek()))
    {
      //get rid of "*"
      toks.pop();

      //return a new product
      return new Product(k,P());
    }
    //if token matches divideString, return a quotient
    else if(divideString.equals(toks.peek()))
    {
      //get rid of "/"
      toks.pop();

      //return a new quotient
      return new Quotient(k,P());
    }
    //if token doesnt match asterisk or divideString
    else
    {
      //return AST K()
      return k;
    }
  }

  /**Method K() checks to see if we're negating and returns
   * a new negation if we are.
   * @return AST, a new abstract tree node representing a
   * Negation or Q()
   * K -> - K | Q
   * do this one third
   */
  public AST K()
  {
    //create a new string negateString
    String negateString = "-";

    //if i peek and the token matches negateString
    if(negateString.equals(toks.peek()))
    {
      //get rid of "-"
      toks.pop();

      //return a new negation
      return new Negation(K());
    }
    else
    {
      //other wise return Q, no negation
      return Q();
    }
  }

  /**Method Q() checks to see if we're multiplying without
   * an asterisk and returns a new product if we are.
   * @return AST, a new abstract tree node representing a
   * product or an R()
   * Q -> R | R Q
   * do this one second
   * remember: Product(AST absSyntaxTree, int exponent);
   */
  public AST Q()
  {
    //create a new AST R()
    AST r = R();

    //create a string to hold next token
    String string = (String)toks.peek();

    //create a string leftParanString
    String leftParanString = "(";

    //all cases of multiplying
    if((isNumber(string) == true) ||
        (isAlphabetic(string) == true) ||
        (leftParanString.equals(string)))
    {
      //then recursively return a product of r and Q
      return new Product(r,Q());
    }
    //if we're not multiplying, return r
    else
    {
      return r;
    }
  }

  /**method R() checks to see if we're raisng to an exponent and
   * returns an exponent if we are.
   * @return AST, a new abstract tree representing a power function
   * R -> V | V ^ J
   * do this one first
   * remember Power(AST absSyntaxTree, int exponent);
   */
  public AST R()
  {
    //create a new AST V()
    AST v = V();

    //create a string to represent a carrot
    String powerString = "^";
    //if i peek and v is followed by a "to the power of" symbol
    if(powerString.equals(toks.peek()))
    {

      //get rid of "^"
      toks.pop();

      //return a new Power with our AST v and the exponent J
      return new Power(v,J());
    }
    //if i peek and v is followed by something other than "^"
    else
    {
      //return proper AST depending on whether its a number or letter
      return v;
    }
  }

  //  --------------------------------------------------
  //   The following functions should need no changes.


  // Function for grabbing tokens corresponding to V in the grammar,
  //    and returning a corresponding abstract syntax tree.
  // Should work without changes, but you should make sure
  //    you understand how it works.
  public AST V()
  {
    // V -> D | W | ( L )

    List<String> emp = Collections.<String>emptyList();  // an empty list

    String next = toks.peek();

    if (isNumber(next)) {
      // D
      double d1 = D();
      return new Value(new Quantity(d1, emp, emp));

    } else if ( isAlphabetic(next) ) {
      // W
      String unitName = toks.pop();
      return new Value(new Quantity(1.0, Arrays.asList(unitName), emp));

    } else if ( "(".equals(next) ) {
      // ( L )

      toks.pop();  // Skip the left parenthesis
      AST l = L(); // Recursively grab the contents, which should match L.

      String after_l = toks.peek();

      // Immediately following that L should be a right parenthesis. Check
      if ( ")".equals(after_l) ) {
        // It's there, so get rid of it (since we want to remove all
        //    the tokens corresponding to V)
        toks.pop();
        return l;     // A parenthesized L has the same tree as a non-parenthesized L
        //   (Since the tree structure *already* tells us the way that
        //    our subexpressions are grouped, keeping around these
        //    parentheses in the AST is unnecessary; they wouldn't affect
        //    the final answer.)
      } else {
        throw new ParseError("Expected close-parenthesis, but found: '" +
            after_l + "'");
      }

    } else {
      // The first token can't possibly be part of a V.
      throw new ParseError("Expected number or identifier or subexpression, but found: '"
          + next + "'");
    }
  }

  // Parsing function for J in the grammar.
  // Note: unlike most of the parsing functions,
  // we're returning the corresponding int rather than an AST.
  public int J()
  {
    // J -> -I | I
    String next = toks.peek();

    if ("-".equals(next))
    {
      // Get rid of the minus-sign token
      toks.pop();
      // Following it should be something matching I
      int i = I();
      // Combine the minus sign and i
      return (- i);
    }
    else
    {
      // No minus sign, so look for something matching I
      return I();
    }
  }

  // Parsing function for I in the grammar.
  // Note: unlike most of the parsing functions,
  // we're returning the corresponding int rather than an AST.
  public int I()
  {
    // I -> (any nonnegative integer)
    String next = toks.peek();
    if (next == null) {
      throw new ParseError("Expected an integer, but found null");
    }
    try {
      toks.pop();
      return Integer.parseInt(next);
    } catch (NumberFormatException e) {
      throw new ParseError("Expected an integer, but found: '" + next + "'");
    }
  }

  // Parsing function for D in the grammar.
  // Note: unlike most of the parsing functions,
  // we're returning the corresponding double-precision
  // floating-point number, rather than an AST.
  public double D() {
    // D -> (any nonnegative number, integer or floating-point)
    String next = toks.peek();
    try
    {
      toks.pop();
      return Double.parseDouble(next);
    } catch (NumberFormatException e)
    {
      throw new ParseError("Expected a number, but found: '" + next + "'");
    }
  }
  /** method isNumber(string)
   * @param String string
   * @return either true or false if its a number
   */
  public static boolean isNumber(String s)
  {
    if (s == null) return false;

    try
    {
      Double.parseDouble(s);
      return true;
    }
    catch (NumberFormatException e)
    {
      return false;
    }
  }

  /** method isAlphabetic(string)
   * other wise return Q, no negation
   * @param String string
   * @return either true or false if string is a letter
   */
  public static boolean isAlphabetic(String s)
  {
    return s != null && s.matches("[a-zA-Z_]+");
  }

  //////////////////////////////////////////////////////////////////////////////

  /** method main
   * inputs: the usual
   * outputs: none, but this method has the Unicalc read-eval-print loop
   */
  public static void main(String[] args)
  {
    Scanner console = new Scanner(System.in);
    Unicalc unicalc = new Unicalc();

    Map<String,Quantity> env = QuantityDB.getDB();

    while (true)
    {
      System.out.print("input>  ");
      String input = console.nextLine();

      if (input.equals("")) break;  // Quit if no input

      unicalc.tokenize(input);

      AST ast = null;
      try {
        ast = unicalc.parse();
        System.out.println("Result: " + ast.eval(env) + "\n");

      } catch (ParseError e) {
        System.out.println( e );
      }
    }
  }
}

// ParseError class
//    A new kind of exception to be thrown if there is
//    an error in parsing
class ParseError extends RuntimeException {
  public ParseError(String message) {
    // Create a ParseError object containing
    // the given message as its error message.
    super(message);
  }
}

