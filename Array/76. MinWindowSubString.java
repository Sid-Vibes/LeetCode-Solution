class Solution {
    public String minWindow(String s, String t) {
        int [] Str = new int [256];
        int [] pattern = new int [256];
        int low = 0;
        int res = 0;
        int start = 0;
        for(int i=0;i<t.length();i++){
           pattern[t.charAt(i)]++;
        }
        for(int high=0;high<s.length();high++){
          Str[s.charAt(high)]++;
          while(yes(Str,pattern)){
             int len = high-low+1;
             if(len<res || res==0){
                res=len;
                start=low;
             }
              Str[s.charAt(low)]--;
              low++;
          }
        }
         return  res==0 ? "" :s.substring(start,start+res);

    }
  public boolean yes (int [] Str,int [] pattern){
        for(int i=0;i<256;i++){
            if(Str[i]<pattern[i]){
               return false;
            }
        }
        return true;
    }
}
