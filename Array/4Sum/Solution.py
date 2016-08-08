class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        numlen, res, dict = len(nums), set(), {}
        if numlen < 4:
            return []
        nums.sort()
        for p in range(numlen):
            for q in range(p + 1, numlen):
                if nums[p] + nums[q] not in dict:
                    dict[nums[p] + nums[q]] = [(p, q)]
                else:
                    dict[nums[p] + nums[q]].append((p, q))
        for i in range(numlen - 3):
            for j in range(i + 1, numlen - 2):
                cur_sum = target - nums[i] - nums[j]
                if cur_sum in dict:
                    for k in dict[cur_sum]:
                        if k[0] > j:
                            res.add((nums[i], nums[j], nums[k[0]], nums[k[1]]))
        return [list(i) for i in res]
