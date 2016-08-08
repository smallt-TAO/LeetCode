class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = set(nums)
        maxlen = 0
        while nums:
            n = nums.pop()
            i = n + 1
            l1 = 0 #param l1 forword 
            l2 = 0 #param l2 backword
            while i in nums:
                nums.remove(i)
                i += 1
                l1 += 1
            i = n - 1
            
            while i in nums:
                nums.remove(i)
                i -= 1
                l2 += 1
            
            maxlen = max(maxlen, l1 + l2 + 1)
        return maxlen
