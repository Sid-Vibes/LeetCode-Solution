class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        ArrayList<ArrayList<Integer>>adjlist=new ArrayList<>();
        int [] visited = new int [V];
        int [] res = new int [V];
        Queue<Pair>queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<>());
        }
        
        for(int [] edge:edges){
            
            int s = edge[0];
            int des = edge[1];
            
            adjlist.get(s).add(des);
            adjlist.get(des).add(s);
            
        }
        
        queue.offer(new Pair(src,0));
        visited[src]=1;
        
        while(!queue.isEmpty()){
            
                Pair q = queue.poll();
                int node = q.first;
                int des = q.second;
                res[node]=des;
                
                for(int j=0;j<adjlist.get(node).size();j++){
                    
                    int neigh = adjlist.get(node).get(j);
                    
                    if(visited[neigh]!=1){
                        queue.offer(new Pair(neigh,des+1));
                        visited[neigh]=1;
                    }
                    
                }
                
            }
        
        if(res[dest]>0){
            return res[dest];
        } 
        return -1;
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
