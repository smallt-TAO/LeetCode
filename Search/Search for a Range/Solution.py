class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums) == 0:
            return [-1, -1]

        start, end = 0, len(nums) - 1
        while start + 1 < end:
            mid = (start + end) / 2
            if nums[mid] < target:
                start = mid
            else:
                end = mid
        if nums[start] == target:
            leftBound = start
        elif nums[end] == target:
            leftBound = end
        else:
            return [-1, -1]

        start, end = leftBound, len(nums) - 1
        while start + 1 < end:
            mid = (start + end) / 2
            if nums[mid] <= target:
                start = mid
            else:
                end = mid
        if nums[end] == target:
            rightBound = end
        else:
            rightBound = start

        return [leftBound, rightBound]
