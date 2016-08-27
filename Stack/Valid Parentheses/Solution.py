class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        dic={'(':')','[':']','{':'}'}
        stack=[]
        for ch in s:
            if ch in dic:
                stack.append(ch)
            else:
                if len(stack)==0: 
                    return False   
                elif dic[stack.pop()]!=ch: 
                # everytime meet a right side of the parenthesis, check if it matches to the stack
                    return False
        return not stack
