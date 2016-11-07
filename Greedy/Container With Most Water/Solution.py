class Solution:
    # @return an integer
    def maxArea(self, height):
        i=0
        j=len(height)-1
        res = 0
        while i < j :
            res = max(res, min(height[i],height[j]) * (j-i))
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
        return res
            