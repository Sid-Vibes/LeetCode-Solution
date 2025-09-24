class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            minPrice=Math.min(minPrice, prices[i]);
            maxProfit=Math.max(maxProfit, prices[i]-minPrice);
        }

        return maxProfit;
    }
}

public class buyandsell {
    public static void main(String[] args) {
        int [] arr = {2,4,1};
        Solution s = new Solution();
        System.out.println(s.maxProfit(arr));
    }
}