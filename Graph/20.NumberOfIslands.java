class Solution {
    int [] x= new int []{-1,1,0,0};
    int [] y=new int []{0,0,-1,1};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        boolean [][] visit = new boolean [n][m];
        for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               visit[i][j] = false;
              }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visit[i][j]){
                    dfs(grid,n,m,i,j,visit);
                    res++;
                }
            }
        }
        return res;
    }
    public boolean valid(int i,int j,int m,int n){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        return true;
    }

    public void dfs(char[][] grid,int n,int m,int i,int j,boolean [][] visit){
        visit[i][j]=true;
        for(int k=0;k<4;k++){
            int row = i+x[k];
            int col = j+y[k];

            if(valid(row,col,m,n) && grid[row][col]=='1' && visit[row][col]==false){
                dfs(grid,n,m,row,col,visit);
            }
        }
        return;
    }
}
