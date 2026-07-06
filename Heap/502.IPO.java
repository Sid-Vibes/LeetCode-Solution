class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        ArrayList<int []>arr = new ArrayList<>();
        PriorityQueue<Integer>pq=new PriorityQueue<>(
            (a,b)->{
                return b-a;
            }
        );

       for(int i=0;i<capital.length;i++){
          arr.add(new int[]{capital[i],profits[i]});
           }
       arr.sort((a, b) -> Integer.compare(a[0], b[0]));
       int idx=0;
       while(k>0){
          while(idx<capital.length){
            if(w<arr.get(idx)[0]){
                break;
            }
            pq.offer(arr.get(idx)[1]);
            idx++;
          }
          if(pq.isEmpty()){
            return w;
          }
          w=w+pq.poll();
          k--;  
       }
       return w;
     }
}
