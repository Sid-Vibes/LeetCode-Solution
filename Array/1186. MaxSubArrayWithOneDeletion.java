class Solution {
    public int maximumSum(int[] arr) {
        int no_del = arr[0];
        int one_del = arr[0];
        int res = arr[0];
        for(int i=1;i<arr.length;i++){
            int prv_nodel = no_del;
            int oneprv_del = one_del;
            no_del = Math.max(prv_nodel+arr[i],arr[i]);
            int v = oneprv_del+arr[i];
             one_del=Math.max(v,prv_nodel);
             int ans = Math.max(one_del,no_del);
             res = Math.max(res,ans);
            
        }
         return res;
     }
}
