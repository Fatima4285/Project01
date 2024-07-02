
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
        if (args.length > 0) {
            // Process CLI arguments
        	String operation = args[0];
        	switchExpression(operation);
        } else {
            //No CLI arguments, ask for user input
            System.out.println("Enter operation (e.g., add, subtract, multiply, divide, factorial):");
            String operation = scanner.next();
            
            switchExpression(operation);
            
            }
        scanner.close();
    }
    
    public static void switchExpression(String operation) {
    	Scanner scanner = new Scanner(System.in);
    	//switch expression determines what operation to perform
        /*the user will type the operation they want, and all characters are converted
         * to lowercase before checking the expression*/
        switch (operation.toLowerCase()) {
        case "add":
            System.out.println("Enter the first operand:");
            double num1 = scanner.nextDouble();
            System.out.println("Enter the second operand:");
            double num2 = scanner.nextDouble();
            System.out.println("Result: " + add(num1, num2));
            break;
        case "factorial":
            System.out.println("Enter a number:");
            double number = scanner.nextDouble();
            System.out.println("Result: " + factorial(number));
            break;              
        case "subtract":
        	System.out.println("Enter the first operand: ");
        	double a = scanner.nextDouble();
        	System.out.println("Enter the second operand: ");
        	double b = scanner.nextDouble();
        	double difference = subtraction(a,b);
        	System.out.println("The difference is:"+ difference);
        	break;
        case "multiply":
        	System.out.println("Enter the first operand: ");
        	double mula = scanner.nextDouble();
        	System.out.println("Enter the second operand: ");
        	double mulb = scanner.nextDouble();
        	System.out.println("The multplication is:"+ multiplication(mula,mulb));
        	break;
        case "divide":
        	System.out.println("Enter the first operand: ");
        	double diva = scanner.nextDouble();
        	System.out.println("Enter the second operand: ");
        	double divb = scanner.nextDouble();
        	System.out.println("The division is:"+ division(diva,divb));
        	break;
        default:
        	System.out.println("You did not enter a correct operation");
        	break;
        // Further processing based on operation
        	
    }
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
    public static double factorial(double n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    // Other Methods' placeholders
}
