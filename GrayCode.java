package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0 01 - 1 11 - 3 10 - 2 Note: For a given n, a gray code sequence is not
 * uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the
 * above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
 * */
public class GrayCode {

	public static void main(String[] args) {

		GrayCode gc = new GrayCode();
		List<Integer> gcs = gc.grayCode(1);
		for (Integer i : gcs) {
			System.out.println(i);
		}
	}

	public List<Integer> grayCode(int n) {

		String[] graysStrings = grayCodeHelper(n);

		List<Integer> grayInts = new ArrayList<Integer>(graysStrings.length);
		for (int i = 0; i < graysStrings.length; i++) {
			grayInts.add(Integer.valueOf(graysStrings[i], 2));
		}

		return grayInts;

	}

	public String[] grayCodeHelper(int n) {

		int num = n > 0 ? 2 << (n - 1) : 1;
		String[] grays = new String[num];

		if (n == 0) {
			// 0阶格雷码为"0"
			grays[0] = "0";
		} else if (n == 1) {
			// 1阶格雷码为"0"和"1"
			grays[0] = "0";
			grays[1] = "1";

		} else {

			// 先获得第n-1阶的格雷码，获得之后*[0,1]即得到第n阶的格雷码
			String[] n_minus_1 = grayCodeHelper(n - 1);
			// 使用n-1阶的格雷码+前置的"0"
			for (int j = 0; j < n_minus_1.length; j++) {
				grays[j] = "0" + n_minus_1[j];
			}

			// 使用n-1阶的格雷码+前置的"1",注意从后向前的顺序
			for (int j = 0; j < n_minus_1.length; j++) {
				grays[n_minus_1.length + j] = "1"
						+ n_minus_1[n_minus_1.length - j - 1];
			}

		}

		return grays;

	}

}
