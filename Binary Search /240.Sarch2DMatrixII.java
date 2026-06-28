class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
           return false;
        }
        int row = matrix.length-1;
        int col = 0;
        while(row>=0 && col<matrix[0].length){
        int res = matrix[row][col];
        if(res==target){
            return true;
        }
        else if(res>target){
            row--;
        }
        else{
            col++;
        }
    }
     return false;
    }
}
