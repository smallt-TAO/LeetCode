class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        p = 0
        ans = 0
        for item in nums[:-1]:
            ans = max(ans, p + item)
            if ans <= p:
                return False
            p += 1
        return True
        