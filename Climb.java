package leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * */
public class Climb {

	// 保存子问题的结果这样使得每个子问题只被求解一次，提高效率。初始结果值都为0
	private int[] results = new int[100];

	public int climbStairs(int n) {
		int res;

		// 若结果数组不为0，直接取值
		if (results[n] > 0) {
			return results[n];
		}

		if (n == 1) {
			res = 1;
		} else if (n == 2) {
			res = 2;
		} else {
			res = climbStairs(n - 1) + climbStairs(n - 2);
		}

		// 将子问题的结果保存
		results[n] = res;

		return res;
	}

	/**
	 * f(n) = f(n-1) + f(n-2)的迭代做法
	 * */
	public int climbStairs2(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int one_step_way = 1;
		int two_steps_way = 2;
		int all_ways = 0;

		for (int i = 2; i < n; i++) {
			all_ways = one_step_way + two_steps_way;
			one_step_way = two_steps_way;
			two_steps_way = all_ways;
		}

		return all_ways;
	}

	public static void main(String[] args) {
		Climb climb = new Climb();
		System.out.println(climb.climbStairs(45));
		System.out.println(climb.climbStairs2(45));
	}

}
