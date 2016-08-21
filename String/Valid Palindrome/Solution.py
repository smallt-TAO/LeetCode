class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        low = 0
        high = len(s)-1
        s = s.lower()
        while low < high:
            while s[low].isalnum() is False and low < high: 
                low += 1
            while s[high].isalnum() is False and low < high: 
                high -= 1
            # print(s[low],"  ", s[high])
            if s[low] != s[high]:
                return False
            low += 1
            high -= 1
        return True
    
