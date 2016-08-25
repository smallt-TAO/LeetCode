// LeetCode, Count and Say
// Time complexity O(n)
class Solution {
public:
    string countAndSay(int n) {
        string res;
        while (n--) {
            if (res.empty()) {
                res = "1";
            } else {
                string tmp;
                for (int i = 0; i < res.size(); i++) {
                    int count = 1;
                    while (i + 1 < res.size() && res[i] == res[i+ 1]) {
                        count++;
                        i++;
                    }
                    tmp += to_string(count) + res[i];
                }
                res = tmp;
            }
        }
        return res;
    }
};