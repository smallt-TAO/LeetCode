class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        max, n = 0, len(height)
        for i in range(n):
            if height[i] > height[max]:
                max = i
        water, peak, top  = 0, 0, 0
        for i in range(0, max):
            if height[i] > peak:
                peak = height[i]
            else:
                water += peak - height[i]
        for i in range(n - 1, max, -1):
            if height[i] > top:
                top = height[i]
            else:
                water += top - height[i]
        return water
