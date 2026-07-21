class Solution {
    public List<List<String>> partition(String s) {
        List<String>diary=new ArrayList<>();
        List<List<String>>res=new ArrayList<>();
        palindrome(s,diary,res);
        return res;
    }

    public void palindrome(String s, List<String>diary,List<List<String>>res){
        
        if(s.length()==0){
            res.add(new ArrayList<String>(diary));
            return;
        }
        for(int i=0;i<s.length();i++){
            String str = s.substring(0,i+1);
            if(ispalindrome(str)){
                diary.add(str);
                palindrome(s.substring(i+1),diary,res);
                diary.remove(diary.size()-1);
            }
        }
        return;
    }

    public boolean ispalindrome(String str){
         String rev="";
        for (int i = str.length() - 1; i >= 0; i--) {
              rev = rev + str.charAt(i);
        }
        return str.equals(rev);
    }
}
