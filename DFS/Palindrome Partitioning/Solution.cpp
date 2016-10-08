// LeetCode, Palindrome Partitioning
// Time complexity O(2 ^ n)
class Solution {
public:
    vector<vector<string>> v;
    vector<string> v1;
    vector<vector<string>> partition(string s) {
        v.clear();
        if (s.size() == 0) {
            return v;
        }
        v1.clear();
        dfs(0, s);
        return v;
    }
    
    bool ispartition(string s) {
        int i = 0;
        int j = s.size() - 1;
        while (i < j) {
            if (s[i] == s[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    
    void dfs(int depth, string s) {
        if (depth == s.size()) {
            v.push_back(v1);
        }
        if (depth < s.size()) {
            for (int i = depth; i < s.size(); i++) {
                if (ispartition(s.substr(depth, i - depth + 1))) {
                    v1.push_back(s.substr(depth, i - depth + 1));
                    dfs(i + 1, s);
                    v1.pop_back();
                }
            }
        }
    }
};