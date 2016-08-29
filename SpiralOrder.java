import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

	public List<Integer> spiralOrder(int[][] matrix) {
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		int m = 0;
		int row = matrix.length;
		int column = 0;
		if (row > 0) {
			column = matrix[0].length;
		}
		List<Integer> result = new ArrayList<Integer>();

		int layer = (Math.min(row, column) - 1) / 2;
		for (i = 0; i <= layer; i++) {
			for (j = i; j <= (column - 1 - i); j++) {
				System.out.println(matrix[i][j]);
				result.add(matrix[i][j]);
			}

			for (k = i + 1; k < (row - 1 - i); k++) {
				System.out.println(matrix[k][column -i -1]);
				result.add(matrix[k][column -i -1]);
			}
			if (row > (2 * i + 1)) {
				for (l = (column -1 - i); l >= i; l--) {
					System.out.println(matrix[row - i -1][l]);
					result.add(matrix[row - i -1][l]);
				}
			}

			if (column > (2 * i + 1)) {
				for (m = (row - 2 -i); m > i; m--) {
					 System.out.println(matrix[m][i]);
					result.add(matrix[m][i]);
				}
			}

		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralOrder so = new SpiralOrder();
		// int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
		// int[][] matrix = {{1}};
		// int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13,
		// 14, 15, 16}};
		int[][] matrix = { { 1, 11 }, { 2, 12 }, { 3, 13 }, { 4, 14 },
				{ 5, 15 }, { 6, 16 }, { 7, 17 }, { 8, 18 }, { 9, 19 },
				{ 10, 20 } };
		// int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		List<Integer> result = so.spiralOrder(matrix);
		/**
		 * for(int i= 0; i < result.size(); i++){
		 * System.out.println(result.get(i)); }
		 */

	}

}
