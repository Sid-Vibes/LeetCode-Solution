class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[row-1][col-1];
        int ans =0;
        while(low<=high){
        int guess = low+(high-low)/2;
        if(SearchOn(matrix,guess,k)){
           ans=guess;
           high=guess-1;
        }
        else{
            low=guess+1;
        }

    }
    return ans;
       
}

    public boolean SearchOn(int[][] matrix,int guess,int k){
        int row = matrix.length-1;
        int col = 0;
        int count = 0;
        while(row>=0&&col<matrix[0].length){
        int res = matrix[row][col];
        if(res>guess){
           row--;
        }
        else{
            col++;
            count += row+1;
        }
        
         }
        if(count>=k){
           return true;
        } 
        return false;
     }
}
