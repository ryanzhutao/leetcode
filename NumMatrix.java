
public class NumMatrix {
	int[][] sum;
	public NumMatrix(int[][] matrix) {
        int nrow = matrix.length;
        int ncol = 0;
        if(nrow > 0){
        	ncol = matrix[0].length;
        }
        sum = new int[nrow][ncol];
        int i = 0;
        int j = 0;
        int rowsum = 0;
        for(i = 0; i < nrow; i++){
        	rowsum = 0;
        	for(j = 0; j < ncol; j++){
        		if(i==0){
        			sum[i][j] = rowsum + matrix[i][j];	
        		}else{
        			sum[i][j] = rowsum + matrix[i][j] + sum[i-1][j];
        		}
        		rowsum+=matrix[i][j];
        	}	
        }   
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        if(row1 == 0 && col1>=1){
        	result = sum[row2][col2] - sum[row2][col1-1];
        }else if(col1 == 0 && row1>=1){
        	result = sum[row2][col2] - sum[row1-1][col2];
        }else if(col1 == 0 && row1 == 0){
        	result = sum[row2][col2];
        }else{
        	result = sum[row2][col2] + sum[row1-1][col1-1] - sum[row1-1][col2] - sum[row2][col1-1];
        }
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
		NumMatrix num = new NumMatrix(matrix);
		System.out.println(num.sumRegion(2, 1, 4, 3));
	}

}
