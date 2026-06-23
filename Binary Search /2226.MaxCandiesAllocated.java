class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low=1;
        long sum=0;
        int high=0;
        int res =-1;
        for(int i=0;i<candies.length;i++){
           sum=sum+candies[i];
           high=Math.max(high,candies[i]);
        }
        if(sum<k){
            return 0;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            long child=0;
            for(int c:candies){
                child +=c/mid;
            }
            if(child>=k){
                low=mid+1;
                res=mid;
            }
            else{
                high=mid-1;
            }
        }
        return res;
    }
}
