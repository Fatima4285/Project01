/**
 * <h1>Application.java</h1>
 * <p>
 * This class is designed to take user input, to calculate the answer for different operations
 * This is part of Lab 1 Exercise C, D, E
 * </p>
 * <p><b> Submission Date : </b> July 4, 2024 </p>
 * @author Mahdi Ansari
 * @author Fatima Asif
 * @version 1.0*/
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        /**@author Mahdi Ansari
         * Sample code that was provided in Lab01 instructions Part D
         *@version 1.1 some changes were made by Fatima Asif for completion of Lab01 part E */
        while (true) {
            System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial, permutation) or 'exit' to quit:");
            String operation = scanner.next();
            
            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }

            // For operations requiring two inputs
            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") && !operation.equalsIgnoreCase("log10") && !operation.equalsIgnoreCase("sin") && !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") && !operation.equalsIgnoreCase("factorial")) {
                System.out.print("Enter first number, for permutations this is the total number of items: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number, for permutations this is the number of items selected: ");
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
                    case "permutation":
                    	if(num1 < 0) {
                    		System.err.println("Total number of elements cannot be less than zero");
                    		break;
                    	}else if(num2 < 0 || num2 > 100) {
                    		System.err.println("The number of items to be selected cannot be negative or greater than 100");
                    		break;
                    	}else if(num2 > num1) {
                    		System.err.println("Number of selected items cannot exceed the total number of elements");
                    		break;
                    	}
                    	System.out.println("Result: " + permutation(num1, num2));
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
    
    /**adds two numbers
     * @param a first operand to add
     *@param b second operand to add
     *@return returns the added result as a double */
    public static double add(double a, double b) {
        return a + b;
    }
    /**subtracts two numbers
     * @param a first operand to subtract
     *@param b second operand to subtract
     *@return returns the subtracted result as a double */
    public static double subtraction(double a, double b) {
    	return a - b;
    }
    /**multiplies two numbers
     * @param a first operand to multiply
     *@param b second operand to multiply
     *@return returns the multiplied result as a double */
    public static double multiplication(double a, double b) {
    	return a*b;
    }
    /**divides two numbers
     * @param a first operand to divide
     * @param b second operand to divide
     *@return returns the divided result as a double */
    public static double division(double a, double b) {
    	return a/b;
    }
    /**calculates the factorial of a number
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
        //add 1 to the numerator so when originalNum = num it is the first step of progress and we dont start from 0%
        int progress = (int) (((originalNum - num +1) / (double) originalNum) * 100);// I got help from Chatgpt to add the 1, only for this line. 
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

    public static double permutation(double totalElements, double itemsSelected) {
    	//this is the base case, so when itemsSelected is 0 it returns 1
    	if(itemsSelected == 0) {
    		return 1;
    	}
    	//recursive call, we minus totalElemetns and itemsSelected by 1 until itemsSelected reaches 0 and we multiply 
    	//by the totalElements until we reach 0
    	return totalElements * permutation(totalElements -1, itemsSelected -1);
    }
    // Other Methods' placeholders
}
