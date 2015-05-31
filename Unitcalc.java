Last login: Sat May 23 19:29:13 on ttys000
Briannas-MacBook-Pro-2:~ briannamarie$ ls
Applications	Downloads	Music		TestCode
Desktop		Library		Pictures	ucsd
Documents	Movies		Public
Briannas-MacBook-Pro-2:~ briannamarie$ cd ucsd/cse12
Briannas-MacBook-Pro-2:cse12 briannamarie$ ls
Demo		HW3		HW5		HW8
HW1		HW4		HW6		HW8solution
HW2		HW4solution	HW7		hw7solution
Briannas-MacBook-Pro-2:cse12 briannamarie$ cd HW4
Briannas-MacBook-Pro-2:HW4 briannamarie$ ls
docs	hw4
Briannas-MacBook-Pro-2:HW4 briannamarie$ cd hw4/
Briannas-MacBook-Pro-2:hw4 briannamarie$ ls
BoundedDeque.class		MineSweeperGUI$MineCell.class
BoundedDeque.java		MineSweeperGUI.class
BoundedDequeTester.class	MineSweeperGUI.java
BoundedDequeTester.java		Queue12.class
BoundedQueue.class		Queue12.java
BoundedQueue.java		Queue12Tester.class
BoundedStack.class		Queue12Tester.java
BoundedStack.java		Stack12.class
Deque12.class			Stack12.java
Deque12.java			Stack12Tester.class
HW4.txt				Stack12Tester.java
MineSweeperGUI$1.class
Briannas-MacBook-Pro-2:hw4 briannamarie$ vi BoundedDequeTester.java 




Briannas-MacBook-Pro-2:hw4 briannamarie$ ls
BoundedDeque.class		MineSweeperGUI$MineCell.class
BoundedDeque.java		MineSweeperGUI.class
BoundedDequeTester.class	MineSweeperGUI.java
BoundedDequeTester.java		Queue12.class
BoundedQueue.class		Queue12.java
BoundedQueue.java		Queue12Tester.class
BoundedStack.class		Queue12Tester.java
BoundedStack.java		Stack12.class
Deque12.class			Stack12.java
Deque12.java			Stack12Tester.class
HW4.txt				Stack12Tester.java
MineSweeperGUI$1.class
Briannas-MacBook-Pro-2:hw4 briannamarie$ cd ..
Briannas-MacBook-Pro-2:HW4 briannamarie$ ls
docs	hw4
Briannas-MacBook-Pro-2:HW4 briannamarie$ cd ..
Briannas-MacBook-Pro-2:cse12 briannamarie$ cd HW8
Briannas-MacBook-Pro-2:HW8 briannamarie$ ls
hw8
Briannas-MacBook-Pro-2:HW8 briannamarie$ cd hw8/
Briannas-MacBook-Pro-2:hw8 briannamarie$ ls
AST.java		QuantityTester.java	Unicalc.java
ASTTester.java		Tokenizer.class		UnicalcTester.java
QuantityDB.java		Tokenizer.java
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi QuantityDB.java 
Briannas-MacBook-Pro-2:hw8 briannamarie$ ls
AST.java		QuantityDB.java		Tokenizer.class		Unicalc.java
ASTTester.java		QuantityTester.java	Tokenizer.java		UnicalcTester.java
Briannas-MacBook-Pro-2:hw8 briannamarie$ ls
AST.java		QuantityTester.java	Unicalc.java
ASTTester.java		Tokenizer.class		UnicalcTester.java
QuantityDB.java		Tokenizer.java
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi Quantity.java
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi Tokenizer.java 
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi Quantity.java 
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi Quantity.java 

[No write since last change]

Press ENTER or type command to continue
Quantity.java:49: error: illegal start of type
    quantityMap = new Map<String,new Integer(1)>();
                                 ^
Quantity.java:49: error: '(' or '[' expected
    quantityMap = new Map<String,new Integer(1)>();
                                     ^
