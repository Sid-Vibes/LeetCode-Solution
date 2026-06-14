class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int n=nums.length-1;
        int high=n;
        int res = -1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[n]){
                low=mid+1;
            }
            else{
                high=mid-1;
                res=mid;
            }
        }
        return nums[res];
    }
}
