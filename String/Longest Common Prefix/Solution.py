class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) < 1: 
            return ''
        elif len(strs) == 1: 
            return strs[0]
        
        s = strs[0]
        for i in xrange(1, len(strs)):
            r = min(len(s), len(strs[i]))
            while strs[i][: r] != s[: r]:
                r -= 1
            s = s[: r]
        return s
        
