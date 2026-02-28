class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int res=0;
        int ones=0;
        int zero=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }
            else{
                ones++;
            }
            int diff = zero-ones;
            if(diff==0){
                res=Math.max(res,i+1);
            }
            if(map.containsKey(diff)){
                int idx=map.get(diff);
                int len=i-idx;
                res=Math.max(len,res);
            }
            else{
                 map.put(diff,i);
            }
        }
        return res;
    }
}