Quantity.java:49: error: ';' expected
    quantityMap = new Map<String,new Integer(1)>();
                                            ^
Quantity.java:49: error: not a statement
    quantityMap = new Map<String,new Integer(1)>();
                                             ^
Quantity.java:49: error: ';' expected
    quantityMap = new Map<String,new Integer(1)>();
                                              ^
5 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:54: error: ';' expected
  public Quantity(Quantity toCopy) throw IllegalArgumentException
                                  ^
1 error

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:89: error: no suitable constructor found for HashMap(List<String>)
    this.units = new HashMap(negExpUnits);
                 ^
    constructor HashMap.HashMap(int) is not applicable
      (argument mismatch; List<String> cannot be converted to int)
    constructor HashMap.HashMap(Map) is not applicable
      (argument mismatch; List<String> cannot be converted to Map)
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
1 error

shell returned 1

Press ENTER or type command to continue
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi Quantity.java 

Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:88: error: cannot find symbol
    posExpUnits.sixe();
               ^
  symbol:   method sixe()
  location: variable posExpUnits of type List<String>
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:91: error: ')' expected
        "size of pos exp list: " posExpUnits.size() + "size of neg" +
                                ^
Quantity.java:91: error: illegal start of expression
        "size of pos exp list: " posExpUnits.size() + "size of neg" +
                                            ^
Quantity.java:91: error: ';' expected
        "size of pos exp list: " posExpUnits.size() + "size of neg" +
                                                 ^
Quantity.java:92: error: ';' expected
        "exp list: " + negExpUnits.size());
                                         ^
4 errors

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:88: error: incompatible types: double cannot be converted to String
    this.units.put(paramNumericalValue,new Integer(posExpUnits.size()));
                   ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:113: error: illegal start of expression
  private void calculateExponent(String unitString, int exponent)
  ^
Quantity.java:113: error: illegal start of expression
  private void calculateExponent(String unitString, int exponent)
          ^
Quantity.java:113: error: ';' expected
  private void calculateExponent(String unitString, int exponent)
                                ^
Quantity.java:113: error: <identifier> expected
  private void calculateExponent(String unitString, int exponent)
                                                   ^
Quantity.java:113: error: not a statement
  private void calculateExponent(String unitString, int exponent)
                                                        ^
Quantity.java:113: error: ';' expected
  private void calculateExponent(String unitString, int exponent)
                                                                ^
6 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:113: error: illegal start of expression
  private void calculateExponent(String unitString, int exponent)
  ^
Quantity.java:113: error: illegal start of expression
  private void calculateExponent(String unitString, int exponent)
          ^
Quantity.java:113: error: ';' expected
  private void calculateExponent(String unitString, int exponent)
                                ^
Quantity.java:113: error: <identifier> expected
  private void calculateExponent(String unitString, int exponent)
                                                   ^
Quantity.java:113: error: not a statement
  private void calculateExponent(String unitString, int exponent)
                                                        ^
Quantity.java:113: error: ';' expected
  private void calculateExponent(String unitString, int exponent)
                                                                ^
6 errors

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:97: error: variable exponentValue is already defined in constructor Quantity(double,List<String>,List<String>)
    int exponentValue = -1;
        ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:97: error: variable posExponentValue is already defined in constructor Quantity(double,List<String>,List<String>)
    int posExponentValue = -1;
        ^
Quantity.java:109: error: cannot find symbol
        this.units.put(posExpString,new Integer(exponentValue));
                                                ^
  symbol:   variable exponentValue
  location: class Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:109: error: cannot find symbol
        this.units.put(posExpString,new Integer(exponentValue));
                                                ^
  symbol:   variable exponentValue
  location: class Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:109: error: ';' expected
        posExponentValue = this.units.get(posExpString)
                                                       ^
1 error

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:116: error: illegal start of expression
      }
      ^
Quantity.java:116: error: ';' expected
      }
       ^
