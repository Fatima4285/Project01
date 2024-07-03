
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial) or 'exit' to quit:");
            String operation = scanner.next();
            
            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }

            // For operations requiring two inputs
            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") && !operation.equalsIgnoreCase("log10") && !operation.equalsIgnoreCase("sin") && !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") && !operation.equalsIgnoreCase("factorial")) {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "add":
                        System.out.println("Result: " + add(num1, num2));
                        break;
                    case "subtract":
                        System.out.println("Result: " + subtraction(num1, num2));
                        break;
                    case "multiply":
                        System.out.println("Result: " + multiplication(num1, num2));
                        break;
                    case "divide":
                        System.out.println("Result: " + division(num1, num2));
                        break;
                    case "pow":
                        System.out.println("Result: " + power(num1, num2));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            } else {
                // For operations requiring one input
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "sqrt":
                        System.out.println("Result: " + sqrt(num));
                        break;
                    case "log":
                        System.out.println("Result: " + log(num));
                        break;
                    case "log10":
                        System.out.println("Result: " + log10(num));
                        break;
                    case "sin":
                        System.out.println("Result: " + sin(num));
                        break;
                    case "cos":
                        System.out.println("Result: " + cos(num));
                        break;
                    case "tan":
                        System.out.println("Result: " + tan(num));
                        break;
                    case "factorial":
                        // Factorial is a special case requiring an integer
                        System.out.println("Result: " + factorial((int)num));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            }
        }
        
        scanner.close();

    }
    
    /*adds two numbers
     * @param a first operand to add
     *@param b second operand to add
     *@return returns the added result as a double */
    public static double add(double a, double b) {
        return a + b;
    }
    /*subtracts two numbers
     * @param a first operand to subtract
     *@param b second operand to subtract
     *@return returns the subtracted result as a double */
    public static double subtraction(double a, double b) {
    	return a - b;
    }
    /*multiplies two numbers
     * @param a first operand to multiply
     *@param b second operand to multiply
     *@return returns the multiplied result as a double */
    public static double multiplication(double a, double b) {
    	return a*b;
    }
    /*divides two numbers
     * @param a first operand to divide
     * @param b second operand to divide
     *@return returns the divided result as a double */
    public static double division(double a, double b) {
    	return a/b;
    }
    /*calculates the factorial of a number
     * @param n takes in a number of the type double
     *@return returns factorial of double datatype */
    // Factorial calculation with progress display
    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        return factorialHelper(num, num);
    }

    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
        	//when num =1 the progress calculation is automatically 100%
        	System.out.println("\rCalculating factorial: 100%");
            return 1;
        }
        // Calculate progress and update progress bar
        //add 1 to the numerator so when originalNum = num it is the first step 
        //of progress
        int progress = (int) (((originalNum - num +1) / (double) originalNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%");
        return num * factorialHelper(originalNum, num - 1);
    }

 // Exponentiation
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Square root
    public static double sqrt(double number) {
        return Math.sqrt(number);
    }

    // Natural logarithm
    public static double log(double number) {
        return Math.log(number);
    }

    // Base-10 logarithm
    public static double log10(double number) {
        return Math.log10(number);
    }

    // Sine function
    public static double sin(double angleRadians) {
    	angleRadians = Math.toRadians(angleRadians);
        return Math.sin(angleRadians);
    }

    // Cosine function
    public static double cos(double angleRadians) {
    	angleRadians = Math.toRadians(angleRadians);
        return Math.cos(angleRadians);
    }

    // Tangent function
    public static double tan(double angleRadians) {
    	angleRadians = Math.toRadians(angleRadians);
        return Math.tan(angleRadians);
    }

    // Other Methods' placeholders
}
