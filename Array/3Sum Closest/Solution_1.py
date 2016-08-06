class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        result, diff = 0, sys.maxint
        nums.sort()
        
        for i in xrange(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            left, right = i + 1, len(nums) - 1
            
            while left < right:
                total = nums[i] + nums[left] + nums[right]
                curdiff = abs(total - target)
                
                if not curdiff:
                    return total
                    
                if curdiff < diff:
                    result = total
                    diff = curdiff
                    
                if total < target:
                    left += 1
                else:
                    right -= 1
        return result

  
