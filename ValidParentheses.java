package au29;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are no
 * 
 * 借助与栈这种数据结构，对于字符串中的各个字符进行遍历操作，对于左(正)括号"(","["和"{"进行入栈操作
 * 若碰到右(反)括号，则首先判断栈是否为空。若空，说明左括号少于右括号，肯定不匹配，进行返回。
 * 若非空，进行出栈，然后判断括号是否匹配"[]","()","{}"，不匹配，进行返回。
 * 遍历结束，判断栈是否非空。若空，则是匹配的。若不空，说明左括号多余右括号。
 */
public class ValidParentheses {
	public boolean isValid(String s) {

		Stack<Character> parentheses = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(' || c == '{' || c == '[') {
				// 遇到正括号进入入栈操作
				parentheses.push(c);
			} else {
				// 说明反括号多于正括号
				if (parentheses.isEmpty()) {
					return false;
				}
				// 遇到反括号了，先进行出栈操作
				char temp = parentheses.pop();
				// 比较不等，那么肯定不是有效的括号了
				if (temp == '{' && c != '}' || temp == '(' && c != ')'
						|| temp == '[' && c != ']') {
					return false;
				}
			}
		}

		// 最后如果为非空，那么说明正括号多于反括号
		return parentheses.isEmpty();
	}

	public static void main(String[] args) {
		String p = "";
		System.out.println(new ValidParentheses().isValid(p));
	}
}
