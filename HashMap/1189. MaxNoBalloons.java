class Solution {
    public int maxNumberOfBalloons(String s) {
        HashMap<Character,Integer>Needmap=new HashMap<>();
        HashMap<Character,Integer>Havemap=new HashMap<>();
        int res = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            Havemap.put(c,Havemap.getOrDefault(c,0)+1);
        }
        Needmap.put('b',1);
        Needmap.put('a',1);
        Needmap.put('l',2);
        Needmap.put('o',2);
        Needmap.put('n',1);
         
    for (Map.Entry<Character, Integer> entry : Needmap.entrySet()) {
          char key = entry.getKey();
          int value = entry.getValue();
          
         int available = Havemap.getOrDefault(key, 0);

         res = Math.min(res, available / value);
     }
      
       return res;

    }
}
