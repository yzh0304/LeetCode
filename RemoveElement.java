package au29;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * */
public class RemoveElement {
	public int removeElement(int[] A, int elem) {

		int count = A.length;
		int lastPlace = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				count--;
			} else {
				// 需要删除掉所有的elem元素,所以有时需要移动元素
				A[lastPlace++] = A[i];
			}
		}

		return count;

	}

	public static void main(String[] args) {

		int[] a = { 4, 5, 4, 6, 4, 7 };
		System.out.println(new RemoveElement().removeElement(a, 4));
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
