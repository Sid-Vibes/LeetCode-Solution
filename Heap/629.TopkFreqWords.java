class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>map=new HashMap<>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>(
             (a,b)->{
                if(a.first!=b.first)
                  return a.first-b.first;
                return b.second.compareTo(a.second);
             }
        );
        for(String str :map.keySet()){
            int num = map.get(str);
            pq.offer(new Pair(num,str));
            if(pq.size()>k){
                pq.poll();
            }
        }
        LinkedList<String>res=new LinkedList<>();
        for(int i=0;i<k;i++){
            Pair p = pq.poll();
            res.addFirst(p.second);
        }

        return res; 

    }
}
class Pair{
    int first;
    String second;
    Pair(int k , String s){
        this.first=k;
        this.second=s;
    }
}
