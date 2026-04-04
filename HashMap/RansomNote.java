class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer>map=new HashMap<>();
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        for(int i=0;i<magazine.length();i++){
               char ch = magazine.charAt(i);
               map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int i=0;i<ransomNote.length();i++){
              char ch = ransomNote.charAt(i);
            if(map.containsKey(ch)){
               int count = map.get(ch) - 1;
                if (count == 0) {
                 map.remove(ch);
                } else {
                   map.put(ch, count);
                      }
              }
              else{
                 return false;
              }
        }
        return true;

    }
}
