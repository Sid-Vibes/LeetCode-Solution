class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            p.offer(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]>=p.peek()){
               p.poll();
               p.offer(nums[i]);
            }
        }
        return p.poll();
    }
}
