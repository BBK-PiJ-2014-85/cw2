/**
* Created by keith for the second coursework assignment.
*/
public class FractionTest {
public static void main(String[] args) {
// test divide by zero - should print an error and exit
new Fraction(1, 0);
// test multiply
Fraction f = new Fraction(3,10);
Fraction g = new Fraction(1,2);
Fraction h = new Fraction(3,5);
if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");

// test equals
test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
test(new Fraction(4, -8),new Fraction(1, -2),"error test 5");
// tests that correctly identifies when not equal - should print a message saying correctly unequal
test(new Fraction(4,-8), new Fraction(1,2),"correctly unequal");
test(new Fraction(-1, 2),new Fraction(1, -2),"error: doesn't consider opposite signs on num/denom as equal");
test(new Fraction(-1,-3), new Fraction(1,3),"error: comparing negative nom and denom not same overall as positive");

// test addition
Fraction i = new Fraction(8,10);
if (!i.equals(f.add(g))) System.out.println("Addition failed");

//test subtraction
Fraction j = new Fraction(-1,5);
if (!j.equals(f.subtract(g))) System.out.println("Subtraction failed");

//test division
Fraction k = new Fraction(3,5);
if (!k.equals(f.divide(g))) System.out.println("Division failed");
System.out.println("Error detailing division by zero should be provided on the next line:");
if (k.divide(new Fraction(0,1)) != null) System.out.println("Test error that division by zero not correct");


//test abs
Fraction l = new Fraction(-3,5);
if (!k.equals(l.abs())) System.out.print("Abs failed");
//test doesnt negate negative number - should output a message
if (!l.equals(k.abs())) System.out.println("Abs correctly unequal");

//test negate
if (!k.equals(l.negate())) System.out.print("negate failed");
//test doesnt negate negative number - should output a message
if (!l.equals(k.negate())) System.out.println("negate failed");

//test if denominator stays negative when simplyfying
Fraction m = new Fraction(1,-2);
System.out.println(m.toString());
/* negations do not get passed to numerator. In fact, all negations are simplified to be held on denominator*/

//test toString improvements
Fraction n = new Fraction(-7,-1);
Fraction o = new Fraction(-7,1);
if (!n.toString().equals("7")) System.out.println("Error in toString test 1");
if (!o.toString().equals("-7")) System.out.println("Error in toString test 2");




}
static void test(Fraction f1, Fraction f2, String msg){
if (! f1.equals(f2))
System.out.println(msg);
}
}

