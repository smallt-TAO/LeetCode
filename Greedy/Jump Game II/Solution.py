class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result, last = 0, 0
        cur = 0
        for i in range(len(nums)):
            if i > last:
                last = cur
                result += 1
            cur = max(cur, i + nums[i])
        return result