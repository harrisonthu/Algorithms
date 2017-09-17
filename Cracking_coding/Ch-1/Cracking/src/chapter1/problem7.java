package chapter1;

public class problem7 {

	
	public void setZeros(int[][] matrix){
		boolean[] row = new boolean [matrix.length];
		boolean[] col = new boolean [matrix[0].length];
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					row[i] = true;
					col[i] = true;
				}
			}
		}
		
		for(int i=0;i<matrix.length;i++){
			if(row[i]){
				nullifyRow(matrix, i);
			}
		}
		
		
		for(int j=0;j<matrix[0].length;j++){
			if(col[j]){
				nullifyCol(matrix, j);
			}
		}
	}
	
	
	public void nullifyRow(int[][] matrix, int row){
		for(int i=0;i<matrix.length;i++){
			matrix[row][i] = 0;
		}
	}
	
	public void nullifyCol(int[][] matrix, int col){
		for(int i=0;i<matrix[0].length;i++){
			matrix[i][col] = 0;
		}
	}
	
	
	public static void main(String[] args) {
		
		

		
		
		
		
		
	}

}
