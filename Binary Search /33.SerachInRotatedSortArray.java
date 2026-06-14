class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int n=nums.length-1;
        int high=n;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>nums[n]){
                if(nums[mid]<target){
                    low=mid+1;
                }
                else{
                    if(target<nums[0]){
                        low=mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
            }else{
                if(nums[mid]>target){
                    high=mid-1;
                }
                else{
                    if(target>nums[n]){
                        high=mid-1;
                    }
                    else{
                        low=mid+1;
                    }
                }
            }
        }
        return -1;
    }
}
