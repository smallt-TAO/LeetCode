class Solution(object):
    def isNumber(self, s):
        """
        :type s: str
        :rtype: bool
        """
        trans = [[-1,  0,  3,  1,  2, -1],     # next states for state 0
                 [-1,  8, -1,  1,  4,  5],     # next states for state 1
                 [-1, -1, -1,  4, -1, -1],     # next states for state 2
                 [-1, -1, -1,  1,  2, -1],     # next states for state 3
                 [-1,  8, -1,  4, -1,  5],     # next states for state 4
                 [-1, -1,  6,  7, -1, -1],     # next states for state 5
                 [-1, -1, -1,  7, -1, -1],     # next states for state 6
                 [-1,  8, -1,  7, -1, -1],     # next states for state 7
                 [-1,  8, -1, -1, -1, -1]]     # next states for state 8
        state = 0;
        for i in range(len(s)):
            inputType = 0;
            if s[i] == ' ':
                inputType = 1
            elif s[i] == '+' or s[i] == '-':  
                inputType = 2
            elif s[i] >= '0' and s[i] <= '9':
                inputType = 3
            elif s[i] == '.':
                inputType = 4
            elif s[i] == 'e' or s[i] == 'E':
                inputType = 5
            
            # Get next state from current state and input symbol
            state = trans[state][inputType]
            # Invalid input
            if state == -1:
                return False

        return state == 1 or state == 4 or state == 7 or state == 8
        
