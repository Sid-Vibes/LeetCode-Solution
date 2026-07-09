class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(
            (a,b)->{
                return Integer.compare(b,a);
            }
        );
        for(int i:stones){
            pq.offer(i);
        }
        while(pq.size()>1){
            int y = pq.poll();
            int x= pq.poll();
            if(y!=x){
               pq.offer(y-x);
            }
        }
        return pq.isEmpty()?0:pq.poll();
    }
}
