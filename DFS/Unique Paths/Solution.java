// LeetCode, Unique Paths
// Time complexity O(n^2)
public class Solution {
    public int uniquePaths(int m, int n) {
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[0] = 0;
        }
        f[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[j] = f[j - 1] + f[j];
            }
        }
        
        return f[n - 1];
    }
}