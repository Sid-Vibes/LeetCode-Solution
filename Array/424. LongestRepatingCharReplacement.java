class Solution {
    public int characterReplacement(String s, int k) {
        int low=0;
        int res=0;
        int [] arr = new int [26]; 
        for(int high=0;high<s.length();high++){
            arr[s.charAt(high)-65]++;
            int len = high-low+1;
            int max = maxNo(arr);
            int diff = len-max;
            while(diff>k){
                arr[s.charAt(low)-65]--;
                low++;
                len = high-low+1;
                max = maxNo(arr);
                diff = len-max;
            }
            len = high-low+1;
            res = Math.max(res,len);
        }
        return res;

    }
    public int maxNo(int [] arr){
        int max = 0;
        for(int i=0;i<arr.length;i++){
          if(arr[i]>max){
            max=arr[i];
          }
        }
        return max;
    }
}
