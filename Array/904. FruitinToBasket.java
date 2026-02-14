class Solution {
    public int totalFruit(int[] fruits) {
        int low=0;
        int high=0;
        int res = Integer.MIN_VALUE;
        HashMap<Integer,Integer>map=new HashMap<>();
        while(high<fruits.length){
            map.put(fruits[high],map.getOrDefault(fruits[high],0)+1);
            while(map.size()>2){
                int count = map.get(fruits[low]);
                if(count==1){
                    map.remove(fruits[low]);
                }
                else{
                    map.put(fruits[low],count-1);
                }
                low++;
            }
              high++;
            int len = high-low+1;
             res = Math.max(res,len);
        }
        return res;
    }
}
