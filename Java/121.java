/*
Traverse the array and keep the index minAt where prices[i] is lower than current min price at prices[minAt]. 
This is to say we now have a lower min price and profit should be computed from the new min price.
Keep a running max profit and return after traversal.
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int maxProfit = 0;
        int minAt = 0;
        
        for(int i=1; i<prices.length; i++){
            int profit = prices[i] - prices[minAt];
            if(profit < 0) minAt = i;
            else maxProfit = profit > maxProfit ? profit : maxProfit;
        }
        
        return maxProfit;
    }
}
