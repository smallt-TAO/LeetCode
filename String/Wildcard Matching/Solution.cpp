// LeetCode, Wildcard Matching
// Time complexity O(n^2)
class Solution {
public:
    bool isMatch(string s, string p) {
        int m = s.size();
        int n = p.size();
        if (n == 0) return m == 0;
        if (m > 30000) return false;
        
        bool re[m + 1] = {false};
        re[0] = true;                         // assmue true, may p[0]==*.
        for (int i = 0; i < n; i++) {
            if (p[i] == '*') {
                for (int k = 0; k < m; k++) {
                    re[k + 1] = re[k + 1] || re[k]; // if ture go true; otherwise depend on pre.
                }
            } else {
                for (int j = m; j > 0; j--) {
                    re[j] = re[j - 1] && (p[i] == s[j - 1] || p[i] == '?');
                }
            }
            re[0] = re[0] && p[i]=='*';       // if not *, re[0] is false.
        }
        return re[m];
    }
};
