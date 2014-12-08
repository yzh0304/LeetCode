package leetcode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * */
public class BBT {

	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}

		int d = depth(root.left) - depth(root.right);
		if (d > 1 || d < -1) {
			return false;
		} else {
			// 递归的判断是否为平衡二叉树(子树也是平衡二叉树)
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	/**
	 * 递归求树的深度
	 * **/
	public int depth(TreeNode root) {

		if (root == null) {
			return 0;
		} else {
			// 左子树的深度
			int ld = depth(root.left);
			// 右子树的深度
			int rd = depth(root.right);

			return ld > rd ? ld + 1 : rd + 1;
		}
	}

	public static void main(String[] args) {
		BBT bbt = new BBT();
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);

		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		four.left = six;
		three.left = seven;

		System.out.println(bbt.isBalanced(root));
	}
}
