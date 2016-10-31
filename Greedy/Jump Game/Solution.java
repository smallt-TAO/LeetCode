// LeetCode, Jump Game
// Time complexity O(n)
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        boolean jump = false;
        int maxLen = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > maxLen) {
                maxLen = 0;
                jump = true;
            } else {
                maxLen++;
                jump = false;
            }
        }
        return jump;
    }
}