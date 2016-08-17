// LeetCode, Candy
// Time complexity O(n)
public class Solution {
    public int candy(int[] ratings) {
        int sum = 0;
        int n = ratings.length;
        int[] incre = new int[n];
        for (int i = 0; i < n; i++)
            incre[i] = 1;
        
        // from left to right. and reverse.
        for (int i = 0; i < n - 1; i ++) {
            if (ratings[i + 1] > ratings[i])
                incre[i + 1] = incre[i] + 1;
        }
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i])
                if (incre[i - 1] < incre[i] + 1)
                    incre[i - 1] = incre[i] + 1;
        }
        
        // accumulate the sum.
        for (int i = 0; i < n; i++)
            sum += incre[i];
        
        return sum;
    }
}