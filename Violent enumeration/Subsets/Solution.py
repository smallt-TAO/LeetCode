class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if not nums:
            return [[]]
        subsets_of_sublist = self.subsets(nums[1:])
        new_elements = copy.deepcopy(subsets_of_sublist)
        for element in new_elements:
            element.append(nums[0])
        all_subsets = subsets_of_sublist + new_elements
        
        return all_subsets