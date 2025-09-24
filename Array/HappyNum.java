import java.util.HashSet;
import java.util.Scanner;
class ishappy{
    int sumOfproduct(int x){
        int n;
        int sum = 0;
          while(x!=0){
             n=x%10;
             sum = n*n+sum;
             x=x/10;
          }
          return sum;
    }
   boolean happy(int x){
      HashSet<Integer> seen = new HashSet<>();
      while(x!=1&& !seen.contains(x)){
            seen.add(x);
          x= sumOfproduct(x);
      } 
       if(x==1)
          {
         return  true;
        }     
        else{
            return false;
        }

}
}
public class HappyNum{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int x = kb.nextInt();
        ishappy obj = new ishappy();
        System.out.println(obj.happy(x));
    }
}