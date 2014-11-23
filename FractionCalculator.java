
import java.util.Scanner;

public class FractionCalculator{

    private Fraction currentValue;
    private Operator currentOp;
    private String[] callAbs, callNegate, callClear, callQuit, callAdd, callSubtract, callDivide, callMultiply, callNewLine;
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
        callNewLine = new String[] {"\n"};
    }

    public Fraction evaluate(Fraction current, String input)
    {
        String currentWord = "";
        
        if (input.length() > 0)
        {
        for (int i = 0; i <= input.length(); i++)
        {
            if (currentWord != "" && (i == input.length() || input.charAt(i) == ' ') ) // evaluate once a full word
            {
                if (isValidNumber(currentWord))
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
                else if (isIn(currentWord, callNewLine)) currentOp = Operator.NONE;
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

        currentOp = Operator.NONE; //clear opator at end of input - i.e. next input will be a new line
        return current;
    }
    
    private boolean isValidNumber(String input)
    {
        if (input.length() == 0 || (input.length() == 1 && input.charAt(0) == '-') ) return false;
     
        if ( !(input.charAt(0) == '-' && Character.isDigit(input.charAt(1))) && !Character.isDigit(input.charAt(0))) return false;
     
        if ( !Character.isDigit(input.charAt(input.length() - 1))) return false;
     
        boolean alreadyOneDivisor = false;
        for (int i = 1; i < input.length(); i++)
        {
            if (input.charAt(i) == '/' && alreadyOneDivisor) return false;
            else if (input.charAt(i) == '/') alreadyOneDivisor = true;
            else if (input.charAt(i) == '-' && input.charAt(i - 1) !=  '/') return false;
            else if (!Character.isDigit(input.charAt(i)) && input.charAt(i) != '-') return false;
        }
        
        return true;
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
    
    public void setQuit() {quit = true;}
    public boolean getQuit() {return quit;}


    public static void main (String[] args)
    {
        FractionCalculator fc = new FractionCalculator();
        
        System.out.println("Welcome Paul to the Fraction calculator.");
        System.out.println(fc.currentValue.toString());
    
        Scanner kb = new Scanner(System.in);
    
        while (!fc.getQuit())
        {
            System.out.print("\t" );
            
            if (!kb.hasNextLine())
            {
                System.out.println("Goodbye");
                fc.setQuit();
            }
            else
            {
                String input = kb.nextLine();
                // should user input \n to input multiple lines, nextLine() reads \n as a string. This is converted below.
                // I've assumed from the coursework example that this functionality is required, if it isnt then the solution would
                // be to just input kb.nextLine into evaluate
                String splitIntoLines = splitIntoLines(input);
            
                Scanner lines = new Scanner(splitIntoLines);
                while (lines.hasNextLine())
                {
                    fc.currentValue = fc.evaluate(fc.currentValue, lines.nextLine());
                    System.out.println(fc.currentValue.toString());
                }
                lines.close();
            }
        }
    
        kb.close();
    
    }
    
    private static String splitIntoLines(String input)
    {
    
        if (input.length() < 2) return input;
        else if (input.equals("\\n")) return "\n";
        else if ((input.length() > 2) && input.substring(0,3).equals("\\n ")) return splitIntoLines("\n" + input.substring(2));
        else if ((input.length() > 2) && input.substring(input.length() - 3).equals(" \\n"))
        {
            return splitIntoLines(input.substring(0,input.length() - 2) + "\n");
        }
        else if (input.length() > 3)
        {
            for (int i = 0; i <= input.length() - 4; i++)
            {
                if (input.substring(i,i+4).equals(" \\n ")) return splitIntoLines(input.substring(0, i + 1) + "\n" + input.substring(i+3));
            }
        }
    
        return input;
    }

}

enum Operator{
    NONE, ADD, SUBTRACT, MULTIPLY, DIVIDE
}