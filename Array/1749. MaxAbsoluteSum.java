class Solution {
    public int maxAbsoluteSum(int[] nums) {
       int res1 = nums[0];
       int res2 = nums[0];
       int minSub = nums[0];
       int maxSub = nums[0];
       int res = nums[0];
       for(int i=1;i<nums.length;i++){
           maxSub = Math.max(maxSub+nums[i],nums[i]);
           res1 = Math.max(res1,maxSub);
           minSub = Math.min(minSub+nums[i],nums[i]);
           res2 = Math.min(minSub,res2);
           int  bestend = Math.max(Math.abs(res1),Math.abs(res2));
           res = Math.max(bestend,res);
       }
         return Math.abs(res);
    }
}
