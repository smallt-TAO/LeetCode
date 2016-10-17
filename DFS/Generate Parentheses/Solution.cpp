// LeetCode, Generate Parentheses
// Time complexity O(TODO)
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> result;
        if (n > 0) generate(n, "", 0, 0, result);
        return result;
    }
    // l represent the ( , r represent )
    void generate(int n, string s, int l, int r, vector<string> &result) {
        if (l == n) {
            result.push_back(s.append(n - r, ')'));
            return;
        }
        generate(n, s + '(', l + 1, r, result);
        if (l > r) generate(n, s + ")", l, r + 1, result);
    }
    
};