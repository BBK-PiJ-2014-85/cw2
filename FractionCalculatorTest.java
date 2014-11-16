
public class FractionCalculatorTest{

    public static void main (String[] args)
    {
    
    FractionCalculator fc = new FractionCalculator();
    
    //Test evaluate properly reads and updates fractions
    
    if (!fc.evaluate(new Fraction(1,2), "1/3").equals(new Fraction(1,3))) System.out.println("Read fraction test 1 failed " + fc.evaluate(new Fraction(1,2), "1/3").toString());
    if (!fc.evaluate(new Fraction(1,2), "1").equals(new Fraction(1,1))) System.out.println("Read fraction test 2 failed " + fc.evaluate(new Fraction(1,2), "1").toString());
    if (!fc.evaluate(new Fraction(1,2), "-1/3").equals(new Fraction(1,-3))) System.out.println("Read fraction test 2 failed " + fc.evaluate(new Fraction(1,2), "1").toString());
    if (!fc.evaluate(new Fraction(1,2), "-1/-3").equals(new Fraction(1,3))) System.out.println("Read fraction test 2 failed " + fc.evaluate(new Fraction(1,2), "1").toString());
    if (!fc.evaluate(new Fraction(1,2), "1/-3").equals(new Fraction(1,-3))) System.out.println("Read fraction test 2 failed " + fc.evaluate(new Fraction(1,2), "1").toString());
    if (!fc.evaluate(new Fraction(1,2), "-1").equals(new Fraction(-1,1))) System.out.println("Read fraction test 2 failed " + fc.evaluate(new Fraction(1,2), "1").toString());
    if (!fc.evaluate(new Fraction(1,2), "-1 1/2").equals(new Fraction(1,2))) System.out.println("error: test 7");
    if (!fc.evaluate(new Fraction(1,2), "-1/2 -1").equals(new Fraction(1,-1))) System.out.println("error: test 8");
    
    // test isIn() array checker - commented out as now made private method
    /*
    if(!fc.isIn("A",new String[]{"a", "A", "abs"})) System.out.println("Error: isIn() test 1 failed");
    if(!fc.isIn("abs",new String[]{"a", "A", "abs"})) System.out.println("Error: isIn() test 2 failed");
    if(fc.isIn("Abs",new String[]{"a", "A", "abs"})) System.out.println("Error: isIn() test 3 failed");
    if(!fc.isIn("*",new String[]{"*"})) System.out.println("Error: isIn() test 4 failed");
    if(fc.isIn("7",new String[]{"*"})) System.out.println("Error: isIn() test 5 failed");
    */
    
    //test leading and trailing spaces
    if (!fc.evaluate(new Fraction(-1,2), "  1/2  ").equals(new Fraction(1,2))) System.out.println("Error: leading spaces error");
    
    //test operator is stored between runs correctly
    
    fc.evaluate(new Fraction(-1,2), " 1/2 * "); //This should store a multiply in the calculator
    if (!fc.evaluate(new Fraction(2,1), "3").equals(new Fraction(6,1))) System.out.println("Error: calculator not storing operator between runs");

    
    //test addition
     if (!fc.evaluate(new Fraction(1,2), " + 1/3").equals(new Fraction(5,6))) System.out.println("Error: addition test 1 failed");
     if (!fc.evaluate(new Fraction(-1,2), " + -1/3").equals(new Fraction(-5,6))) System.out.println("Error: addition test 2 failed");
     if (!fc.evaluate(new Fraction(1,2), " + 1/3 + 1/-3").equals(new Fraction(1,2))) System.out.println("Error: addition test 3 failed");
     if (!fc.evaluate(new Fraction(1,2), " + 1/3 + 1").equals(new Fraction(11,6))) System.out.println("Error: addition test 4 failed");
     if (!fc.evaluate(new Fraction(1,2), " + 1/3 + -1").equals(new Fraction(1,-6))) System.out.println("Error: addition test 5 failed");
     
    //test subtraction
     if (!fc.evaluate(new Fraction(1,2), " - 1/3").equals(new Fraction(1,6))) System.out.println("Error: subtraction test 1 failed");
     if (!fc.evaluate(new Fraction(-1,2), "+ 1/3 - -1/3").equals(new Fraction(1,6))) System.out.println("Error: subtraction test 2 failed");
     if (!fc.evaluate(new Fraction(1,2), "+ 1 - 2").equals(new Fraction(-1,2))) System.out.println("Error: subtraction test 3 failed");
    
    //test division
     if (!fc.evaluate(new Fraction(1,2), "/ 1/2 / -1/2").equals(new Fraction(-2,1))) System.out.println("Error: division test 1 failed");
    
    //test multiplication
    if (!fc.evaluate(new Fraction(1,2), " * -1/3 + 1").equals(new Fraction(5,6))) System.out.println("Error: multiplication test 1 failed");
    
    //test abs
    if (!fc.evaluate(new Fraction(-1,2), " abs ").equals(new Fraction(1,2))) System.out.println("Error: abs test 1 failed");
    if (!fc.evaluate(new Fraction(7,1), " abs").equals(new Fraction(7,1))) System.out.println("Error: abs test 2 failed");
    
    //test negate
    if (!fc.evaluate(new Fraction(-1,2), "n").equals(new Fraction(1,2))) System.out.println("Error: neg test 1 failed");
    if (!fc.evaluate(new Fraction(7,1), " n").equals(new Fraction(-7,1))) System.out.println("Error: neg test 2 failed");
    
    //test clear
    if (!fc.evaluate(new Fraction(-1,2), " * c 1/2").equals(new Fraction(1,2))) System.out.println("Error: clear test 1 failed");
    if (!fc.evaluate(new Fraction(-1,2), " * 2 c").equals(new Fraction(0,1))) System.out.println("Error: clear test 2 failed");
    
    //test quit
    if (!fc.evaluate(new Fraction(-1,2), " - 1/2 + q + 5").equals(new Fraction(-1,1))) System.out.println("Error: quit test 1 failed");
    if (!fc.evaluate(new Fraction(1,2), "1/2").equals(new Fraction(1,2))) System.out.println("Error: quit test 2 failed. Operator not cleared.");
    
    //test error messages
    
    System.out.println("The following three lines should have an error printed for having two consecutive operators:");
    if (!fc.evaluate(new Fraction(-1,2), " 1/2 + 2 + * 3 *").equals(new Fraction(0,1))) System.out.println("Error: calculator not cleared on operator error");
    if (!fc.evaluate(new Fraction(-1,2), " 1/2 + 2 + abs * 3 *").equals(new Fraction(0,1))) System.out.println("Error: calculator not cleared on operator error");
    fc.evaluate(new Fraction(1,1),"*");
    if (!fc.evaluate(new Fraction(-1,2), " / 1/2 *").equals(new Fraction(0,1))) System.out.println("Error: calculator not cleared on operator error");
    if (!fc.evaluate(new Fraction(1,2), " 2").equals(new Fraction(2,1))) System.out.println("Error: operator not cleared when producing operator error");
    
    

    
    //operator stored
    
    //test updateOperator
    
    
    // functions tested manually using main method
    /*
        - that it quit
        - that it displays the propper greeting and leaving messages
        - that it feeds in the correct fraction on evaluate method
    */
    
    
    }

}