Quantity.java:142: error: illegal start of expression
  private void calculateExponent(String unitString, int exponent)
  ^
Quantity.java:142: error: illegal start of expression
  private void calculateExponent(String unitString, int exponent)
          ^
Quantity.java:142: error: ';' expected
  private void calculateExponent(String unitString, int exponent)
                                ^
Quantity.java:142: error: <identifier> expected
  private void calculateExponent(String unitString, int exponent)
                                                   ^
Quantity.java:142: error: not a statement
  private void calculateExponent(String unitString, int exponent)
                                                        ^
Quantity.java:142: error: ';' expected
  private void calculateExponent(String unitString, int exponent)
                                                                ^
Quantity.java:151: error: reached end of file while parsing
}
 ^
9 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:116: error: illegal start of expression
      }
      ^
Quantity.java:116: error: ';' expected
      }
       ^
Quantity.java:142: error: illegal start of expression
  private void calculateExponent(String unitString, int exponent)
  ^
Quantity.java:142: error: illegal start of expression
  private void calculateExponent(String unitString, int exponent)
          ^
Quantity.java:142: error: ';' expected
  private void calculateExponent(String unitString, int exponent)
                                ^
Quantity.java:142: error: <identifier> expected
  private void calculateExponent(String unitString, int exponent)
                                                   ^
Quantity.java:142: error: not a statement
  private void calculateExponent(String unitString, int exponent)
                                                        ^
Quantity.java:142: error: ';' expected
  private void calculateExponent(String unitString, int exponent)
                                                                ^
Quantity.java:151: error: reached end of file while parsing
}
 ^
9 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:116: error: illegal start of expression
      }
      ^
Quantity.java:116: error: ';' expected
      }
       ^
Quantity.java:153: error: reached end of file while parsing
}
 ^
3 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:112: error: cannot find symbol
        posExpValue = keysMappedValue + posExpValue;
        ^
  symbol:   variable posExpValue
  location: class Quantity
Quantity.java:112: error: cannot find symbol
        posExpValue = keysMappedValue + posExpValue;
                                        ^
  symbol:   variable posExpValue
  location: class Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
2 errors

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Briannas-MacBook-Pro-2:hw8 briannamarie$ ls
AST.java		Quantity.java		Tokenizer.class		UnicalcTester.java
ASTTester.java		QuantityDB.java		Tokenizer.java
Quantity.class		QuantityTester.java	Unicalc.java
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi Quantity.java 

Quantity.java:155: error: incompatible types: void cannot be converted to int
    thisNumericalValue = this.getNumericalValue();
                                               ^
Quantity.java:157: error: incompatible types: void cannot be converted to int
    paramNumericalValue = paramQuantity.getNumericalValue();
                                                         ^
Quantity.java:181: error: incompatible types: unexpected return value
    return this.numericalValue;
               ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
3 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:155: error: incompatible types: possible lossy conversion from double to int
    thisNumericalValue = this.getNumericalValue();
                                               ^
Quantity.java:157: error: incompatible types: possible lossy conversion from double to int
    paramNumericalValue = paramQuantity.getNumericalValue();
                                                         ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:159: error: missing return statement
  }
  ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:158: error: no suitable constructor found for Quantity(String,Integer)
     return new Quantity("string",new Integer(0));
            ^
    constructor Quantity.Quantity() is not applicable
      (actual and formal argument lists differ in length)
    constructor Quantity.Quantity(Quantity) is not applicable
      (actual and formal argument lists differ in length)
    constructor Quantity.Quantity(double,List<String>,List<String>) is not applicable
      (actual and formal argument lists differ in length)
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:202: error: cannot find symbol
    return this.Units;
               ^
  symbol: variable Units
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:171: error: cannot find symbol
    paramQuantity.setUnits(newUnits);
                           ^
  symbol:   variable newUnits
  location: class Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue

