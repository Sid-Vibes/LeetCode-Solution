class Solution {
    public int lengthOfLIS(int[] nums) {
        int [][] dp = new int [nums.length+1][nums.length+1];
        for(int i=0;i<nums.length+1;i++){
            for(int j=0;j<nums.length+1;j++){
                dp[i][j]=-1;
            }
        }

        return LIS(nums,nums.length,0,-1,dp);
    }

    public int LIS(int[] nums,int n,int i,int prev,int [][]dp){
        if(i==n){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
             return dp[i][prev+1];
        }
        if(prev==-1 || nums[i]>nums[prev]){
             int c1 = 1 + LIS(nums,n,i+1,i,dp);
             int c2 = LIS(nums,n,i+1,prev,dp);
             return dp[i][prev+1]=Math.max(c1,c2);
        }
           return dp[i][prev+1] = LIS(nums,n,i+1,prev,dp);
    }
}
