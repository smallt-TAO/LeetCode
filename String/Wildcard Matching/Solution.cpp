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
        re[0] = true;                         //Ĭ�ϵ���λΪƥ�䣬��Ϊ�п���p[0]==*
        for (int i = 0; i < n; i++) {
            if (p[i] == '*'){                 //�ж��Ƿ�Ϊ*��*��Ҫ���⴦��
                for (int k = 0; k < m; k++){
                    re[k + 1] = re[k + 1] || re[k]; //����Ѿ�Ϊ�棬�����Ϊ�棻����Ҫȡ����ǰһλ��
                }
            } else {
                for (int j = m; j > 0; j--){      //ȡ����ǰһλ������Ҫ����һλƥ��
                    re[j] = re[j - 1] && (p[i] == s[j - 1] || p[i] == '?');
                }
            }
            re[0] = re[0] && p[i]=='*';       //�����λ�ò�Ϊ*�������λ����Ϊ��
        }
        return re[m];
    }
};