Quantity.java:171: error: cannot find symbol
    paramQuantity.setUnits(newUnits);
                           ^
  symbol:   variable newUnits
  location: class Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:171: error: cannot find symbol
    paramQuantity.setUnits(newUnits);
                           ^
  symbol:   variable newUnits
  location: class Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:174: error: cannot find symbol
    newUnits = this.units;
    ^
  symbol:   variable newUnits
  location: class Quantity
Quantity.java:179: error: cannot find symbol
    paramQuantity.setUnits(newUnits);
                           ^
  symbol:   variable newUnits
  location: class Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:173: error: ';' expected
    thisNumericalValue.setNumericalValue(this.getNumericalValue());
                      ^
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:166: error: cannot find symbol
    thisQuantityUnits
    ^
  symbol:   class thisQuantityUnits
  location: class Quantity
Quantity.java:168: error: variable thisNumericalValue is already defined in method mul(Quantity)
    thisNumericalValue = this.getNumericalValue();
    ^
Quantity.java:176: error: cannot find symbol
    newUnits = this.units;
    ^
  symbol:   variable newUnits
  location: class Quantity
Quantity.java:180: error: cannot find symbol
    paramQuantity.setUnits(newUnits);
                           ^
  symbol:   variable newUnits
  location: class Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
4 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:170: error: class, interface, or enum expected
  public Quantity mul(Quantity paramQuantity) throws IllegalArgumentException
         ^
Quantity.java:176: error: class, interface, or enum expected
    }
    ^
Quantity.java:180: error: class, interface, or enum expected
    double thisNumericalValue;
    ^
Quantity.java:182: error: class, interface, or enum expected
    double paramNumericalValue;
    ^
Quantity.java:184: error: class, interface, or enum expected
    double product;
    ^
Quantity.java:186: error: class, interface, or enum expected
    Map<String,Integer> thisQuantityUnits;
    ^
Quantity.java:188: error: class, interface, or enum expected
    Map<String,Integer> paramQuantityUnits;
    ^
Quantity.java:190: error: class, interface, or enum expected
    String mulString;
    ^
Quantity.java:192: error: class, interface, or enum expected
    thisQuantityUnits
    ^
Quantity.java:196: error: class, interface, or enum expected
    paramNumericalValue = paramQuantity.getNumericalValue();
    ^
Quantity.java:198: error: class, interface, or enum expected
    paramQuantityUnits = paramQuantity.getUnits();
    ^
Quantity.java:200: error: class, interface, or enum expected
    product = thisNumericalValue * paramNumericalValue;
    ^
Quantity.java:202: error: class, interface, or enum expected
    newUnits = this.units;
    ^
Quantity.java:204: error: class, interface, or enum expected
    paramQuantity.setNumericalValue(product);
    ^
Quantity.java:206: error: class, interface, or enum expected
    paramQuantity.setUnits(newUnits);
    ^
Quantity.java:207: error: class, interface, or enum expected
  }
  ^
Quantity.java:229: error: class, interface, or enum expected
  public double getNumericalValue()
         ^
Quantity.java:232: error: class, interface, or enum expected
  }
  ^
Quantity.java:237: error: class, interface, or enum expected
  public Map<String,Integer> getUnits()
         ^
Quantity.java:240: error: class, interface, or enum expected
  }
  ^
Quantity.java:245: error: class, interface, or enum expected
  public void setNumericalValue(double paramNumericalValue)
         ^
Quantity.java:248: error: class, interface, or enum expected
  }
  ^
Quantity.java:253: error: class, interface, or enum expected
  public void setUnits(Map<String,Integer> paramUnits)
         ^
Quantity.java:256: error: class, interface, or enum expected
  }
  ^
24 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:191: error: cannot find symbol
    thisQuantityUnits
    ^
  symbol:   class thisQuantityUnits
  location: class Quantity
Quantity.java:193: error: variable thisNumericalValue is already defined in method mul(Quantity)
    thisNumericalValue = this.getNumericalValue();
    ^
