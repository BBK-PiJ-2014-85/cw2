
import java.util.Scanner;


public class FractionCalculator{

    private Fraction currentValue;
    private Operator currentOp;
    private String[] callAbs, callNegate, callClear, callQuit, callAdd, callSubtract, callDivide, callMultiply;
    private boolean quit;
    
    public FractionCalculator()
    {
        currentValue = new Fraction(0,1);
        currentOp = Operator.NONE;
        quit = false;
        
        // not checking these values are unique as out of scope, although if repeats then unexpected outputs may occur
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
        
        if (input.length() > 0)
        {
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
                else if (isIn(currentWord, callQuit))
                {
                    quit = true;
                    currentOp = Operator.NONE;
                    break;
                }
                else if (isIn(currentWord, callAdd))        {if (!updateOperator(Operator.ADD)) return new Fraction(0,1);}
                else if (isIn(currentWord, callSubtract))   {if (!updateOperator(Operator.SUBTRACT)) return new Fraction(0,1);}
                else if (isIn(currentWord, callMultiply))   {if (!updateOperator(Operator.MULTIPLY)) return new Fraction(0,1);}
                else if (isIn(currentWord, callDivide))     {if (!updateOperator(Operator.DIVIDE)) return new Fraction(0,1);}
                else if (isIn(currentWord, callAbs))        current = current.abs();
                else if (isIn(currentWord, callNegate))     current = current.negate();
                else if (isIn(currentWord, callClear))
                {
                    current = new Fraction(0,1);
                    currentOp = Operator.NONE; // although not specified on worksheet, clarified in class that operand should be cleared as well
                }
                else
                {
                    System.out.println("Error: input \"" + currentWord + "\" not understood. Calculator reset.");
                    currentOp = Operator.NONE;
                    return new Fraction(0,1);
                }
                
                currentWord="";
            
            }
            else if (i != input.length() && input.charAt(i) != ' ') currentWord += input.charAt(i);
        }
        
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
    
    public boolean updateOperator(Operator newOp)
    {
        if (currentOp == Operator.NONE)
        {
            currentOp = newOp;
            return true;
        }
        else
        {
            System.out.println("Error: Two operators input consecutively. Calculator reset.");
            currentOp = Operator.NONE;
            return false;
        }
    
    }


    public static void main (String[] args)
    {
        FractionCalculator fc = new FractionCalculator();
        
        System.out.println("Welcome Paul to the Fraction calculator.");
    
        Scanner kb = new Scanner(System.in);
    
        while (!fc.quit)
        {
            System.out.print(fc.currentValue.toString() + "\n\t" );
            String input = kb.nextLine();
            fc.currentValue = fc.evaluate(fc.currentValue, input );
        }
    
        System.out.println(fc.currentValue.toString());
        System.out.println("Goodbye");
    
    }

}

enum Operator{
    NONE, ADD, SUBTRACT, MULTIPLY, DIVIDE
}