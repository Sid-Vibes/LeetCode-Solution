class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String>map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        int n = digits.length();
        int idx =0;
        StringBuilder diary = new StringBuilder();
        ArrayList<String> res = new ArrayList<>();
        pairs(digits,n,idx,diary,res,map);
        return res;

    }

    public void pairs(String s,int n,int idx, StringBuilder diary,ArrayList<String> res,HashMap<Character,String> map){
        if(n==idx){
            res.add(diary.toString());
            return;
        }
        String choice = map.get(s.charAt(idx));
        for(int j=0;j<choice.length();j++){
            diary.append(choice.charAt(j));
            pairs(s,n,idx+1,diary,res,map);
            diary.deleteCharAt(diary.length()-1);
        }

         return;
    }
}
