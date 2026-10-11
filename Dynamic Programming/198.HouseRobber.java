class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int [][] dp = new int [n][2];

        for(int i=0;i<n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }

        return  house(nums,n,0,1,dp);

    }

    public int house(int [] nums,int n,int i,int free,int [][] dp){

        if(i==n){
            return 0;
        }

        if(dp[i][free]!=-1){
            return dp[i][free];
        }

        if(free==0){
            dp[i][free] = house(nums,n,i+1,1,dp);
            return dp[i][free];
        }
        int c1  = nums[i]+ house(nums,n,i+1,0,dp);
        int c2  = house(nums,n,i+1,1,dp);

        int res = Math.max(c1,c2);
        dp[i][free]= res;

        return res;
    }
}
