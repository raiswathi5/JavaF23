package lab1;

import java.util.Scanner;

public class Calculator {	
	// Name: Swathi Rai
	// Andrew id: swathir
	String expression; //stores the arithmetic expression input by the user 
	double result=0; //stores the result 

	//do not change this method
	public static void main(String[] args) {	
		Calculator c = new Calculator();
		c.getUserInput();
		c.calculate();
		System.out.printf( " = %f", c.result);
	}

	//get user input to initialize 'expression' variable
	public void getUserInput() {
		Scanner input = new Scanner(System.in); //scanner attached to keyboard
		System.out.println("Enter the expression\r\n"
				+ "with operands and operators\r\n"
				+ "separated by a space: ");
		
		expression = input.nextLine();
		input.close();
	}

	public void calculate() {
		Scanner tokens = new Scanner(expression);  //scanner attached to a string
		String op = "";
		tokens.useDelimiter("\\s+");
		while (tokens.hasNext()) {
			String expr = tokens.next(); //break by whitespaces
			if (expr.matches("[+-]?[0-9]+")) {
				
				if(op.equals("")) {
					result=Double.parseDouble(expr);
				} else if (op.equals("+")) {
					result+=Double.parseDouble(expr);
				} else if (op.equals("-")) {
					result-=Double.parseDouble(expr);
				} else if (op.equals("/")) {
					result/=Double.parseDouble(expr);
				} else if (op.equals("*")){
					result*=Double.parseDouble(expr);
				} 
			} else if (expr.matches("[-+/*]")){
				op = expr;
			}
		}
		tokens.close();
	}
}
