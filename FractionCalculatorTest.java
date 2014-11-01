
public class FractionCalculatorTest{

    public static void main (String[] args)
    {
    
    FractionCalculator fc = new FractionCalculator();
    
    if (!fc.evaluate(new Fraction(1,2), "1/3").equals(new Fraction(1,3))) System.out.println("Read fraction test 1 failed " + fc.evaluate(new Fraction(1,2), "1/3").toString());
    if (!fc.evaluate(new Fraction(1,2), "1").equals(new Fraction(1,1))) System.out.println("Read fraction test 2 failed " + fc.evaluate(new Fraction(1,2), "1").toString());
    if (!fc.evaluate(new Fraction(1,2), "-1/3").equals(new Fraction(1,-3))) System.out.println("Read fraction test 2 failed " + fc.evaluate(new Fraction(1,2), "1").toString());
    if (!fc.evaluate(new Fraction(1,2), "-1/-3").equals(new Fraction(1,3))) System.out.println("Read fraction test 2 failed " + fc.evaluate(new Fraction(1,2), "1").toString());
    if (!fc.evaluate(new Fraction(1,2), "1/-3").equals(new Fraction(1,-3))) System.out.println("Read fraction test 2 failed " + fc.evaluate(new Fraction(1,2), "1").toString());
    if (!fc.evaluate(new Fraction(1,2), "-1").equals(new Fraction(-1,1))) System.out.println("Read fraction test 2 failed " + fc.evaluate(new Fraction(1,2), "1").toString());
    if (!fc.evaluate(new Fraction(1,2), "-1 1/2").equals(new Fraction(1,2))) System.out.println("error: test 7");
    if (!fc.evaluate(new Fraction(1,2), "-1/2 -1").equals(new Fraction(1,-1))) System.out.println("error: test 8");
    
    //test addition
     if (!fc.evaluate(new Fraction(1,2), " + 1/3").equals(new Fraction(5,6))) System.out.println("Error: addition test 1 failed");
     if (!fc.evaluate(new Fraction(-1,2), " + -1/3").equals(new Fraction(-5,6))) System.out.println("Error: addition test 2 failed");
     if (!fc.evaluate(new Fraction(1,2), " + 1/3 + 1/-3").equals(new Fraction(1,2))) System.out.println("Error: addition test 3 failed");
     if (!fc.evaluate(new Fraction(1,2), " + 1/3 + 1").equals(new Fraction(11,6))) System.out.println("Error: addition test 4 failed");
     if (!fc.evaluate(new Fraction(1,2), " + 1/3 + -1").equals(new Fraction(1,-6))) System.out.println("Error: addition test 5 failed");
     
    //test subtraction
    
    
    
    //test division
    
    
    
    //test multiplication
    
    
    
    //test abs
    
    
    
    //test negate
    
    
    
    //testclear
    
    
    //testquit
    
    
    
    
    }

}