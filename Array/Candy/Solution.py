class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        n = len(ratings)
        res = n * [1]
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                res[i] = res[i - 1] + 1
        for i in range(n-1, 0, -1):
            if ratings[i - 1] > ratings[i]:
                res[i - 1] = max(res[i - 1], res[i] + 1)
        return sum(res)
