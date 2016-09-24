class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def _permute(result, temp, nums):
            if nums == []:
                result += [temp]
            else:
                for i in range(len(nums)):
                    if i > 0 and nums[i] == nums[i - 1]:
                        continue
                    _permute(result, temp + [nums[i]], nums[:i] + nums[i + 1:])
        if nums is None:
            return []

        if len(nums) == 0:
            return [[]]

        result = []
        _permute(result, [], sorted(nums))
        return result
        