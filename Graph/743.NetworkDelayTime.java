class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>>adjlist = new ArrayList<>();
        int [] result = new int [n];
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
            result[i]=Integer.MAX_VALUE;
        }

        for(int [] time:times){
            int src = time[0];
            int des = time[1];
            int weight = time[2];

            adjlist.get(src-1).add(new Pair(des-1,weight));
        }
        
        PriorityQueue<Pair>minheap=new PriorityQueue<>(
            (a,b)-> a.second-b.second
        );
        
        minheap.offer(new Pair(k-1,0));
        result[k-1]=0;
        
        while(!minheap.isEmpty()){
             
             Pair p = minheap.poll();
             int node = p.first;
             int wt = p.second;

             if(wt>result[node]){
                continue;
             }

             for(int j=0;j<adjlist.get(node).size();j++){
                 
                  int neigh = adjlist.get(node).get(j).first;
                  int d = adjlist.get(node).get(j).second;

                  if(d+wt<result[neigh]){
                      result[neigh]=wt+d;
                      minheap.offer(new Pair(neigh,wt+d));
                  }
             }

        }
         int max = 0;
         for(int i=0;i<n;i++){
             
             if(result[i]>=max){
                max=result[i];
             }

         }
         if(max==Integer.MAX_VALUE){
            return -1;
         }
         return max;
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
