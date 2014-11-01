
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
    
    }

}