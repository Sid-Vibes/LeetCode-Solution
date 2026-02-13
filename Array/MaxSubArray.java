class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int low=0;
        int high=k-1;
        int sum=0;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        
        while(high<=arr.length-1){
            res=Math.max(sum,res);
            sum=sum-arr[low];
            low++;
            high++;
            if(high>=arr.length){
                break;
            }
            sum=sum+arr[high];
        }
        return res;
    }
}
