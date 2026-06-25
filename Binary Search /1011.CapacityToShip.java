class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int sum=0;
        int res =-1;
        for(int w:weights){
            low=Math.max(low,w);
            sum+=w;
        }
        int high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(weights,days,mid)){
                high=mid-1;
                res=mid;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }

    public boolean check(int [] arr,int days,int guess){
          int sum=0;
          int k=1;
          for(int i=0;i<arr.length;i++){
             if(sum+arr[i]<=guess){
                sum=sum+arr[i];
             }else{
               sum=arr[i];
               k++;
               if(k>days){
                return false; 
               }
             }
          }
          return true;
    }
}
