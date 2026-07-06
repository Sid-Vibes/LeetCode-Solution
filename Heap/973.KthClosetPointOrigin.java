class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>(
            (a,b)->{
                if(a.dis!=b.dis){
                    return b.dis-a.dis;
                }
                return a.indx-b.indx;
            }
        );
        for(int i=0;i<points.length;i++){
            int first = points[i][0];
            int seconds = points[i][1];
            int dis = first*first + seconds*seconds;
            pq.offer(new Pair(dis,i));
            if(pq.size()>k){
                pq.poll();
            }
        } 
        int i=0;
        int [][] arr = new int [k][2];
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int indx = p.indx;
            arr[i]=points[indx];
            i++;
        }
        return arr;
    } 
}
class Pair{
    int dis;
    int indx;
    Pair(int dis,int indx){
        this.dis=dis;
        this.indx=indx;
    }
}
