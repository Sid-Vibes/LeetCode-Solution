class Solution {
    public int longestPalindrome(String s) {
        HashMap <Character,Integer>map=new HashMap<>();
        int res = 0 ;
        boolean check = false;
        for(int i=0;i<s.length();i++){
           char c = s.charAt(i);
           map.put(c, map.getOrDefault(c, 0) + 1);
        }
       
        for (int value : map.values()) {
            if(value%2==0){
                res=res+value;  
            }
            else{
                 res +=value-1;
                check = true;
            }
         }
         if(!check){
            return res;
         }
         else{
           return  res+1;
         }

    }
}
