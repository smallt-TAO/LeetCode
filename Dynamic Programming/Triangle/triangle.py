class Solution:
    """ @param triangle, a list of lists of integers."""

    def minimumTotal(self, triangle):
        n = len(triangle)
        arr = [0] * n
        tmparr = [0] * n
        arr[0] = triangle[0][0]
        for i in range(1, n):
            tmparr[0] = arr[0] + triangle[i][0]
            for j in range(1, i):
                tmparr[j] = min(arr[j - 1], arr[j]) + triangle[i][j]
            tmparr[i] = arr[i - 1] + triangle[i][i]
            tmp = tmparr
            tmparr = arr
            arr = tmp
        return min(arr)


if __name__ == "__main__":
    triangle = Solution()
    a = [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
    print triangle.minimumTotal(a)
