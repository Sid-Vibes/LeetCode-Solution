class Solution {
    public List<String> generateParenthesis(int n) {
        int open =0;
        int close=0;
        StringBuilder s = new StringBuilder();
        ArrayList<String> res = new ArrayList<>();
        combination(open,close,n,s,res);
        return res;
    }

    public void combination(int open,int close,int n,StringBuilder s, ArrayList<String>res){
         if(open==n && close==n){
             res.add(s.toString());
             return;
         }
         if(open<n){
            s.append("(");
            combination(open+1,close,n,s,res);
            s.deleteCharAt(s.length() - 1);
        }
        if(close<open){
            s.append(")");
            combination(open,close+1,n,s,res);
            s.deleteCharAt(s.length() - 1);
        }
        return;
    }
}
