class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
       if(stations.length==0){
           int res = target-startFuel;
           if(res<=0){
              return 0;
           }
           return -1;
       }
       PriorityQueue<Integer>pq=new PriorityQueue<>(
         (a,b)->{
                return Integer.compare(b,a);
             }
       );
       int i=0;
       int count=0;
       int cover=startFuel;
       while(cover<target){
          while(i<stations.length && cover>=stations[i][0]){
            pq.offer(stations[i][1]);
            i++;
          } 
         if(pq.size()==0){
            return -1;
         }
         cover+=pq.poll();
          count++;
       }
     
       return count;

    }    
}
class Pair{
    int fuel;
    Pair(int fuel){
        this.fuel=fuel;
    }
}
