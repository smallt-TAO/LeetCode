class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        x = 0
        while len(nums) - 1 >= x + 1:
            if nums[x] == nums[x + 1]:
                del nums[x + 1]
            else:
                x += 1
        return len(nums)


