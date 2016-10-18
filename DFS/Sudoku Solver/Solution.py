class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        self.board = board
        self.row = [[1] * 10 for i in range(9)]
        self.col = [[1] * 10 for j in range(9)]
        self.box = [[[1] * 10 for j in range(3)] for i in range(3)]
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.': continue
                v = int(board[i][j])
                self.row[i][v] = self.col[j][v] = self.box[i/3][j/3][v] = 0
        self.BT(0, 0)

    def BT(self, i, j):
        if i == 9:
            return True
        if self.board[i][j] != '.':
            return self.BT(*((i, j+1) if j < 8 else (i+1, 0)))

        for v in range(1, 10):
            if self.row[i][v] and self.col[j][v] and self.box[i/3][j/3][v]:
                self.board[i][j] = str(v)
                self.row[i][v] = self.col[j][v] = self.box[i/3][j/3][v] = 0
                if self.BT(*((i, j+1) if j < 8 else (i+1, 0))): return True
                self.row[i][v] = self.col[j][v] = self.box[i/3][j/3][v] = 1
        self.board[i][j] = '.'
        return False
        