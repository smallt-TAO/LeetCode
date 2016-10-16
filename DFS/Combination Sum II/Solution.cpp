// LeetCode, Combination Sum II
// Time complexity O(n!)
class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> result;
        vector<int> intermediate;
        dfs(candidates, target, 0, intermediate, result);
        return result;
    }
    
private:
    static void dfs(vector<int> &candidates, int gap, int start, vector<int> &intermediate, vector<vector<int>> &result) {
        if (gap == 0) {
            result.push_back(intermediate);
            return;
        }
        
        int previous = -1;
        for (size_t i = start; i < candidates.size(); i++) {
            if (previous == candidates[i]) continue;
            if (gap < candidates[i]) return;  // pruning
            previous = candidates[i];
            
            intermediate.push_back(candidates[i]);
            dfs(candidates, gap - candidates[i], i + 1, intermediate, result);
            intermediate.pop_back();  // reconver
        }
    }
};