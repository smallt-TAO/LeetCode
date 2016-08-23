// LeetCode, Longest Palindromic Substring
// Time complexity O(n^2)
class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        bool f[n][n];
        fill_n(&f[0][0], n * n, false);
        int max_len = 1, start = 0;
        for (int i = 0; i < n; i++) {
            f[i][i] = true;
            for (int j = 0; j < i; j++) {
                f[j][i] = (s[j] == s[i] && (i - j < 2 || f[j + 1][i - 1]));
                if (f[j][i] && max_len < (i - j + 1)) {
                    max_len = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substr(start, max_len);
    }
};
