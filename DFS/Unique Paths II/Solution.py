class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        o = obstacleGrid                                                                            
        m, n = len(o), len(o[0])
        ret = [0] * n 
        for i in xrange(n):
            if o[0][i]: 
                break
            ret[i] = 1
        for i in xrange(1, m):                                                               
            ret[0] *= (1 - o[i][0])
            for j in xrange(n - 1):                                         
                ret[j + 1] = (ret[j + 1] + ret[j]) * (1 - o[i][j + 1])          
        return ret[-1] 