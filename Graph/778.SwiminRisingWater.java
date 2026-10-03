class Solution {
    public int swimInWater(int[][] grid) {
        int [] x = {1,-1,0,0};
        int [] y = {0,0,1,-1};
        int n = grid.length;
        int m = grid[0].length;
        int max =0;
        boolean [][] res = new boolean [n][m];
        PriorityQueue<Pair>queue=new PriorityQueue<>(
            (a,b)->Integer.compare(a.first,b.first)
        );

        queue.offer(new Pair(grid[0][0],0,0));
        res[0][0]=true;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int time = p.first;
            int r = p.second;
            int c = p.thrid;
            max = Math.max(max,time);
            res[r][c]=true;
             if(r==n-1 && c==m-1){
                break;
            }
            for(int k=0;k<4;k++){
                int row = x[k]+r;
                int col =  y[k]+c;
                
                if(!vaild(row,col,n,m)){
                    continue;
                }
                if(res[row][col]==false){
                queue.offer(new Pair(grid[row][col],row,col));
                }

            }
        }

        return max;
    }

    public boolean vaild(int row, int col , int n, int m){

        if(row<0 || row>=n || col<0 || col>=m){
            return false;
        }
        return true;
    }
}

class Pair{
    int first;
    int second;
    int thrid;

    Pair(int first, int second, int thrid){
        this.first=first;
        this.second=second;
        this.thrid=thrid;
    }
}
