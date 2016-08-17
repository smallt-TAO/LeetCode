// LeetCode, Single Number II
// Time complexity O(n)
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int n = nums.size();
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < n; i++) {
            two |= one & nums[i];
            one ^= nums[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
};