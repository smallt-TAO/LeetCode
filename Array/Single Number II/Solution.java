// LeetCode, Single Number II
// Time complexity O(n)
public class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        if (nums == null || n == 0) return -1;

        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < n; j++) {
                bits[i] += (nums[j] >> i) & 1;
                bits[i] %= 3;
            }
            result |= (bits[i] << i);
        }
        return result;
    }
}