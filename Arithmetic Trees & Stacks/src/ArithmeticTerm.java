import java.util.StringTokenizer;
import java.lang.Math;
public class ArithmeticTerm {
    private String expression;
    private StackLL<String> tokenizedStack;

    public ArithmeticTerm (String expression){
        this.expression = expression;
        tokenizedStack = new StackLL<String>();
    }

    public String toString(){
        return expression;
    }

    public void reverse(){
        StringTokenizer tokenized = new StringTokenizer(expression);

        while(tokenized.hasMoreTokens()){
            tokenizedStack.push(tokenized.nextToken());
        }

        this.expression = tokenizedStack.pop() + " ";
        while(tokenizedStack.getSize() > 0 ){
            expression += tokenizedStack.pop() + " ";
        }
    }

    public void printReversedStack(StackLL<String> stack){
        if(stack.isEmpty()){
            return;
        }

        StackLL<String> temp = stack;
        String reversed = "";

        while(!temp.isEmpty()) {
            reversed = reversed.concat(temp.peek()) + " ";
            temp.pop();
        }

        System.out.println(reversed);

    }

    public Double evaluate(){
        StringTokenizer tokenized = new StringTokenizer(expression);

        StackOfDoubles stack = new StackOfDoubles();

        while(tokenized.hasMoreTokens())
        {
            String s = tokenized.nextToken();

            try{
                Double d = Double.parseDouble(s);
                stack.push(d);

            }
            catch(Exception e)
            {
                Double d1 = stack.pop();

                switch(s)
                {
                    case "+":
                        stack.push(stack.pop()+d1);
                        break;

                    case "-":
                        stack.push(stack.pop()-d1);
                        break;

                    case "/":
                        stack.push(stack.pop()/d1);
                        break;

                    case "*":
                        stack.push(stack.pop()*d1);
                        break;

                    case "^":
                        stack.push(Math.pow(stack.pop(),d1));
                        break;

                    case "sqrt":
                        stack.push(Math.sqrt(d1));
                        break;

                    case "sin":
                        stack.push(Math.sin(d1));
                        break;

                    case "exp":
                        stack.push(Math.exp(d1));
                        break;

                    case "pi":
                        stack.push(Math.PI * d1);
                        break;
                }
            }
        }
        return stack.pop();

    }

    public String convert()
    {
        String postfix ="";

        StringTokenizer tokenized = new StringTokenizer(expression);

        StackLL<String>  postfixStack = new StackLL <String>();

        while(tokenized.hasMoreTokens())
        {
            String s = tokenized.nextToken();
            try
            {
                double d = Double.parseDouble(s);
                postfix += s + " ";
            }
            catch(Exception e)
            {
                if(s.equals("+")| s.equals("-") || s.equals("*") || s.equals("/")|| s.equals("sqrt") || s.equals("^") || s.equals("sin") || s.equals("exp")) {
                    postfixStack.push(s);
                } else if (s.equals("pi")){
                    postfix += "pi" + " ";
                }
                    else if (s.equals(")")) {
                    postfix += postfixStack.pop() + " ";
                }
            }
        }
        System.out.println();
        return postfix;
    }



    public static void main(String[] args){
        //ArithmeticTerm expression1 = new ArithmeticTerm("5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *");
        //System.out.println(expression1.toString());
        //expression1.reverse();
        //expression1.printReversedStack(expression1.tokenizedStack);

        //System.out.println();

        //ArithmeticTerm expression2 = new ArithmeticTerm("( 5.1 * ( ( ( 9 + 8.88 ) ^ ( ( sqrt 4 ) / 6 ) ) - 7 ) )");
        //System.out.println(expression2.toString());
        //expression2.reverse();
        //expression2.printReversedStack(expression2.tokenizedStack);

        //System.out.println();

        //System.out.println(expression2.toString());
        //expression2.reverse();
        //expression2.printReversedStack(expression2.tokenizedStack);

        //System.out.println();
       // ArithmeticTerm expression3 = new ArithmeticTerm("8.8 2.2 0.2 * /");
        //System.out.println("Evaluation of 8.8 2.2 0.2 * / is " + expression3.evaluate());

        //System.out.println();


        //ArithmeticTerm expression5	  = new ArithmeticTerm("( 5.1 * ( ( ( 9 + 8.88 ) ^ ( ( sqrt 4 ) / 6 ) ) - 7 ) )");
        //System.out.println("The original FPAE is " + expression5);

        //ArithmeticTerm exp6 = new ArithmeticTerm(expression5.convert());

        //System.out.println("Converted Expression is "+ expression5.convert());
        //System.out.println("The evaluation of the converted Expression " + exp6.evaluate());

        ArithmeticTerm expLab2 = new ArithmeticTerm("( ( ( sin ( 4 pi / 3 ) ) *  ( exp ( -1 * ( ( ( sqrt 2 ) - 1 ) / 8 ) ) ) ) / sqrt ( 6 pi ) )");
        System.out.println("The original FPAE is " + expLab2);

        ArithmeticTerm expLab2Converted = new ArithmeticTerm(expLab2.convert());
        System.out.println("The converted FPAE is " + expLab2Converted);
        System.out.println("The result of FPAE is " + expLab2Converted.evaluate());





    }
}
