class Solution {
    boolean cycle = false;
    public boolean isCyclic(int V, int[][] edges) {
        // code here
         int [] visited = new int [V];
         int [] path = new int [V];
         ArrayList<ArrayList<Integer>>list = new ArrayList<>();
                       for(Integer i=0;i<V;i++){

                           list.add(new ArrayList<>());
                       }
                       for(int [] edge: edges){
                           int src = edge[0];
                           int des = edge[1];

                           list.get(src).add(des);
                   }
        for(int i=0;i<V;i++){
            
            if(visited[i]==0){
                dfs(list,i,path,visited);
            }
        }           
         
         return cycle;          

    }
           
    void dfs(ArrayList<ArrayList<Integer>>adjlist,int node,int [] path,int [] visited){
        
         visited[node]=1;
         path[node]=1;
         for(int j=0;j<adjlist.get(node).size();j++){
              
              int neigh = adjlist.get(node).get(j);
               
             if(visited[neigh]==1 && path[neigh]==1){
                 
                 cycle=true;
                  return;
             }
             
             if(visited[neigh]==0){
                 dfs(adjlist,neigh,path,visited);
             }
             
         }
            path[node]=0;
          
         
         return;
    }       
}

