class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            int val=nums[i];
            int v1 = min*nums[i];
            int v2 = max*nums[i];
            max = Math.max(val,Math.max(v1,v2));
            min = Math.min(val,Math.min(v1,v2));
            res = Math.max(res,max);
        }
        return res;
    }
}
