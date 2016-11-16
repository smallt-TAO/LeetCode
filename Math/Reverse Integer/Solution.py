class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x < 0:
            return -self.reverse(-x)
        n = x
        tmp = 0
        while n:
            digit = n % 10
            tmp = tmp * 10+digit
            n /=10
        return tmp if abs(tmp) < 2147483648 else 0