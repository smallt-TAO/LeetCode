// LeetCode, Single Number
// Time complexity O(n)
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int n = nums.size();
        int x = 0;
        for (int i = 0; i < n; i++)
            x ^= nums[i];
        return x;
    }
};