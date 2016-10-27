class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: bool
        """
        d, dp = {w:True for w in wordDict}, [True]
        for i in range(len(s)):
            dp.append(any(dp[j] and s[j:i+1] in d for j in range(i+1)))
        return dp[-1]
        