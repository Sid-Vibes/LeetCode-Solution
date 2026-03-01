class Solution {
    public int maxArea(int[] height) {
        int res=0;
        int end=height.length-1;
        int start=0;
        while(start<end){
            int min = Math.min(height[start],height[end]);
            int len = end-start;
            int prod = len*min;
            res = Math.max(prod,res);
          if(height[start]>=height[end]){
             end--;
          }
          else{
              min = height[start];
              start++;
          }
          }
          return res;
        }
        
}
