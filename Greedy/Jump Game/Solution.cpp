// LeetCode,Jump Game
// Time complexity O(n)
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int reach = 1; 
        for (int i = 0; i < reach && reach < nums.size(); ++i) {
            reach = max(reach, i + 1 + nums[i]);
        }
        return reach >= nums.size();
    }
};