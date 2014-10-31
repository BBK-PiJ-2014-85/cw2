public class FractionCalculator{

    private Fraction currentValue;
    private Operator currentOp;
    private String[] callAbs, callNegate, callClear, callQuit;
    
    public FractionCalculator()
    {
        currentValue = new Fraction(0,1);
        currentOp = Operator.NONE;
        
        callAbs     = {"a", "A", "abs"};
        callNegate  = {"n", "N", "neg"};
        callClear   = {"c", "C", "clear"};
        callQuit    = {"q", "Q", "quit"};
    }


    public static void main (String[] args)
    {
    
    }

}

public enum Operator{
    NONE, ADD, SUBSTRACT, MULTIPLY, DIVIDE
}