// LeetCode,Best Time to Buy and Sell Stock
// Time complexity O(n)
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() < 2) return 0;
        int profit = 0; 
        int cur_min = prices[0];
        
        for (int i = 1; i < prices.size(); i++) {
            profit = max(profit, prices[i] - cur_min);
            cur_min = min(cur_min, prices[i]);
        }
        return profit;
    }
};