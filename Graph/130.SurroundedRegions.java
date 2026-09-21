class Solution {
    int [] x= new int []{-1,1,0,0};
    int [] y=new int []{0,0,-1,1};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
           int j=0;
            if(board[i][j]=='O'){
                dfs(board,i,j,n,m);
            }
        }
        for(int j=0;j<m;j++){
             int i=0;
            if(board[i][j]=='O'){
                dfs(board,i,j,n,m);
            }
        }
        for(int i=0;i<n;i++){
            int j=m-1;
            if(board[i][j]=='O'){
                dfs(board,i,j,n,m);
            }
        }
        for(int j=0;j<m;j++){
           int i=n-1;
            if(board[i][j]=='O'){
                dfs(board,i,j,n,m);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }

        return;
       
    }
    public boolean vaild(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        return true;
    }

    public void dfs(char [][] board,int i,int j,int n,int m){
        board[i][j]='#';
        
        for(int k=0;k<4;k++){
            int row = i + x[k];
            int col = j + y[k];
            if(vaild(row,col,n,m) && board[row][col]=='O'){
                dfs(board,row,col,n,m);
            }
        }
        return;
    }
}
