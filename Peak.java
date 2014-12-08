package leetcode;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * 
 * */
public class Peak {

	public int findPeakElement(int[] num) {

		// 合适的元素只需要记录索引即可
		int peakElementIndex = -1;
		// 初始的元素为-∞
		long peakElement = Long.MIN_VALUE;

		long lower, higher;

		int i = 0;
		while (i < num.length) {
			// 每三个数字元组都是下面其中一种形式，其中对于形式1，2，4需要进行下面的转换后就可以进行形式统一了，-∞使用Long.MIN_VALUE表示
			// 形式1 -∞ x -∞
			// 形式2 -∞ x y
			// 形式3 x y z
			// 形式4 x y -∞
			if (i == 0) {
				lower = Long.MIN_VALUE;
			} else {
				lower = num[i - 1];
			}

			if (i == num.length - 1) {
				higher = Long.MIN_VALUE;
			} else {
				higher = num[i + 1];
			}

			// 分为四种情况
			// 情况1 x < y < z 此时循环向后推进 1 步
			// 情况2 x < y > z
			// 此时满足条件，记下y的下标和y的值，循环向后推进2步(因为要满足条件应该有y<z，这个不满足，所以不需要再继续判断)
			// 情况3 x > y < z 此时循环向后推进1步
			// 情况4 x > y > z 此时循环向后推进2步
			if (lower < num[i] && num[i] < higher) {
				i += 1;
			} else if (lower < num[i] && num[i] > higher) {
				// 下面是找出最大的peakElement
				if (num[i] > peakElement) {
					peakElement = num[i];
					peakElementIndex = i;
				}
				i += 2;
			} else if (lower > num[i] && num[i] < higher) {
				i += 1;
			} else if (lower > num[i] && num[i] > higher) {
				i += 2;
			}
		}

		return peakElementIndex;
	}

	public int findPeakElement2(int[] num) {
		for (int i = 1; i < num.length; i++) {
			if (num[i] < num[i - 1]) {
				// 到这里说明有 num[0] < num[1] < ... < num[i-2] < num[i-1]
				return i - 1;
			}
		}
		return num.length - 1;
	}

	public int findPeakElement3(int[] num) {
		int low = 0;
		int high = num.length - 1;

		while (low < high) {
			int mid1 = (high - low) / 2 + low;
			int mid2 = mid1 + 1;
			// 如对于 1 2 3 4 5 mid1 = 2 mid2 = 3
			// 满足if的条件，此时若4位置的元素大于3位置元素，那么最后就4位置的元素(最后一个)满足了
			// 若4位置的元素小于3位置元素，那么最后就是3位置元素满足了。故一定在右边
			if (num[mid1] < num[mid2]) {
				low = mid2; // 在右边
			} else {
				high = mid1; // 在左边
			}

		}

		return low;

	}

	public static void main(String[] args) {
		int[] a = { 1 };
		Peak peak = new Peak();
		System.out.println(peak.findPeakElement3(a));
	}
}
