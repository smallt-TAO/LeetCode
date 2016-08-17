class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        n, pre = len(gas), 0
        currsum, total = 0, 0
        for i in range(n):
            total += gas[i] - cost[i]
            currsum += gas[i] - cost[i]
            if currsum < 0:
                currsum = 0
                pre = i + 1
        if total < 0:
            return -1
        else:
            return pre
