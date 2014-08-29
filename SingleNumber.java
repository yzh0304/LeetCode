package Au29;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * 由于只能是线性的时间O(n)同时常量的空间O(1)，所以元素只能扫描一遍并且只能申请常量空间
 * 
 * 思路：关于异或(^)运算如下法则
 * 
 * a^a = 0 a^b = b^a a^b^c = a^(b^c) = (a^b)^c a^b^a = a^(b^a) = (b^a)^a = b^a^a
 * = b
 * 
 * 所以对于数组A,将所有的元素进行异或后的结果就是那个单独的元素
 * */
public class SingleNumber {

	public int singleNumber(int[] A) {

		if (A.length == 0 || A == null) {
			return 0;
		}

		int value = A[0];
		for (int i = 1; i < A.length; i++) {
			// 将数组中每个元素与前一个元素进行异或运算
			value ^= A[i];
		}

		return value;
	}

	public static void main(String[] args) {
		SingleNumber sn = new SingleNumber();
		int[] A = {  };
		System.out.println(sn.singleNumber(A));
	}

}
