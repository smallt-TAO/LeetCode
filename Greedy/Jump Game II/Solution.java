// LeetCode, Jump Game II
// Time complexity O(n) 
public class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int lastEnd = 0;
        int minJump = 0;
        int nextEnd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > lastEnd) {
                minJump++;
                lastEnd = nextEnd;
                nextEnd = 0;
            }
            if (nextEnd < nums[i] + i) nextEnd = nums[i] + i;
        }
        return minJump;
     }
}