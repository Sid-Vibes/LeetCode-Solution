class Solution {
    public int longestOnes(int[] nums, int k) {
        int low=0;
        int res=0;
        int sum=0;
        for(int high=0;high<nums.length;high++){
           sum=nums[high]+sum;
           int len = high-low+1;
           int diff = len-sum;
           while(diff>k){
            sum=sum-nums[low];
            low++;
            len = high-low+1;
            diff = len-sum;
           }
           res = Math.max(len,res);
        }
        return res;
    }
}
