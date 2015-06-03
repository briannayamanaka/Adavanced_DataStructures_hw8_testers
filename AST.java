/* CSE12 Homework 8
 * Brianna Torres Yamanaka: A10690742, cs12spq
 * Jessica Yang: A98071336, cs12sim
 * Jessica Sec A00
 * Brianna: Sec A01
 * 5.23.15
 */

package hw8;

import java.util.*;

/**
 * The interface for an Abstract Syntax Tree for the Unicalc
 * language.
 */
interface AST
{
  /**
   * The string representation of this AST.
   * @return The string representation of this AST.
   */
  public String toString();

  /**
   * The evaluation of this AST. It should recursively evaluate
   * the subtrees and perform the appropriate operation on the
   * resulting quantities.
   * @param env The environment in which to do the evaluation (symbol map).
   * @return The quantity contained in this AST.
   */
  public Quantity eval(Map<String,Quantity> env);

  /**
   * Check if the objects are equal.
   * @param o An object to compare to.
   * @return true if o represents the same kind of AST with the same structure
   *         false otherwise.
   */
  public boolean equals(Object o);
}

/** Class Product contains Product constructor used
 *  to create products of multiplied values.
 *  contains eval, toString, and equals methods
 */
class Product implements AST
{
  private AST left;
  private AST right;

  public Product(AST l, AST r)
  {
    this.left = l;
    this.right = r;
  }

  public Quantity eval(Map<String,Quantity> env)
  {
    //recursively evaluate the left subtree
    Quantity leftTree = this.left.eval(env);
    //recursively evaluate the right subtree
    Quantity rightTree = this.right.eval(env);
    //multiply left and right node and store it as new quantity
    Quantity product = leftTree.mul(rightTree);
    //return the multiplied quantity
    return product;
  }

  public String toString()
  {
    return ("Product(" + this.left + "," + this.right + ")");
  }

  public boolean equals(Object o)
  {
    if ( o instanceof Product )
    {
      Product tree = (Product)o;
      return tree.left.equals(left) && tree.right.equals(right);
    }
    else return false;
  }
}

/** Class quotient has Quotient constructor to create new
 * Quotient object from two subtrees. used in other classes
 * to divide two doubles.
 */
class Quotient implements AST
{
  //instance variables
  private AST left;
  private AST right;

  //Quotient constructor
  public Quotient(AST l, AST r)
  {
    this.left = l;
    this.right = r;
  }
  //eval method
  public Quantity eval(Map<String,Quantity> env)
  {
    //recursively evaluate the left subtree
    Quantity leftTree = this.left.eval(env);

    //recursively evaluate the right subtree
    Quantity rightTree = this.right.eval(env);

    //divide left and right node and store it as new quantity
    Quantity quotient = leftTree.div(rightTree);

    //return the divided quantity
    return quotient;
  }
  public String toString()
  {
    return("Quotient(" + left + "," + right + ")");
  }
  public boolean equals(Object o)
  {
    if (o instanceof Quotient)
    {
      Quotient tree = (Quotient)o;
      return tree.left.equals(left) && tree.right.equals(right);
    }
    else return false;
  }
}

/**Class power contains Power constructor to create
 * a Power object from an abstract syntax tree and
 * an int that represent the power to which we're
 * raising to.
 * Also contains eval, toString and equals.
 */
class Power implements AST
{
  //instance variables
  private AST child;
  private int exponent;

  //Power constructor
  public Power(AST ast, int expt)
  {
    this.child = ast;
    this.exponent = expt;
  }
  //eval method
  public Quantity eval(Map<String,Quantity> env)
  {
    //recursively evaluate child subtree
    Quantity childTree = this.child.eval(env);

    //calculate the power of child node to the exponent node
    Quantity power = childTree.pow(exponent);

    //return the powered quantity
    return power;
  }
  //toString method
  public String toString()
  {
    return ("Power(" + child + "," + exponent + ")");
  }
  //equals method
  public boolean equals(Object o)
  {
    if (o instanceof Power)
    {
      Power tree = (Power)o;
      return tree.child.equals(this.child) && tree.exponent == this.exponent;
    }
    else return false;
  }
}

/** Class sum contains sum constructor to create
 * a new sum object from two subtrees. Used to
 * add two quantities together in quantity.java.
 * contains eval, toString and equals.
 */
class Sum implements AST
{
  //instance variables
  private AST left;
  private AST right;

  //Sum constructor
  public Sum(AST l, AST r)
  {
    this.left = l;
    this.right = r;
  }
  //eval method
  public Quantity eval(Map<String,Quantity> env)
  {
    //recursively evaluate the left subtree
    Quantity leftTree = this.left.eval(env);

    //recursively evaluate the right subtree
    Quantity rightTree = this.right.eval(env);

    //calculate the sum of the left node and the right node
    Quantity sum = leftTree.add(rightTree);

    //return the added quantity
    return sum;
  }
  //toString method
  public String toString()
  {
    return ("Sum(" + left + "," + right + ")");
  }
  //equals method
  public boolean equals(Object o)
  {
    if(o instanceof Sum)
    {
      Sum tree = (Sum)o;
      return tree.left.equals(left) && tree.right.equals(right);
    }
    else return false;
  }
}

