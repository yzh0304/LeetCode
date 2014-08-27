public classEvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
		StringBuffer sb = new StringBuffer(16);
		sb.append('(');

		Stack<Integer> stack = new Stack<Integer>();

		int value = 0;
		boolean hasLeft = false;
		int length = tokens.length;
		if(length == 1){
			return Integer.parseInt(tokens[0]);
		}
		for (int i = 0; i < length; i++) {
			String str = tokens[i];
			if (str.equals("+") || str.equals("-") || str.equals("*")
					|| str.equals("/")) {
				int one = stack.pop();
				int two = stack.pop();
				if (!hasLeft) {
					sb.append('(');
					hasLeft = true;
				}
				sb.append(two).append(str).append(one);
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
				stack.push(Integer.parseInt(str));
			}

		}
		
		if (hasLeft) {
			sb.append(')').append(')');
		}else{
			sb.append(')');
		}
		
		// System.out.println(sb);
		return value;
	}
	
}
