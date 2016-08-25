class Solution(object):
    def count(self, s):
        t = ''
        count = 0
        curr = '#'
        for c in s:
            if c != curr:
                if curr != '#':
                    t += str(count) + curr
                curr = c
                count = 1
            else:
                count += 1
        t += str(count) + curr
        return t
        
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        s = '1'
        for i in range(n - 1):
            s = self.count(s)
        return s
