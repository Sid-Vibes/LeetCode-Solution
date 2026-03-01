class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
            }
        int start=0;
        int moving=1;
          while(moving<nums.length){
            if(nums[start]!=nums[moving]){
                 nums[start+1]=nums[moving];
                 start++;
                 moving++;
            }
            else{
             moving++;
            } 
        }
        return start+1;
    }
}
