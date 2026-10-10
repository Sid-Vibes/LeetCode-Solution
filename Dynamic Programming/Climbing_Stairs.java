class Solution {
    HashMap<Integer,Integer>dp=new HashMap<>();

    public int climbStairs(int n) {
         return Staris(0,n);
    }

    public int Staris(int i, int n){
         if(i==n){
            return 1;
         }
         if(i>n){
            return 0;
         }
         if(dp.containsKey(i)){
             return dp.get(i);
        }
        int a1 = Staris(i+1,n);
        int a2 = Staris(i+2,n);
        int ans = a1+a2;
        dp.put(i,ans);
        return ans;
    }
}
