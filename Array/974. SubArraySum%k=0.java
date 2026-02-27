class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum=0;
        int res=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int div=(sum%k+k)%k;
           
            if(map.containsKey(div)){
                res+=map.get(div);
            }
           
             map.put(div,map.getOrDefault(div,0)+1);
        }
         return res;
    }
}
