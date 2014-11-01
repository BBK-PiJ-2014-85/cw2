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
            if (currentWord != "" && (i == input.length() || input.charAt(i) == ' ') ) // evaluate full word
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
                    
                    Fraction numberInput = new Fraction(num, denom);
                    
                    if (currentOp == Operator.NONE) current = numberInput;
                    else if (currentOp == Operator.ADD) current = current.add(numberInput);
                    else if (currentOp == Operator.SUBTRACT) current = current.subtract(numberInput);
                    else if (currentOp == Operator.MULTIPLY) current = current.multiply(numberInput);
                    else if (currentOp == Operator.DIVIDE) current = current.divide(numberInput);
                    
                    currentOp = Operator.NONE;
                
                }
                else if (isIn(currentWord, callAdd))
                {
                    updateOperator(Operator.ADD);
                }
                
                currentWord="";
            }
            else currentWord += input.charAt(i);
        }


        return current;
    }
    
    private boolean isIn(String word, String[] commands)
    {
        for (int i=0; i< commands.length; i++)
        {
            if (commands[i].equals(word)) return true;
        }
        
        return false;
    }
    
    public void updateOperator(Operator newOp)
    {
        if (currentOp == Operator.NONE) currentOp = newOp;
        else resetCalculator();
    }

    public void resetCalculator()
    {
    
    }

    public static void main (String[] args)
    {
    
    }

}

enum Operator{
    NONE, ADD, SUBTRACT, MULTIPLY, DIVIDE
}