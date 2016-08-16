class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        row, col = len(matrix), len(matrix[0])
        first_row, first_col = False, False
        
        for i in range(row):
            for j in range(col):
                if matrix[i][j] == 0:
                    if i == 0:
                        first_row = True
                    if j == 0:
                        first_col = True
                    
                    matrix[i][0] = 0
                    matrix[0][j] = 0
        for i in range(1, row):
            if matrix[i][0] == 0:
                for j in range(1, col):
                    matrix[i][j] = 0
            if matrix[0][0] == 0 and first_col:
                matrix[i][0] = 0
                
        for j in range(1, col):
            if matrix[0][j] == 0:
                for i in range(1, row):
                    matrix[i][j] = 0
            if matrix[0][0] == 0 and first_row:
                matrix[0][j] = 0
        
