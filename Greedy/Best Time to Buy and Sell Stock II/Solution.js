/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    var sum = 0;
    var profit;
    for (var i = 1; i < prices.length; i++) {
        profit = prices[i] - prices[i - 1];
        if (profit > 0) sum += profit;
    }
    return sum;
};