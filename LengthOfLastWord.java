package au29;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, 
 * Given s = "Hello World", return 5.
 * Given s = "", return 0
 * Given s = " ", return 0
 * Given s = " a b ", return 1
 * Given s = "a   world", return 5
 */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		int length = s.length();

		int spaceIndex = -1;
		int lastSpaceIndex = -1;
		char lastItem = 0;
		int spaceCounts = 0;

		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);

			// 该次字符为空，且上次字符也为空，将空格数量加1，且设置空格索引
			if (c == ' ' && lastItem == ' ') {
				spaceCounts++;
				spaceIndex = i;
			} 
			// 该次字符为空，上次字符不为空, 将空格数量设置为1，且修改空格索引和上次空格索引
			else if (c == ' ' && lastItem != ' ') {
				spaceCounts = 1;
				lastSpaceIndex = spaceIndex;
				spaceIndex = i;
			}
			// 该次字符不为空，上次字符为空，将空格数量设置为0，且修改上次的空格索引
			else if (c != ' ' && lastItem == ' ') {
				spaceCounts = 0;
				lastSpaceIndex = spaceIndex;
			}

			// 将本次访问的字符保存起来
			lastItem = c;
		}

		// 若最后的字符为空，需要使用两个空格索引的差值和空格数量求
		if (length != 0 && s.charAt(length - 1) == ' ') {
			return spaceIndex - lastSpaceIndex - spaceCounts;
		} else {
			return length - spaceIndex - 1;

		}
	}
	
	public int lengthOfLastWord2(String s) {
		int lastLen = 0;
		int i = s.length() - 1;
		// 从后往前找到非空格字符和空格字符交界处
		while (i >= 0 && s.charAt(i) == ' ') {
			i--;
		}

		// 从上面的交界处往前寻找到第一个非空字符
		while (i >= 0 && s.charAt(i) != ' ') {
			lastLen++;
			i--;
		}
		return lastLen;
	}

	public int lengthOfLastWord3(String s) {
		// 使用spilt进行空格分割
		String[] items = s.split("\\s+");
		return items.length == 0 ? 0 : items[items.length - 1].length();
	}


	public static void main(String[] args) {
		String s = "abcdef";
		System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
	}
}
