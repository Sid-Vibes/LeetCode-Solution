class Solution {
    int [] dx = new int []{-1,1,0,0};
    int [] dy = new int []{0,0,-1,1};
    public boolean valid(int n,int m,int i,int j){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        return true;
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair>q = new LinkedList<>();
        int times =0;
        int fresh = 0;
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(grid[i][j]==2){
                   q.add(new Pair(i,j));
                   grid[i][j]=-2;
                }
                else{
                    if(grid[i][j]==1){
                        fresh++;
                    }
                }
            }
        }
        while(!q.isEmpty() && fresh>0){
            int size = q.size();
            times++;
            while(size>0){
                Pair x = q.poll();
                int x1 = x.first;
                int y1 = x.second;
                size--;
                for(int k=0;k<4;k++){
                    int i1 = dx[k]+x1;
                    int j1 = dy[k]+y1;
                    if(valid(n,m,i1,j1) && grid[i1][j1]==1){
                        q.add(new Pair(i1,j1));
                        fresh--;
                        grid[i1][j1]=-2;
                    }
                }
            }
        }
                if(fresh>0){
                    return -1;
                }
                return times;

    }
}    
class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
