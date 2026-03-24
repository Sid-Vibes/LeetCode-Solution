class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer>stack = new ArrayDeque<>();
        int n = temperatures.length;
        if(n==0){
            return new int[0];
        }
        int [] arr = new int [n];
        arr[n-1]=0;
        stack.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                arr[i]=0;
            }
            else{
                arr[i]=stack.peek()-i;
            }
            stack.push(i);

        }
        return arr;
    }
}
