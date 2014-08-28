//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this in place with constant memory.
//For example,
//Given input array A = [1,1,2],
//Your function should return length = 2, and A is now [1,2].

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] A) {
		int count = A.length;
		// 记录相同的数个数
		int sameCount = 1;
		int i = 0;
		// 这个参数用于记录上一次不同元素所放置的地方
		int lastPlace = 1;
		while (i < A.length) {
			// 开始一轮新的循环时候重置sameCount的值为1
			sameCount = 1;
			// 判断是否存在相同的元素
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] == A[i]) {
					// 相等一次将数量减去1
					count--;
					sameCount++;
				} else {
					// 碰到不相等的退出循环 
					// 对于数组也需要改变，将不同的元素向前移动 如[1,1,2,2,6,7,7,8] -> [1,2,6,7,8]
					A[lastPlace++] = A[j];
					break;
				}
			}
			i += sameCount;
		}

		return count;
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 3 };
		System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(a));
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
