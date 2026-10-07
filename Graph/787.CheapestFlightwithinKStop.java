class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int [] res = new int [n];
        int Max = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res[i]=Max;
        }
        res[src]=0;

        for(int i=0;i<k+1;i++){
           int [] temp = res.clone();
            for(int j=0;j<flights.length;j++){

                int s = flights[j][0];
                int d = flights[j][1];
                int wt = flights[j][2];

                if(res[s]!=Max && temp[d]>res[s]+wt){
                    temp[d]=res[s]+wt;
                }

            }
            res=temp.clone();
        }
        
         if(res[dst]==Max){
             return -1;
         }
         return res[dst];
    }
}
