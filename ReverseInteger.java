package leetcode;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 
 * Example2: x = -123, return -321
 * 
 * Have you thought about this? Here are some good questions to ask before
 * coding. Bonus points for you if you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * 
 * For the purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 * */
public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(123));
		System.out.println(ri.reverse(-123));
		System.out.println(ri.reverse(10));
		System.out.println(ri.reverse(100));
		System.out.println(ri.reverse(0));
		System.out.println(ri.reverse(-2));
		System.out.println(ri.reverse(1000000003));
	}

	public int reverse(int x) {

		String str = String.valueOf(x);

		boolean isPositive = true;

		// 小于0的时候注意不要最前面的负号
		if (x < 0) {
			isPositive = false;
			// 0 - x即可以消除负号
			str = String.valueOf(0 - x);
		}

		int i = str.length() - 1;
		// 找到第一个非0的位置
		while (i >= 0) {
			if (str.charAt(i) != '0') {
				break;
			} else {
				i--;
			}
		}

		// 所有数字位都为0
		if (i == -1) {
			return 0;
		}

		// 将数字从后往前放入到字符数组
		char[] cs = new char[i + 1];
		int j = 0;

		while (i >= 0) {
			cs[j] = str.charAt(i);
			j++;
			i--;
		}

		// 获得字符数组对应的数字
		long reversedValue = Long.valueOf(new String(cs));

		// 值溢出了
		if (reversedValue > Integer.MAX_VALUE && isPositive) {
			return 0;
		} else if (-reversedValue < Integer.MIN_VALUE && !isPositive) {
			return 0;
		} else {
			return isPositive ? (int) reversedValue : (int) (-reversedValue);
		}

	}

}
