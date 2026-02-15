class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low=0;
        int res=0;
        HashMap<Character,Integer>map=new HashMap();
        for(int high=0;high<s.length();high++){
           char ch = s.charAt(high);
           map.put(ch, map.getOrDefault(ch,0)+1);
           int len = high-low+1;
           while(map.size()<len){
            int count = map.get(s.charAt(low));
              if(count==1){
                map.remove(s.charAt(low));
              }else{
              map.put(s.charAt(low),count-1);
              }
              low++;
              len = high-low+1;
           }
             res = Math.max(len,res);
        }
        return res;
    }
}
