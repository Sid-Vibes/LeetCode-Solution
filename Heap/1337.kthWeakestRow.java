class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>(
            (a,b)->{
                if(a.sol!=b.sol){
                    return Integer.compare(a.sol,b.sol);
                }
                 return Integer.compare(a.row,b.row);
            }
        );
        for(int i=0;i<mat.length;i++){
            int j=0;
            int count=0;
            while(j<mat[i].length && mat[i][j]==1){
                 count++;
                 j++;
            }
            pq.offer(new Pair(count,i));
        }
        int res [] = new int [k];
        int i=0;
        while(k>0){
            Pair p = pq.poll();
            res[i++]=p.row;
            k--;
        }
        return res;
    }
}

class Pair{
    int sol;
    int row;
    Pair(int sol,int row){
        this.sol=sol;
        this.row=row;
    }
}
