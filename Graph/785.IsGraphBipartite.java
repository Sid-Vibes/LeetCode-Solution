class Solution {
    boolean res  = true;
    public boolean isBipartite(int[][] graph) {
        int [] visited = new int [graph.length];
        for(int i=0;i<graph.length;i++){
            visited[i]=-1;
        }
        for(int i=0;i<graph.length;i++){
            if(visited[i]==-1){
            dfs(graph,i,0,visited);
            }
        }
        return res;
    }

    public void dfs(int [][] graph,int node , int color, int [] visited){
         visited[node]=color;

         for(int j=0;j<graph[node].length;j++){
             int neigh = graph[node][j];

             if(neigh!=-1 && visited[neigh]==color){
                  res = false;
                  return;
             }

             if(visited[neigh]==-1){
                dfs(graph,neigh,1-color,visited);
             }
         }
         return;
    }
}
