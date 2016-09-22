class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        p = [[nums[x] for x in range(len(nums)) if i >> x & 1] for i in range(2**len(nums))]
        func = lambda x, y : x if y in x else x + [y]
        p = reduce(func, [[], ] + p)
        
        return list(reversed(p))