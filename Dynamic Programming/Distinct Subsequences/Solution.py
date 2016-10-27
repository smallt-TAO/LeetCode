class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        dp = [[0 for j in range(len(t) + 1)] for i in range(len(s) + 1)]
        for i in range(len(s) + 1):
            dp[i][0] = 1
        for i in xrange(len(s)):
            for j in range(len(t)):
                if s[i] == t[j]:
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i][j]
                else:
                    dp[i + 1][j + 1] = dp[i][j + 1]
                    
        return dp[len(s)][len(t)]