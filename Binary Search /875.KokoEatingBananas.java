import java.util.Arrays;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low=1;
        int high= Arrays.stream(piles).max().getAsInt();
        int res=-1;
        while(low<=high){
            int guess = low+(high-low)/2;
            long hour = gethours(piles,n,guess);
            if(hour>h){
                low=guess+1;
            }
            else{
                res=guess;
                high=guess-1;
            }
        }
           return res;
    }

    public long gethours(int[] piles,int n, int speed){
        long h=0;
        for(int i=0;i<n;i++){
            h=h+piles[i]/speed;
            if(piles[i]%speed!=0){
                h++;
            }
        }
        return h;
    }
}
