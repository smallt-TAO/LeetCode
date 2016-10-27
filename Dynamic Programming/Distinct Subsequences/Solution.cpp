// LeetCode, Distinct Subsequences
// Time complexity O(n^2)
class Solution {
public:
    int numDistinct(string s, string t) {
        vector<vector<int>> m(t.length() + 1, vector<int>(s.length() + 1));
        for (int i = 0; i <= t.length(); i++) {
            m[i][0] = 0;
        }
        for (int i = 0; i <= s.length(); i++) {
            m[0][i] = 0;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (t[0] == s[i - 1]) {
                m[1][i] = m[1][i - 1] + 1;
            } else {
                m[1][i] = m[1][i - 1];
            }
        }
        
        for (int i = 2; i <= t.length(); i++) {
            for (int j = 2; j <= s.length(); j++) {
                if (t[i - 1] == s[j - 1]) {
                    m[i][j] = m[i - 1][j - 1] + m[i][j - 1];
                } else {
                    m[i][j] = m[i][j - 1];
                }
            }
        }
        
        return m[t.length()][s.length()];
    }
};