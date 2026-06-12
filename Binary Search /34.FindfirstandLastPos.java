class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int [] {-1,-1};
        }
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                int start = mid;
                while(start>=0 && target==nums[start]){
                    start--;
                }
                int end = mid;
                while(end<nums.length && target==nums[end]){
                    end++;
                }
                return new int []{start+1,end-1};
            }
            if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return new int []{-1,-1};
    }
}
