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
        re[0] = true;                         //默认第零位为匹配，因为有可能p[0]==*
        for (int i = 0; i < n; i++) {
            if (p[i] == '*'){                 //判断是否为*，*需要特殊处理
                for (int k = 0; k < m; k++){
                    re[k + 1] = re[k + 1] || re[k]; //如果已经为真，则继续为真；否则要取决于前一位。
                }
            } else {
                for (int j = m; j > 0; j--){      //取决于前一位，并且要求这一位匹配
                    re[j] = re[j - 1] && (p[i] == s[j - 1] || p[i] == '?');
                }
            }
            re[0] = re[0] && p[i]=='*';       //如果该位置不为*，则第零位不可为真
        }
        return re[m];
    }
};
