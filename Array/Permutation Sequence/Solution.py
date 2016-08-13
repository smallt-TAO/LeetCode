class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        pCount = 1
        nums = [0] * n
        for i in range(n):
            nums[i] = i + 1
            pCount *= (i + 1)
        k -= 1
        result = ''
        for i in range(n):
            pCount /= (n - i)
            selected = k / pCount
            result += str(nums[selected])
            nums.remove(nums[selected])
            k %= pCount
        return result
