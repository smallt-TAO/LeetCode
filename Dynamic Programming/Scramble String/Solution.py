class Solution(object):
    def f(self, s1, s2, m):
        if (s1, s2) in m:
            return m[(s1, s2)]

        if len(s1) == 1:
            return s1 == s2
        elif not sorted(s1) == sorted(s2):
            return False

        for i in range(1, len(s1)):
            if self.f(s1[:i], s2[-i:], m) and self.f(s1[i:], s2[:-i], m) or \
                self.f(s1[:i], s2[:i], m) and self.f(s1[i:], s2[i:], m):
                m[(s1, s2)] = True
                return True
        m[(s1, s2)] = False
        return False
        
    def isScramble(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        m = {}
        return self.f(s1, s2, m)