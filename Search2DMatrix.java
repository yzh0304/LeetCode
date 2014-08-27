package Au28;



//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
//For example,
//
//Consider the following matrix:
//
//[
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//Given target = 3, return true.
public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {

		int size = matrix.length;
		
		int row = findSearchWhichRow(matrix, 0, size - 1, target);
		
		boolean flag = false;
		for (int i = 0; i < matrix[row].length; i++) {
			if (matrix[row][i] == target) {
				flag = true;
				break;
			}
		}

		return flag;

	}

	private int findSearchWhichRow(int[][] matrix, int low, int high, int target) {
		
		if(high == 0){
			return low;
		}
		
		if (target >= matrix[high][0]) {
			return high;
		}

		if (target <= matrix[low][0]) {
			return low;
		}

		int middle = (low + high) / 2 ;

		while (low <= high) {
			
			
			
			if (matrix[middle][0] == target) {
				return middle;
			}

			if (matrix[middle][0] > target && matrix[middle - 1][0] <= target) {
				return middle - 1;
			}

			if (matrix[middle][0] > target) {
				System.out.println(low);
				System.out.println(middle);
				return findSearchWhichRow(matrix, low, middle - 1, target);
			}

			if (matrix[middle][0] < target && matrix[middle + 1][0] > target) {
				return middle;
			}

			if (matrix[middle][0] < target) {
				return findSearchWhichRow(matrix, middle + 1, high, target);
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		Search2DMatrix search2dMatrix = new Search2DMatrix();
		// int[][] a = {{-8,-6,-5,-4,-2,-1,-1,0,2,4,5,7,7,7,7,9,9,9,9,11},{12,14,15,16,18,20,20,20,21,21,22,23,23,25,25,25,26,27,29,30},{31,31,32,32,33,35,37,39,39,39,40,41,43,44,46,48,48,48,48,50},{52,54,55,57,57,58,58,60,62,64,65,65,65,67,69,71,71,73,74,74},{75,76,78,78,80,82,82,82,84,85,85,87,87,89,90,90,91,93,93,94},{96,98,100,102,104,105,107,109,111,113,113,115,115,117,119,119,120,122,122,124},{126,127,128,130,130,130,130,132,132,133,134,136,137,138,140,141,141,143,144,146},{148,150,151,152,154,156,157,158,159,161,161,162,162,164,164,165,167,168,169,169},{171,173,173,175,176,178,179,181,182,183,184,184,184,185,186,186,186,186,187,189},{190,192,192,193,195,196,197,197,198,198,198,198,198,199,201,203,204,206,208,208},{209,210,211,212,212,212,214,214,216,217,218,218,219,221,222,224,225,227,229,229},{230,230,230,231,233,233,234,235,237,237,238,238,240,240,242,242,244,246,246,247},{249,251,252,252,254,254,256,256,257,258,259,260,260,261,263,265,266,267,267,269},{271,273,273,274,274,274,276,276,276,278,279,280,280,280,282,284,284,286,286,287},{289,290,290,291,293,293,293,293,295,296,296,297,298,299,299,301,302,304,306,308},{309,310,311,311,312,312,314,315,317,319,320,322,323,324,324,324,326,328,329,331},{332,334,335,337,337,339,341,343,345,347,348,348,348,348,348,350,350,350,351,352},{353,355,355,356,357,358,360,361,361,361,362,364,364,364,365,366,368,370,370,372},{374,376,378,380,382,382,383,384,385,385,387,388,388,390,392,394,394,396,397,399},{400,402,403,403,405,405,407,409,411,411,413,414,415,417,418,419,419,419,421,422}};
		// int[][] a = {{1},{3}};
		int[][] a= {{-9,-7,-7,-5,-3}, {-1,0,1,3,3},{5,7,9,11,12},{13,14,15,16,18},{19,21,22,22,22}};
		System.out.println(search2dMatrix.searchMatrix(a, -4));
	}
}
