class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) < 2:
            return 0
        profit, cur_min = 0, prices[0]
        for i in range(1, len(prices)):
            profit = max(profit, prices[i] - cur_min)
            cur_min = min(cur_min, prices[i])
        
        return profit
        