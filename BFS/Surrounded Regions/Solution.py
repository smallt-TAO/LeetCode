class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        m = len(board)
        if m == 0 or board is None:
            return
        n = len(board[0])
        dir = ((1, 0), (-1, 0), (0, 1), (0, -1))
        
        visited = [False] * (n * m)
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O' and visited[int(i * n + j)] is False:
                    surrounded = True
                    stack = [i * n + j]
                    visitedOs = [i * n + j]
                    visited[i * n + j] = True
                    while len(stack) > 0:
                        point = int(stack.pop())
                        x = int(point / n)
                        y = int(point % n)
                        for k in range(4):
                            nextx = x + dir[k][0]
                            nexty = y + dir[k][1]
                            if 0 <= nexty < n and 0 <= nextx < m:
                                if board[nextx][nexty] == 'O' and visited[int(nextx * n + nexty)] is False:
                                    stack.append(nextx * n + nexty)
                                    visited[int(nextx * n + nexty)] = True
                                    visitedOs.append(int(nextx * n + nexty))
                            else:
                                surrounded = False
                    if surrounded:
                        for p in visitedOs:
                            board[int(p / n)][int(p % n)] = 'X'
        