clclass Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        Solution.res = []
        self.dfs(s, [])
        return Solution.res
        
    def dfs(self, s, stringlist):
        if len(s) is 0:
            Solution.res.append(stringlist)
        for i in range(1, len(s) + 1):
            if self.isPalindrome(s[:i]):
                self.dfs(s[i:], stringlist + [s[:i]])

    def isPalindrome(self, s):
        for i in range(len(s)):
            if s[i] != s[len(s) - 1 - i]:
                return False
        return True
                 