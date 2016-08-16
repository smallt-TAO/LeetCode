// LeetCode, Climbing Stairs
// Time complexity O(1)
public class Solution {
    public int climbStairs(int n) {
        if (n < 2)
            return 1;
        n++;
        double s = Math.pow(5, 0.5);
        double ans = (1 / s) * (Math.pow((1 + s)/2, n) - Math.pow((1 - s)/2, n));
        return (int)ans;
    }
}