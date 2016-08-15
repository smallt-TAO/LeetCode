public class Solution {
    public int trap(int[] height) {
        int max = 0;
        int n = height.length;
        for (int i = 0; i < n; i++)
            if (height[i] > height[max])
                max = i;
        
        int water = 0;
        for (int i = 0, peak = 0; i < max; i++)
            if (height[i] > peak)
                peak = height[i];
            else
                water += peak - height[i];
        for (int i = n - 1, top = 0; i > max; i--)
            if (height[i] > top)
                top = height[i];
            else
                water += top - height[i];
        return water;
    }
}