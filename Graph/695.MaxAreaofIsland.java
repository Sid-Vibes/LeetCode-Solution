class Solution {
    int [] x = new int []{-1,1,0,0};
    int [] y = new int []{0,0,-1,1};
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        int ans = 0;
        boolean [][] visited = new boolean [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(valid(i,j,n,m) && visited[i][j]==false && grid[i][j]==1){
                     res = dfs(grid,visited,i,j,n,m,res);
                     ans =  Math.max(res,ans);
                }
            }
        }
           return ans;
    }
    public boolean valid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m){
             return false;
        }
        return true;
    }
   public int dfs(int [][] grid,boolean [][] visited,int i,int j, int n,int m,int res){
      visited[i][j]=true;
      res=1;
      for(int k=0;k<4;k++){
         int row = i + x[k];
         int col = j + y[k];
          if(valid(row,col,n,m) && !visited[row][col] && grid[row][col]==1){
              res +=  dfs(grid,visited,row,col,n,m,res);
          }
      }
       return res;
   }
}
