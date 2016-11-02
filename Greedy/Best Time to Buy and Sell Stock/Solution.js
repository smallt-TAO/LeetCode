/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    if (prices.length < 2) return 0;
    var profit = 0; 
    var cur_min = prices[0];
        
    for (var i = 1; i < prices.length; i++) {
        profit = Math.max(profit, prices[i] - cur_min);
        cur_min = Math.min(cur_min, prices[i]);
    }
    return profit;
};