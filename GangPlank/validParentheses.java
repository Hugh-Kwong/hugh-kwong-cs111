public class validParentheses {
	public static void main(String[] args) {

	}
	
	public boolean isBalanced(String input) {

		char[] parentheses = input.toCharArray();
		Stack<Character> stack = new Stack<>();
		
		for (//YOUR CODE HERE) { (loop through all the characters)
			if (//YOUR CODE HERE) {
				stack.push(parenthesis);
			} else {
				if (//YOUR CODE HERE) {
					return false;
				}
				
				char firstItem = stack.pop();
				
				if (parenthesis == ')' && firstItem != //YOUR CODE HERE
						|| 
						|| ) {
					return false;
				}
			}
		}
		
		return true;
	}

}