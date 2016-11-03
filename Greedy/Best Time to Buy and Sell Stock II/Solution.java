// LeetCode, Best Time to Buy and Sell Stock II
// Time complexity O(n) 
public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int profit;
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - prices[i - 1];
            if (profit > 0) sum += profit;
        }
        return sum;
    }
}