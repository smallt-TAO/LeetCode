class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        if not s or not wordDict or not self.breakable(s, wordDict): return []
        word_len, start = max(map(len, wordDict)), min(map(len, wordDict)) - 1
        dp = [[] for i in xrange(len(s)+1)]
        dp[0].append('')
        for i in xrange(start, len(s)):
            for j in xrange(start+1, 1+min(word_len, i+1)):
                if s[i-j+1:i+1] in wordDict:
                    if i+1-j != 0 and dp[i+1-j]:
                        dp[i+1] += [each + ' ' + s[i-j+1:i+1] for each in dp[i+1-j]]
                    elif i+1-j == 0:
                        dp[i+1].append(s[i-j+1:i+1])
        # print dp
        return dp[-1]
    def breakable(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: bool
        """
        if not s or not wordDict: return False
        word_len, start = max(map(len, wordDict)), min(map(len, wordDict)) - 1
        dp = [0 for i in xrange(len(s)+1)]
        dp[0] = 1
        for i in xrange(start, len(s)):
            for j in xrange(start+1, 1+min(word_len, i+1)):
                # print s[i-j+1:i+1]
                if s[i-j+1:i+1] in wordDict:
                    dp[i+1] += dp[i+1-j]
                    if dp[i+1] > 0: break
            # print dp
        # print dp
        return dp[-1] > 0