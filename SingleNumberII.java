package au29;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * */
public class SingleNumberII {

	public int singleNumber(int[] A) {
		int n = A.length;
		if (n == 0 || A == null) {
			return 0;
		}

		int[] bitnum = new int[32];
		int res = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < n; j++) {
				// 下面取出元素A[j]第i位的值(1或0)
				int v = (A[j] >> i) & 1;
				bitnum[i] += v;
			}
			// 对于每一位进行模3运算(同一个元素若出现3次,某一位的1出现次数也应该是3的倍数)
			// 进行右移或最后的值即为这个唯一的值
			res |= (bitnum[i] % 3) << i;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 3, 2, 2, 4, 2, 3, 3 };
		System.out.println(new SingleNumberII().singleNumber(A));
	}

}
