class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            if(stack.isEmpty() || ch!=stack.peek()){
                stack.push(ch);
            }
            else{
                stack.pop();
            }
        }
          StringBuilder sb = new StringBuilder();
            for(char c : stack){
              sb.append(c);
            }
            
           String res = sb.reverse().toString();
            return res;
    }
}
