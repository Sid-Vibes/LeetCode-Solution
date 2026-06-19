class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int res =-1;
        if((long)m*k>bloomDay.length){
            return -1;
        }
        int low=0;
        int high=Arrays.stream(bloomDay).max().getAsInt();
        while(low<=high){
            int guess=low+(high-low)/2;
            int day = checkDays(bloomDay,m,k,guess);
            if(day==0){
               res=guess;
               high=guess-1;
            }
            else{
                low=guess+1;
            }
            
        }
        return res;
    }

    public int checkDays(int[] arr,int m,int k,int guess){
       int b=k;
       for(int i=0;i<arr.length;i++){
         if(arr[i]<=guess){
            b--;
            if(b==0){
                m--;
                b=k;
                if(m==0){
                    break;
                }
            }
         }
         else{
            b=k;
         }
       }
       return m;
    }
}
