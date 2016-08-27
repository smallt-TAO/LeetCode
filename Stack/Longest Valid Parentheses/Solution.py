class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = [0]
        for x in s:
            if x == '(':
                stack.append(1)
            elif stack[-1] & 1 == 1:
                a = stack.pop()
                stack[-1] += a + 1
            else:
                stack.append(0)
        
        return max(i for i in stack) // 2 * 2
    
