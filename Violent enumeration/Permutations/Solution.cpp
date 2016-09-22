// LeetCode, Permutations
// Time complexity O(2^n)
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        int n = nums.size();
        if (n == 0) {
            res.push_back(vector<int>());
            return res;
        }

        helper(res, nums, n - 1);
        return res;
    }
    
    void helper(vector<vector<int> > &res, vector<int> nums, int n) {
        
        if (n == 0) {
            res.push_back(nums);
        }
        
        for (int i = 0 ; i <= n; i++) {
            swap(nums[i], nums[n]);
            helper(res, nums, n - 1);
            swap(nums[i], nums[n]);
        }
    }
};