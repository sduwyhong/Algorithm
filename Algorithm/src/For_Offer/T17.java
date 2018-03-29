package For_Offer;
//输入一个矩阵，按照从外向里以顺时针的顺序依次扫印出每一个数字。
public class T17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = matrix[i].length * i + j + 1; 
			}
		}
		Clockwise(matrix);
	}

	private static void Clockwise(int[][] matrix) {
		//计数器（1、2、3、4）
		int counter = 1;
		//初始输出行下标
		int row = 0;
		//初始行输出个数
		int nrow = matrix[0].length;
		//初始输出列下标
		int col = matrix[0].length-1;
		//初始输出列个数
		int ncol = matrix.length -1 ;
		//结束条件：行输出个数与列输出个数都为0
		while(nrow > 0 || ncol > 0) {
			if(counter == 1) {
				//是初始状态还是循环次数>=1?
				int start = (col == matrix[0].length-1) ? 0 : col+1;
				//行固定，i为列起始下标，最大为起始下标+行输出个数-1
				for (int i = start; i < start + nrow; i++) {
					System.out.print(matrix[row][i]+" ");
				}
				//定义下一次列输出的初始下标
				col = (col == matrix[0].length-1) ? col : start + nrow - 1;
				counter++;
				//每输出一次，下一次输出个数-1
				nrow--;
			}else if(counter == 2) {
				for (int i = (row+1); i < row + 1 + ncol; i++) {
					System.out.print(matrix[i][col]+" ");
				}
				row = row + ncol;
				counter++;
				ncol--;
			}else if(counter == 3) {
				for (int i = col - 1; i >= col - nrow; i--) {
					System.out.print(matrix[row][i]+" ");
				}
				counter++;
				col = col - nrow;
				nrow--;
			}else{
				for (int i = row - 1; i >= row - ncol; i--) {
					System.out.print(matrix[i][col]+" ");
				}
				counter = 1;
				row = row - ncol;
				ncol--;
			}
		}
	}

}
