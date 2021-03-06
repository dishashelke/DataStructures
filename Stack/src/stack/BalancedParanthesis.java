package stack;

import java.util.Stack;

public class BalancedParanthesis {
	
	public static boolean isBalancedParanthesis(String expression) {
		Stack<Character> balanced = new Stack<Character>();
		for(int i = 0; i < expression.length(); i++){
			char current = expression.charAt(i);
			if(current == '(' || current == '[' || current == '{') {
				balanced.push(current);
			}
			else if(current == ')' || current ==']' || current =='}'){				
				if(balanced.isEmpty())
					return false;
				char top = balanced.pop();
				if((current==')' && top != '(') || (current == ']' && top != '[') || (current == '}' && top != '{'))
					return false;
			}
		}
		return balanced.isEmpty();
	}

	public static void main(String[] args) {		
		System.out.println("{[()} is balanced para: "+isBalancedParanthesis("{[()}"));
		System.out.println("{[()]} is balanced para: "+isBalancedParanthesis("{[()]}"));
	}
}
