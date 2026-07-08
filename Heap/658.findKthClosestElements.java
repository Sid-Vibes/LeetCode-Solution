class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair>pq=new PriorityQueue<>(
            (a,b)->{
                if(a.dis!=b.dis){
                    return Integer.compare(a.dis, b.dis);
                }
                return Integer.compare(a.num, b.num);
            }
        );
        for(int i:arr){
            int dis = Math.abs(i-x);
            pq.offer(new Pair(dis,i));
        }
        int i=0;
        List<Integer>list=new ArrayList<>();
        while(k!=0){
            Pair p = pq.poll();
            list.add(p.num);
            k--;
        }
         Collections.sort(list);
         return list;
    }
}
class Pair{
    int dis;
    int num;
    Pair(int dis,int num){
        this.dis=dis;
        this.num=num;
    }
}