Quantity.java:201: error: cannot find symbol
    newUnits = this.units;
    ^
  symbol:   variable newUnits
  location: class Quantity
Quantity.java:205: error: cannot find symbol
    paramQuantity.setUnits(newUnits);
                           ^
  symbol:   variable newUnits
  location: class Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
4 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:192: error: missing return statement
  }
  ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:82: error: unexpected type
    this.getUnits() = new HashMap();
                 ^
  required: variable
  found:    value
Quantity.java:85: error: unexpected type
    this.getNumericalValue() = paramNumericalValue;
                          ^
  required: variable
  found:    value
Quantity.java:99: error: cannot find symbol
    calulateExponentInConstructor(posExpString, negExpString,
    ^
  symbol:   method calulateExponentInConstructor(String,String,List<String>,List<String>,int,int)
  location: class Quantity
Quantity.java:155: error: incompatible types: Object cannot be converted to String
      posExpString = posExpUnits.get(i);
                                    ^
Quantity.java:186: error: incompatible types: Object cannot be converted to String
      negExpString = negExpUnits.get(i);
                                    ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
5 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:85: error: unexpected type
    this.getNumericalValue() = paramNumericalValue;
                          ^
  required: variable
  found:    value
Quantity.java:99: error: cannot find symbol
    calulateExponentInConstructor(posExpString, negExpString,
    ^
  symbol:   method calulateExponentInConstructor(String,String,List<String>,List<String>,int,int)
  location: class Quantity
Quantity.java:155: error: incompatible types: Object cannot be converted to String
      posExpString = posExpUnits.get(i);
                                    ^
Quantity.java:186: error: incompatible types: Object cannot be converted to String
      negExpString = negExpUnits.get(i);
                                    ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
4 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:99: error: cannot find symbol
    calulateExponentInConstructor(posExpString, negExpString,
    ^
  symbol:   method calulateExponentInConstructor(String,String,List<String>,List<String>,int,int)
  location: class Quantity
Quantity.java:155: error: incompatible types: Object cannot be converted to String
      posExpString = posExpUnits.get(i);
                                    ^
Quantity.java:186: error: incompatible types: Object cannot be converted to String
      negExpString = negExpUnits.get(i);
                                    ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
3 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:155: error: incompatible types: Object cannot be converted to String
      posExpString = posExpUnits.get(i);
                                    ^
Quantity.java:186: error: incompatible types: Object cannot be converted to String
      negExpString = negExpUnits.get(i);
                                    ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:155: error: incompatible types: Object cannot be converted to String
      posExpString = posExpUnits.get(i);
                                    ^
Quantity.java:186: error: incompatible types: Object cannot be converted to String
      negExpString = negExpUnits.get(i);
                                    ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:155: error: incompatible types: Object cannot be converted to String
      posExpString = posExpUnits.get(i);
                                    ^
Quantity.java:186: error: incompatible types: Object cannot be converted to String
      negExpString = negExpUnits.get(i);
                                    ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:186: error: incompatible types: Object cannot be converted to String
      negExpString = negExpUnits.get(i);
                                    ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:135: error: method calculateExponentInMul in class Quantity cannot be applied to given types;
    calculateExponentInMul();
    ^
  required: List,String
  found: no arguments
  reason: actual and formal argument lists differ in length
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:135: error: incompatible types: Quantity cannot be converted to List
    calculateExponentInMul(paramQuantity,unitString);
                           ^
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:135: error: incompatible types: Quantity cannot be converted to List
    calculateExponentInMul(paramQuantity,unitString);
                           ^
Quantity.java:145: error: cannot find symbol
    for(int i = 0; i < paramQuantity.getUnits().size(); i++)
                                    ^
  symbol:   method getUnits()
  location: variable paramQuantity of type List
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
3 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:135: error: incompatible types: Quantity cannot be converted to List
    calculateExponentInMul(paramQuantity,unitString);
                           ^
Quantity.java:145: error: cannot find symbol
    for(int i = 0; i < paramQuantity.units.size(); i++)
                                    ^
  symbol:   variable units
  location: variable paramQuantity of type List
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
3 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:135: error: incompatible types: Quantity cannot be converted to List
    calculateExponentInMul(paramQuantity,unitString);
                           ^
Quantity.java:145: error: cannot find symbol
    for(int i = 0; i < paramQuantity.getUnits().size(); i++)
                                    ^
  symbol:   method getUnits()
  location: variable paramQuantity of type List
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
3 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:135: error: incompatible types: Quantity cannot be converted to List
    calculateExponentInMul(paramQuantity,unitString);
                           ^
Quantity.java:145: error: bad operand types for binary operator '<'
    for(int i = 0; i < paramQuantity; i++)
                     ^
  first type:  int
  second type: List
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
3 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:135: error: incompatible types: Quantity cannot be converted to List
    calculateExponentInMul(paramQuantity,unitString);
                           ^
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:135: error: incompatible types: Map<String,Integer> cannot be converted to List
    calculateExponentInMul(paramQuantity.getUnits(),unitString);
                                                 ^
Quantity.java:145: error: cannot find symbol
    for(int i = 0; i < paramQuantity.size(); i++)
                       ^
  symbol:   variable paramQuantity
  location: class Quantity
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
3 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:135: error: incompatible types: Map<String,Integer> cannot be converted to List
    calculateExponentInMul(paramQuantity.getUnits(),unitString);
                                                 ^
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:135: error: incompatible types: Quantity cannot be converted to List
    calculateExponentInMul(paramQuantity,unitString);
                           ^
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:145: error: cannot find symbol
    for(int i = 0; i < paramQuantity.size(); i++)
                                    ^
  symbol:   method size()
  location: variable paramQuantity of type Quantity
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:145: error: cannot find symbol
    for(int i = 0; i < paramQuantity.getUnits.size(); i++)
                                    ^
  symbol:   variable getUnits
  location: variable paramQuantity of type Quantity
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:148: error: cannot find symbol
      unitString = ((String)unitString.get(i));
                                      ^
  symbol:   method get(int)
  location: variable unitString of type String
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:148: error: incompatible types: Integer cannot be converted to String
      unitString = ((String)paramQuantity.getUnits().get(i));
                                                        ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:148: error: incompatible types: Integer cannot be converted to String
      unitString = (paramQuantity.getUnits().get(i));
                                                ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:148: error: incompatible types: Integer cannot be converted to String
      unitString = (paramQuantity.getUnits().get(i));
                                                ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:148: error: incompatible types: Integer cannot be converted to String
      unitString = ((String)(paramQuantity.getUnits().get(i)));
                            ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:145: error: bad initializer for for-loop
    for(unitString : paramQuantity.getUnits.keySet())
        ^
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:145: error: cannot find symbol
    for(String string : paramQuantity.getUnits.keySet())
                                     ^
  symbol:   variable getUnits
  location: variable paramQuantity of type Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:145: error: cannot find symbol
    for(String string : paramQuantity.getUnits.keySet())
                                     ^
  symbol:   variable getUnits
  location: variable paramQuantity of type Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:135: error: variable unitString might not have been initialized
    calculateExponentInMul(paramQuantity,unitString);
                                         ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:133: error: cannot find symbol
    calculateExponentInMul(paramQuantity,unitString);
                                         ^
  symbol:   variable unitString
  location: class Quantity
Quantity.java:146: error: cannot find symbol
      if(((Integer)this.units.get(unitString)) == null)
                                  ^
  symbol:   variable unitString
  location: class Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
2 errors

shell returned 1

Press ENTER or type command to continue
Quantity.java:133: error: cannot find symbol
    calculateExponentInMul(paramQuantity,unitString);
                                         ^
  symbol:   variable unitString
  location: class Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:175: error: cannot find symbol
        this.units.put(posExpString,new Integer(1));
                       ^
  symbol:   variable posExpString
  location: class Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:161: error: missing return statement
  }
  ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:178: error: cannot find symbol
    newQuantity.setNumbericalValue(quotient);
               ^
  symbol:   method setNumbericalValue(double)
  location: variable newQuantity of type Quantity
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Quantity.java:202: error: missing return statement
  }
  ^
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

shell returned 1

Press ENTER or type command to continue
Quantity.java:201: error: not a statement
    Quantity new Quantity = new Quantity();
    ^
Quantity.java:201: error: ';' expected
    Quantity new Quantity = new Quantity();
            ^
2 errors

shell returned 1

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Note: Quantity.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

Press ENTER or type command to continue
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi QuantityDB.java 
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi Quantity.java 
Briannas-MacBook-Pro-2:hw8 briannamarie$ ls
AST.class		ParseError.class	QuantityTester.class	Unicalc.class
AST.java		Power.class		QuantityTester.java	Unicalc.java
ASTTester.java		Product.class		Quotient.class		UnicalcTester.java
Define.class		Quantity.class		README.md		Value.class
Difference.class	Quantity.java		Sum.class
Negation.class		QuantityDB.class	Tokenizer.class
Normalize.class		QuantityDB.java		Tokenizer.java
Briannas-MacBook-Pro-2:hw8 briannamarie$ cd ..
Briannas-MacBook-Pro-2:HW8 briannamarie$ cd ..
Briannas-MacBook-Pro-2:cse12 briannamarie$ ls
Demo		HW2		HW4		HW5		HW7		HW8solution
HW1		HW3		HW4solution	HW6		HW8		hw7solution
Briannas-MacBook-Pro-2:cse12 briannamarie$ cd HW4
Briannas-MacBook-Pro-2:HW4 briannamarie$ ls
docs	hw4
Briannas-MacBook-Pro-2:HW4 briannamarie$ cd hw4/
Briannas-MacBook-Pro-2:hw4 briannamarie$ ls
BoundedDeque.class		Deque12.class			Queue12.java
BoundedDeque.java		Deque12.java			Queue12Tester.class
BoundedDequeTester.class	HW4.txt				Queue12Tester.java
BoundedDequeTester.java		MineSweeperGUI$1.class		Stack12.class
BoundedQueue.class		MineSweeperGUI$MineCell.class	Stack12.java
BoundedQueue.java		MineSweeperGUI.class		Stack12Tester.class
BoundedStack.class		MineSweeperGUI.java		Stack12Tester.java
BoundedStack.java		Queue12.class
Briannas-MacBook-Pro-2:hw4 briannamarie$ vi BoundedDequeTester.java 
Briannas-MacBook-Pro-2:hw4 briannamarie$ vi Deque12.java 
Briannas-MacBook-Pro-2:hw4 briannamarie$ vi BoundedDequeTester.java 
Briannas-MacBook-Pro-2:hw4 briannamarie$ ls
BoundedDeque.class		Deque12.class			Queue12.java
BoundedDeque.java		Deque12.java			Queue12Tester.class
BoundedDequeTester.class	HW4.txt				Queue12Tester.java
BoundedDequeTester.java		MineSweeperGUI$1.class		Stack12.class
BoundedQueue.class		MineSweeperGUI$MineCell.class	Stack12.java
BoundedQueue.java		MineSweeperGUI.class		Stack12Tester.class
BoundedStack.class		MineSweeperGUI.java		Stack12Tester.java
BoundedStack.java		Queue12.class
Briannas-MacBook-Pro-2:hw4 briannamarie$ cd ..
Briannas-MacBook-Pro-2:HW4 briannamarie$ ls
docs	hw4
Briannas-MacBook-Pro-2:HW4 briannamarie$ cd ..
Briannas-MacBook-Pro-2:cse12 briannamarie$ ls
Demo		HW2		HW4		HW5		HW7		HW8solution
HW1		HW3		HW4solution	HW6		HW8		hw7solution
Briannas-MacBook-Pro-2:cse12 briannamarie$ vi HW8
Briannas-MacBook-Pro-2:cse12 briannamarie$ cd HW8
Briannas-MacBook-Pro-2:HW8 briannamarie$ ls
hw8
Briannas-MacBook-Pro-2:HW8 briannamarie$ cd hw8/
Briannas-MacBook-Pro-2:hw8 briannamarie$ ls
AST.class		ParseError.class	QuantityTester.class	Unicalc.class
AST.java		Power.class		QuantityTester.java	Unicalc.java
ASTTester.java		Product.class		Quotient.class		UnicalcTester.java
Define.class		Quantity.class		README.md		Value.class
Difference.class	Quantity.java		Sum.class
Negation.class		QuantityDB.class	Tokenizer.class
Normalize.class		QuantityDB.java		Tokenizer.java
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi Quantity.java 
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi README
Briannas-MacBook-Pro-2:hw8 briannamarie$ ls
AST.class		Normalize.class		QuantityDB.class	README.md		UnicalcTester.java
AST.java		ParseError.class	QuantityDB.java		Sum.class		Value.class
ASTTester.java		Power.class		QuantityTester.class	Tokenizer.class
Define.class		Product.class		QuantityTester.java	Tokenizer.java
Difference.class	Quantity.class		Quotient.class		Unicalc.class
Negation.class		Quantity.java		README			Unicalc.java
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi Quantity.java 
Briannas-MacBook-Pro-2:hw8 briannamarie$ ls
AST.class		Normalize.class		QuantityDB.class	README.md		UnicalcTester.java
AST.java		ParseError.class	QuantityDB.java		Sum.class		Value.class
ASTTester.java		Power.class		QuantityTester.class	Tokenizer.class
Define.class		Product.class		QuantityTester.java	Tokenizer.java
Difference.class	Quantity.class		Quotient.class		Unicalc.class
Negation.class		Quantity.java		README			Unicalc.java
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi Unicalc.java 
Briannas-MacBook-Pro-2:hw8 briannamarie$ ls
AST.class		Normalize.class		QuantityDB.class	README.md		UnicalcTester.java
AST.java		ParseError.class	QuantityDB.java		Sum.class		Value.class
ASTTester.java		Power.class		QuantityTester.class	Tokenizer.class
Define.class		Product.class		QuantityTester.java	Tokenizer.java
Difference.class	Quantity.class		Quotient.class		Unicalc.class
Negation.class		Quantity.java		README			Unicalc.java
Briannas-MacBook-Pro-2:hw8 briannamarie$ vi Unicalc.java 

    } catch (NumberFormatException e) {
      return false;
    }   
  }

  /** method isAlphabetic(string)
   * other wise return Q, no negation
   * @param String string
   * @return either true or false if string is a letter
   */
  private static boolean isAlphabetic(String s)
  {
    return s != null && s.matches("[a-zA-Z_]+");
  }

  //do this one second
  public AST Q() 
  {
    //MULTIPLICATION
    // Q -> R | R Q

    AST r = R();

    //if i peek and r is followed by a num, wrd, or (
    if((isNumeric(this.toks.peek()) == true) ||
        (isAlphabetic(this.toks.peek()) == true) ||
        ("(".equals(this.toks.peek)))
    {   
      //then recursively grab return a product of r and Q
      //REMEMBER Product(AST absSyntaxTree, int exponent);
      return new Product(r,Q());
    }   
    else
    {   
      return r;
    }   


  }

  //do this one first
  public AST R() 
  {
    //RAISE TO THE POWER OF
    // R -> V | V ^ J

    AST v = V();

    //if i peek and v is followed by a "to the power of" symbol
    if("^".equals(this.toks.peek()))
:set nonu                                                                        207,5         51%
