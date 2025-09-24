import java.util.Scanner;
class Solution {
    public int reverse(int x) {
        int sgin = 1;
        int t;
        String s = Integer.toString(x);
        if(s.charAt(0)=='-'){
            sgin = -1;
            String sub = s.substring(1);
            StringBuilder r = new StringBuilder(sub);
           t =  Integer.parseInt(r.reverse().toString());
        }
        else{
            StringBuilder r = new StringBuilder(s);
            t = Integer.parseInt(r.reverse().toString());
        }
        return sgin*t;
    }
    }
    


public class ReverseInteger {
    public static void main(String [] args){
        Scanner kb = new Scanner(System.in);
        try{
        int x = kb.nextInt();
        Solution k = new Solution();
        System.out.println(k.reverse(x));
        }
         catch(Exception r){
            System.out.println("0");
        }
        
        }
        }
    

