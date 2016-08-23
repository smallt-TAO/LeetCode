class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        # Matched: Finish matching all subject and pattern
        if not s and not p: return True
        
        # Not Matched: Pattern exhausted with non empty subject
        if s and not p: return False
            
        # Curr Pattern is star
        if len(p)>1 and p[1] == '*':
            
            # Shorten pattern if there's two consecutive star: identical or first one is '.'
            if len(p)>3 and p[3] == '*':
                if p[0] == p[2]: return self.isMatch(s, p[2:])
                if p[0] == '.': return self.isMatch(s, '.' + p[3:])
            
            # Match empty
            ret = self.isMatch(s, p[2:])
            
            
            if not s:
                pass
            elif s[0] == p[0]:
                ret = ret or self.isMatch(s[1:], p)
            elif p[0] == '.':
                ret = ret or self.isMatch(s[1:], p) or self.isMatch('', p[2:])
                
            return ret
        
        # Curr Pattern is non star
        elif s and (s[0] == p[0] or p[0] == '.'):
            return self.isMatch(s[1:], p[1:])
        
        # Subject is empty and rest of the patterns contain non star
        else: 
           return False
        
