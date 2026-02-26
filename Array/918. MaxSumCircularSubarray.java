class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int middle = nums[0];
        int edges = nums[0];
        int max = nums[0];
        int min = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
             int n=nums[i];
             sum=sum+n;
             middle = Math.max(middle+n,n);
             max = Math.max(middle,max);
             edges = Math.min(edges+n,n);
             min = Math.min(edges,min);
        }
          if(sum==min) return max;

         return Math.max(max,sum-min);
    }   
}978
