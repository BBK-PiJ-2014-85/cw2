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

// test addition
Fraction i = new Fraction(8,10);
if (!i.equals(f.add(g))) System.out.println("Addition failed");

}
static void test(Fraction f1, Fraction f2, String msg){
if (! f1.equals(f2))
System.out.println(msg);
}
}

