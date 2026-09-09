class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean [] visit = new boolean [adj.size()];
        int node = 0;
        ArrayList<Integer>res = new ArrayList<>();
        dfs(adj,node,visit,res);
        return res;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>>adj,int node , boolean [] visit,ArrayList<Integer>res){
        
        res.add(node);
        visit[node]=true;
        
        for(int i=0;i<adj.get(node).size();i++){
            int neigh = adj.get(node).get(i);
            if(visit[neigh]==false){
                dfs(adj,neigh,visit,res);
            }
        }
        
    }
}