/**Class Difference contains Difference constructor
 * to create a new Difference object from two AST
 * subtrees. Used to subtract quantities.
 * Contains eval, toString, and equals.
 */
class Difference implements AST
{
  //instance variables
  private AST left;
  private AST right;

  //Difference constructor
  public Difference(AST l, AST r)
  {
    this.left = l;
    this.right = r;
  }
  //eval method
  public Quantity eval(Map<String,Quantity> env)
  {
    //recursively evaluate the left subtree
    Quantity leftTree = this.left.eval(env);

    //recursively evaluate the right subtree
    Quantity rightTree = this.right.eval(env);

    //calculate the difference of left node and right node
    Quantity difference = leftTree.sub(rightTree);

    //return the subtracted quantities
    return difference;
  }
  //toString method
  public String toString()
  {
    return ("Difference(" + left + "," + right + ")");
  }
  //equals method
  public boolean equals(Object o)
  {
    if(o instanceof Difference)
    {
      Difference tree = (Difference)o;
      return tree.left.equals(left) && tree.right.equals(right);
    }
    else return false;
  }

}

/** Class negation has new constructor
 * to create a new negate object from one subtree.
 * Contains eval, toString, and equals.
 */
class Negation implements AST
{
  //instance variables
  private AST child;
  public Negation(AST ast)
  {
    this.child = ast;
  }
  //eval method
  public Quantity eval(Map<String,Quantity> env)
  {
    //revursively evaluate the child subtree
    Quantity childTree = this.child.eval(env);

    //calculate the negation of child node
    Quantity negation = childTree.negate();

    //return the negated quantity
    return negation;
  }
  //toString method
  public String toString()
  {
    return ("Negation(" + child + ")");
  }
  //equals method
  public boolean equals(Object o)
  {
    if(o instanceof Negation)
    {
      Negation tree = (Negation)o;
      return tree.child.equals(this.child);
    }
    else return false;
  }
}

/** Class value contains value constructor
 * to create a new value object from a quantity.
 * contains eval, toString, and equals
 */
class Value implements AST
{
  //instance variables
  private Quantity quant;
  public Value(Quantity q)
  {
    this.quant = q;
  }
  //eval method
  public Quantity eval(Map<String,Quantity> env)
  {
    //make a deep copy of this value
    Quantity value = new Quantity(this.quant);

    //return the quantity contained in the object
    return value;
  }
  //toString method
  public String toString()
  {
    return ("Value(" + quant + ")");
  }
  //equals method
  public boolean equals(Object o)
  {
    if(o instanceof Value)
    {
      Value val = (Value)o;
      return val.quant.equals(this.quant);
    }
    else return false;
  }
}

/** Class normalize contains normalize
 * constructor to create a new normalized
 * object from one subtree.
 * contains eval, toString and equals
 */
class Normalize implements AST
{
  //instance variables
  private AST child;
  public Normalize(AST ast)
  {
    this.child = ast;
  }
  //eval method
  public Quantity eval(Map<String,Quantity> env)
  {
    //recursively evaluate the child subtree
    Quantity childTree = this.child.eval(env);

    //normalize the child node
    Quantity normalize = childTree.normalize(env);

    //return the normalized quantity
    return normalize;
  }
  //toString method
  public String toString()
  {
    return ("Normalize(" + child + ")");
  }
  //equals method
  public boolean equals(Object o)
  {
    if(o instanceof Normalize)
    {
      Normalize tree = (Normalize)o;
      return tree.child.equals(this.child);
    }
    else return false;
  }
}

/**Class define contains constructor used to create
 * a new Define object from a string that's a name
 * in the database as a result of some tree and also
 * from an AST.
 * Contains eval, toString, and equals.
 */
class Define implements AST
{
  //instance variables
  private String unitName;
  private AST defn;

  //Define constructor
  public Define(String name, AST ast)
  {
    this.unitName = name;
    this.defn = ast;
  }
  //eval method
  public Quantity eval(Map<String,Quantity> env)
  {
    //recursively evaluate the define tree
    Quantity define = defn.eval(env);

    //put the newly defined string and quantity in the env map
    env.put(this.unitName,define);

    //return the defined quantity
    return define;
  }
  //toString method
  public String toString()
  {
    return ("Define(" + unitName + "," + defn + ")");
  }
  //equals method
  public boolean equals(Object o)
  {
    if (o instanceof Define)
    {
      Define tree = (Define)o;
      return tree.unitName.equals( this.unitName )
        && tree.defn.equals( this.defn );
    }
    else return false;
  }

}

