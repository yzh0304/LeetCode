public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
		

		Stack<Integer> stack = new Stack<Integer>();

		int value = 0;
		
		int length = tokens.length;
		// if the input array cotains only one item, just return its only item's valye
		if(length == 1){
			return Integer.parseInt(tokens[0]);
		}
		for (int i = 0; i < length; i++) {
			String str = tokens[i];
			// if one notation appeared，pop two values from the stack and evaluate them then push the evaluated value into the stack
			if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
				int one = stack.pop();
				int two = stack.pop();
				
				if (str.equals("+")) {
					value = one + two;
				} else if (str.equals("-")) {
					value = two - one;
				} else if (str.equals("*")) {
					value = two * one;
				} else {
					value = two / one;
				}
				
				stack.push(value);
				

			}else{
				// if it‘s a value push it into the stack
				stack.push(Integer.parseInt(str));
			}

		}
		
		return value;
	}
	
}
