class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>>adjlist=new ArrayList<>();
            
        
        
        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<>());
        }
        
        for(int [] edge:edges){
             int sr = edge[0];
             int des = edge[1];
             int weight = edge[2];
             
             adjlist.get(sr).add(new Pair(des,weight));
             adjlist.get(des).add(new Pair(sr,weight));
             
        }
        
        PriorityQueue<Pair>minHeap=new PriorityQueue<>(
               (a,b)->a.second-b.second
              );
        ArrayList<Integer>dist = new ArrayList<>();
    
        for (int i = 0; i < V; i++){
             dist.add(Integer.MAX_VALUE);
            }
        
        minHeap.offer(new Pair(src,0));
        
         dist.set(src,0);
        
        while(!minHeap.isEmpty()){
            
            Pair p = minHeap.poll();
            
            int des = p.first;
            int wt = p.second;
            
            if(wt>dist.get(des)){
                continue;
            }
            
            for(int i=0;i<adjlist.get(des).size();i++){
                
                int neigh = adjlist.get(des).get(i).first;
                
                int w = adjlist.get(des).get(i).second;
                
                if(w+wt<dist.get(neigh)){
                    
                    dist.set(neigh,w+wt);
                    minHeap.offer(new Pair(neigh,w+wt));
                    
                }
                
            }
        }
        
        return dist;
        
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
