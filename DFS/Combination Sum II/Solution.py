class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()        
        self.ans, tmp, use = [], [], [0] * len(candidates)        
        self.dfs(candidates, target, 0, 0, tmp, use)        
        return self.ans
        
    def dfs(self, can, target, p, now, tmp, use):        
        if now == target:            
            self.ans.append(tmp[:])            
            return        
        for i in range(p, len(can)):            
            if now + can[i] <= target and (i == 0 or can[i] != can[i - 1] or use[i - 1] == 1):                
                tmp.append(can[i])
                use[i] = 1                
                self.dfs(can, target, i+1, now + can[i], tmp, use)                
                tmp.pop()                
                use[i] = 0