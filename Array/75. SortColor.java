class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                int k ; 
                k=nums[mid];
                nums[mid]=nums[low];
                nums[low]=k;
                low++;
                mid++;
            }
            else if (nums[mid]==1){
                mid++;
            }
            else{
                int k = nums[mid];
                nums[mid]=nums[high];
                nums[high]=k;
                high--;
            }
        }

    }

}
