public class FractionCalculator{

    private Fraction currentValue;
    private Operator currentOp;
    private String[] callAbs, callNegate, callClear, callQuit, callAdd, callSubtract, callDivide, callMultiply;
    
    public FractionCalculator()
    {
        currentValue = new Fraction(0,1);
        currentOp = Operator.NONE;
        
        callAbs = new String[]{"a", "A", "abs"};
        callNegate = new String[]{"n", "N", "neg"};
        callClear = new String[] {"c", "C", "clear"};
        callQuit = new String[] {"q", "Q", "quit"};
        callAdd = new String[] {"+"};
        callSubtract = new String[] {"-"};
        callMultiply = new String[] {"*"};
        callDivide = new String[] {"/"};
    }

    public Fraction evaluate(Fraction current, String input)
    {
        String currentWord = "";
        
        for (int i = 0; i <= input.length(); i++)
        {
            if (i == input.length() || input.charAt(i) == ' ') // evaluate full word
            {
                if (Character.isDigit(currentWord.charAt(0)) || (currentWord.length() > 1 && Character.isDigit(currentWord.charAt(1))))
                    //its a number
                {
                    int fractionLocation =0, num=1,denom=1;
                    
                    for (int j =0; j < currentWord.length(); j++)
                    {
                        if (currentWord.charAt(j) == '/') fractionLocation=j;
                    }
                    
                    if (fractionLocation == 0)
                    {
                        num = Integer.parseInt(currentWord);
                    }
                    else
                    {
                        num = Integer.parseInt(currentWord.substring(0,fractionLocation));
                        denom = Integer.parseInt(currentWord.substring(fractionLocation + 1));
                    }
                    
                    return new Fraction(num, denom);
                
                }
                
                currentWord="";
            }
            else currentWord += input.charAt(i);
        }


        return null;
    }

    public static void main (String[] args)
    {
    
    }

}

enum Operator{
    NONE, ADD, SUBSTRACT, MULTIPLY, DIVIDE
}