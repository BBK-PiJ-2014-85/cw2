public class FractionCalculator{

    private Fraction currentValue;
    private Operator currentOp;
    private String[] callAbs, callNegate, callClear, callQuit;
    
    public FractionCalculator()
    {
        currentValue = new Fraction(0,1);
        currentOp = Operator.NONE;
        
        callAbs = new String[]{"a", "A", "abs"};
        callNegate = new String[]{"n", "N", "neg"};
        callClear = new String[] {"c", "C", "clear"};
        callQuit = new String[] {"q", "Q", "quit"};
    }

    public Fraction evaluate(Fraction current, String input)
    {
 
    
            if (Character.isDigit(input.charAt(0))) //next input is a number
            {
                int i=0;
                String numString="", denString="";
                
                while (Character.isDigit(input.charAt(i)))
                {
                    numString = input.substring(0,i+1);
                    i++;
                }
                
                if (input.charAt(i+1) == '/')
                {
                    int start = i+2;
                    while(Character.isDigit(input.charAt(i+2))) //assuming correct input
                    {
                        denString = input.substring(start,i+3);
                        i++;
                    }
                }
            
                int num = Integer.parseInt(numString);
                int den = denString.equals("") ? 1 : Integer.parseInt(denString);
                
                return new Fraction(num,den);
            
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