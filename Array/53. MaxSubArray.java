class Solution {
    public int maxSubArray(int[] nums) {
        int bestending = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            int curr = nums[i];
            bestending = bestending + nums[i];
            bestending = Math.max(bestending,curr);
            res=Math.max(bestending,res);
        }
        return res;
    }
}
