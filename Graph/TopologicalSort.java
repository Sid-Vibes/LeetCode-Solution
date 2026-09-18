class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adjlist = new ArrayList<>();
        
        ArrayList<Integer>res= new ArrayList<>();
        
        ArrayList<Integer>indegree = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<>());
             indegree.add(0);
        }
        for(int [] edge: edges){
            int src = edge[0];
            int des = edge[1];
            
            adjlist.get(src).add(des);
            
            indegree.set(des, indegree.get(des) + 1);

        }
        Queue<Integer>queue = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indegree.get(i)==0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            
            for(int j=0;j<adjlist.get(node).size();j++){
                
                int neigh = adjlist.get(node).get(j);
                
                indegree.set(neigh, indegree.get(neigh) - 1);
                
                if(indegree.get(neigh)==0){
                    queue.add(neigh);
                }
            }
            
        }
        
        return res;
        
    }
}
