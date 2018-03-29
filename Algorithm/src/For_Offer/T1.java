package For_Offer;
//在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
public class T1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[10][10];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = i;
			for (int j = 1; j < matrix[i].length; j++) {
				matrix[i][j] = matrix[i][j-1] + 1;
			}
		}
		System.out.println(find(matrix, 18));
	}
	
	public static boolean find(int[][] matrix, int num) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int curRow = 0;
		int curCol = cols-1;
		
		while(curRow < rows && curCol > 0) {
			int topRightCorner = matrix[curRow][curCol];
			if(topRightCorner == num) {
				return true;
			} else if(topRightCorner > num) {
				curCol--;
			} else {
				curRow++;
			}
		}
		
		return false;
	}
}
