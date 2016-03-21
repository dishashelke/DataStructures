package stack;

import java.util.Stack;

public class Operation {
	
	public static int postfix(String exp) {
		Stack<Integer> result = new Stack<Integer>();
		for (int i = 0; i < exp.length(); i++) {
			int op1, op2;
			char c = exp.charAt(i);
			if ((c == '+') || (c == '-') || (c == '*') || (c == '/')) {
				op2 = (Integer) (result.pop());
				op1 = (Integer) (result.pop());
				int value = performOperation(c, op1, op2);
				result.push(value);
			} else {
				result.push(new Integer(c - 48));
			}
		}
		return (Integer) result.pop();
	}

	// refer to evaluatePrefix
	/*@Deprecated
	public static int prefix(String exp) {
		Stack<Character> operands = new Stack<Character>();
		int opcount = 0;
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			operands.push(c);
			if ((c != '+') && (c != '-') && (c != '*') && (c != '/')) {
				opcount++;
			}
			if (opcount == 2) {
				int op2 = (int) operands.pop()-48;
				int op1 = (int) operands.pop()-48;
				char operator = (Character) operands.pop();

				int result = performOperation(operator, op1, op2);
				operands.push((char)result);
				opcount = 1;
			}
		}
		return (int) operands.pop();
	}*/

	/*
	 * Algorithm(Assume prefix expression is a valid expression): start
	 * traversing the expression from end of expression if current element in
	 * expression is operand(number) => push to stack if current element in
	 * expression is operator => pop two operands from stack perform operation
	 * push back the result on to stack
	 */
	public static int evaluatePrefix(String expression) {
		String operators = "+-/*";
		Stack<Integer> result = new Stack<Integer>();
		for (int i = expression.length() - 1; i >= 0; i--) {
			char current = expression.charAt(i);
			if (operators.contains(Character.toString(current))) {
				int firstOperand = result.pop();
				int secondOperand = result.pop();
				int value = performOperation(current, firstOperand,
						secondOperand);
				result.push(value);
			} else {
				result.push(Character.getNumericValue(current));
			}
		}
		return result.pop();
	}

	private static int performOperation(char operator, int firstOperand,
			int secondOperand) {
		if (operator == '+')
			return firstOperand + secondOperand;
		else if (operator == '-')
			return firstOperand - secondOperand;
		else if (operator == '/')
			return firstOperand / secondOperand;
		return firstOperand * secondOperand;
	}

	public static void main(String[] args) {
		String expression = "*+93/42";
		System.out.println("PREFIX:" + expression);
		System.out.println("Result : " + evaluatePrefix(expression));
		//System.out.println("Result : " + prefix(expression));
				
		String postfix_exp ="93+42/*";
		System.out.println("POSTFIX:"+ postfix_exp);		
		System.out.println("Result : "+postfix(postfix_exp));		
	}
}
