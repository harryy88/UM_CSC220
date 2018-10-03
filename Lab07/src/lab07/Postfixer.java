package lab07;

import java.util.Stack;

public class Postfixer {
	
	
	public static void main(String[] args) {
		
        if (InfixEvaluator("10 + 2") != 12)
            System.err.println("test1 failed --> your answer should have been 12");
        
        if (InfixEvaluator("10 - 2") != 8)
            System.err.println("test1 failed --> your answer should have been 12");
        
        if (InfixEvaluator("100 * 2 + 12") != 212)
            System.err.println("test2 failed --> your answer should have been 212");
        
        if (InfixEvaluator("100 * ( 2 + 12 )") != 1400)
            System.err.println("test3 failed --> your answer should have been 1400");
        
        if (InfixEvaluator("100 * ( 2 + 12 ) / 14") != 100)
            System.err.println("test4 failed --> your answer should have been 100");
        
        System.out.println("Testing Done!!!");
	
	}
	
	public static double InfixEvaluator(String line) {
		
		StringSplitter data = new StringSplitter(line);
		
		Stack<String> operators = new Stack<String>();  //+, -, * 
		Stack<Double> operands = new Stack<Double>();	//0, 3, 4
		
		while ( data.hasNext()) {
			String str = data.next();
			if ( !isOperator(str) ) { operands.push(Double.parseDouble(str));	}
			else if (str.equals("(") ) 	{	operators.push(str); }
			else if (str.equals(")") ) {  //CONT 2.3.1
				while (!operators.peek().equals("(")) {
					double num1 = operands.pop(); 
					double num2 = operands.pop(); 
					String op = operators.pop(); 
					double result = evaluate(num1, num2, op);
					operands.push(result);
				}
				if (operators.peek().equals("(")) { operators.pop(); }	
			}
			else if (isOperator(str)) {
				while (!operators.isEmpty() && comparePrecedence(operators.peek(), str)) {
					double num1 = operands.pop(); 
					double num2 = operands.pop(); 
					String op = operators.pop(); 
					double result = evaluate(num1, num2, op);
					operands.push(result);
				}
				operators.push(str);
			}
		}
			
		while (!operators.empty()) {
			double num1 = operands.pop(); 
			double num2 = operands.pop(); 
			String op = operators.pop(); 
			double result = evaluate(num1, num2, op);
			operands.push(result);
		}
		
		
			System.out.println(operands.peek());
		
			return operands.pop(); 
		
		
		
	}
	
	public static int tokenPrecedence(String token) {
		switch ( token ) {
			case "^": return 4; 
			case "*": return 3; 
			case "+": return 2; 
			case "(": return 1; 
			default: return -1; 
		}
	}
	
	public static boolean comparePrecedence (String t1, String t2) {
		return ( tokenPrecedence(t1) >= tokenPrecedence(t2)); 
	}
	
	public static double evaluate(double num1, double num2, String op) {
		switch (op) {
			case "+": return num2 + num1;  
			case "-": return num2 - num1;  
			case "*": return num2 * num1;  
			case "/": return num2 / num1;  
			case "^": return Math.pow(num2, num1);  
			default: return -99999; 
		}
	}
	
	
	public static boolean isOperator(String token) {
		switch ( token ) {
			case "+":
			case "-":
			case "*":
			case "/":
			case "(":
			case ")":
			case "^": return true; 
			default: return false; 
		}
	}
	
	
}
