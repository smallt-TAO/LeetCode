// LeetCode, Combination Sum
// Time complexity O(n!)
class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> result;  // store the result
        vector<int> intermediate;  // midlle result
        dfs(candidates, target, 0, intermediate, result);
        return result;
    }
    
private:
    void dfs(vector<int>& candidates, int gap, int start, vector<int>& intermediate, vector<vector<int>> &result) {
        if (gap == 0) {  // find the closed-solution
            result.push_back(intermediate);
            return;
        }
        for (size_t i = start; i < candidates.size(); i++) {
            if (gap < candidates[i]) return;  // cut
            intermediate.push_back(candidates[i]);
            dfs(candidates, gap - candidates[i], i, intermediate, result);
            intermediate.pop_back();  // recall
        }
    }
};