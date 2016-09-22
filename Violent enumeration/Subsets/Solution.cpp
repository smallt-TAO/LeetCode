// LeetCode, Subsets
// Time complexity O(2^n)
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> result;
        vector<bool> selected(nums.size(), false);
        subsets(nums, selected, 0, result);
        return result;
    }
    
private:
    static void subsets(const vector<int>& nums, vector<bool>& selected, int step, vector<vector<int>>& result) {
        if (step == nums.size()) {
            vector<int> subset;
            for (int i = 0; i != nums.size(); i++) {
                if (selected[i])
                    subset.push_back(nums[i]);
            }
            result.push_back(subset);
            return;
        }
        
        selected[step] = false;
        subsets(nums, selected, step + 1, result);
        selected[step] = true;
        subsets(nums, selected, step + 1, result);
    }       
};