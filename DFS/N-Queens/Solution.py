class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        if not n:
            return [[]]
        self.res = []
        self.n = n
        for i in range(n):
            select = [True for j in range(n)]
            select[i] = False
            self.dfs(select, i, [i])
        return self.res
        
    def dfs(self, select, prev, valuelist):
        # print valuelist
        if len(valuelist) == self.n:
            temp = []
            for i in range(self.n):
                row = ['.' for j in range(self.n)]
                pos = valuelist[i]
                row[pos] = 'Q'
                temp.append("".join(row))
            self.res.append(temp)
            return 
        for i in range(self.n):
            if select[i] and self.diagnol(valuelist, i):
                newlist = select[:]
                newlist[i] = False
                self.dfs(newlist, i, valuelist + [i])
                
    def diagnol(self, valuelist, pos):
        length = len(valuelist)
        l = length
        for x in valuelist:
            if pos == x - l or pos == x + l:
                return False
            l -= 1
        return True