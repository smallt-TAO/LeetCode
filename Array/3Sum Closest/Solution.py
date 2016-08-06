class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l = len(nums)
        if (l < 3):
            return 0
        nums.sort()
        result = nums[0] + nums[1] + nums[2]
        i = 0
        while (i < l - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                i += 1
            start = i + 1
            end = l - 1
            while (start < end):
                cursum = nums[i] + nums[start] + nums[end]
                if (cursum == target):
                    return target
                if (abs(cursum - target) < abs(result - target)):
                    result = cursum
                if (cursum > target):
                    end -= 1
                else:
                    start += 1
            i += 1
        return result
  
