// LeetCode, Interleaving String
// Time complexity O(n^2)
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()) return false;

        int dp[][] = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++)
            if (s1.charAt(i - 1) == s3.charAt(i - 1))
                dp[i][0] = dp[i - 1][0] + 1;
            else break;

        for (int i = 1; i <= n; i++)
            if (s2.charAt(i - 1) == s3.charAt(i - 1))
                dp[0][i] = dp[0][i - 1]+1;
            else break;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    dp[i][j] = dp[i - 1][j] + 1;
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1))
                    dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i][j]);
            }
        }

        return dp[m][n] == s3.length();
    }
}