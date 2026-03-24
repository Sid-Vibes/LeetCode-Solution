class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer>stack = new ArrayDeque<>();
        int n = nums.length;
        int [] arr = new int [n];
        if(nums.length==0){
            return null;
        }
        for(int i=n-2;i>=0;i--){
           stack.push(nums[i]);
        }

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                 stack.pop();
            }
            if(stack.isEmpty()){
                arr[i]=-1;
            }
            else{
               arr[i]=stack.peek();
            }
            stack.push(nums[i]);

        }
        return arr;
    }
}      
