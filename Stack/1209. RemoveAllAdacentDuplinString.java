class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();
        int n = s.length();
        for(int i=0;i<n;i++){
             Pair top = stack.peek();
            if(stack.isEmpty()){
               stack.push(new Pair(1,s.charAt(i)));
            }else if(top.str==s.charAt(i) && top.count<k-1){
                int count=top.count;
                Pair pop = stack.pop();
                stack.push(new Pair(count+1,s.charAt(i)));
            } else if(!stack.isEmpty() && top.str!=s.charAt(i)){
                stack.push(new Pair(1,s.charAt(i)));
            } else{
              stack.pop();
            }
        }
          
        StringBuilder s1 = new StringBuilder();
        while(!stack.isEmpty()){
            Pair res = stack.removeLast();
            while(res.count>0){
                s1.append(res.str);
                res.count--;
             }
         }
       return s1.toString();
    }
}

class Pair {
    int count;
    char str;

    Pair(int count, char str) {
        this.count = count;
        this.str = str;
    }
}
