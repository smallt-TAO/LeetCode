class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices or len(prices) < 2:
            return 0
        # init
        forward = [0] * len(prices)
        backward = [0] * len(prices)
        curMin = prices[0]
        for i in range(1, len(prices)):
            forward[i] = max(forward[i - 1], prices[i] - curMin)
            curMin = min(curMin, prices[i])
        curMax = prices[-1]
        for i in range(len(prices) - 2, -1, -1):
            backward[i] = max(backward[i + 1], curMax - prices[i])
            curMax = max(curMax, prices[i])
            
        profits = [i + j for i, j in zip(forward, backward)]
        return max(profits)