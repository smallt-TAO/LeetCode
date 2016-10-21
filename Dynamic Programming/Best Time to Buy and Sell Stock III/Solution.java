// LeetCode, Best Time to Buy and Sell Stock III
// Time complexity O(n)
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int ans = 0;
        int n = prices.length;

        int opt[] = new int[n];
        opt[0] = 0;
        int low = prices[0];
        int curAns = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < low) low = prices[i];
            else if (curAns < prices[i] - low) curAns = prices[i] - low;
            opt[i] = curAns;
        }

        int optReverse[] = new int[n];
        optReverse[n - 1] = 0;
        curAns = 0;
        int high = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > high) high = prices[i];
            else if (curAns < high - prices[i]) curAns = high - prices[i];
            optReverse[i] = curAns;
        }

        for (int i = 0; i < n; i++) {
            int tmp = opt[i] + optReverse[i];
            if(ans < tmp) ans = tmp;
        }
        return ans;
    }
}