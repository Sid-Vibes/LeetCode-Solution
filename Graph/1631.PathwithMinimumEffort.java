class Solution {
    public int minimumEffortPath(int[][] heights) {
        int [] x = {-1,1,0,0};
        int [] y = {0,0,1,-1};
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Pair>queue=new PriorityQueue<>(
            (a,b)->Integer.compare(a.weight,b.weight)
        );
        int [][] res = new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j]=Integer.MAX_VALUE;
            }
        }
        res[0][0]=0;
        queue.offer(new Pair(0,0,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int dis = p.weight;
            int row = p.first;
            int col = p.second;

            if(dis<res[0][0]){
                continue;
            }
            for(int k=0;k<4;k++){
                int r = row+x[k];
                int c = col+y[k];

                if(!vaild(r,c,n,m)){
                     continue;
                }

                int diff = Math.abs(heights[row][col]-heights[r][c]);
                int newWt = Math.max(diff,dis);

                if(newWt<res[r][c]){
                    res[r][c]=newWt;
                    queue.offer(new Pair(newWt,r,c));
                }
            }
        }
           return res[n-1][m-1];
    }

    public boolean vaild(int row,int col,int n,int m){
        if(row<0 || row>=n || col<0 || col>=m){
            return false;
        }
        return true;
    }
}
class Pair{
    int weight;
    int first;
    int second;

    Pair(int weight,int first,int second){
        this.weight=weight;
        this.first=first;
        this.second=second;
    }
}
