// LeetCode, Interleaving String
// Time complexity O(n^2)
class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int m = s1.size(), n = s2.size();
		if (m + n != s3.size())
			return false;
		bool dp[m+1][n+1];
		dp[0][0] = true;
		
		//≥ı ºªØ±ﬂΩÁ.
		for (int i = 0; i < n; ++i)
			dp[0][i+1] = dp[0][i] && s2[i] == s3[i];
		for (int i = 0; i < m; ++i)
			dp[i+1][0] = dp[i][0] && s1[i] == s3[i];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				dp[i+1][j+1] = (dp[i][j+1] && s1[i] == s3[i+j+1]) | (dp[i+1][j] && s2[j] == s3[i+j+1]);
		return dp[m][n];
    }
};