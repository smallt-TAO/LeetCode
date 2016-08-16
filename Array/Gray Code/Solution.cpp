// LeetCode, Gray Code
// Time complexity O(n)
class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> result{0};
        for (int i = 1; i <= n; i++) {
            int mask = 1 << (i - 1);
            for (int j = result.size() - 1; j >= 0; j--)
                result.push_back(result[j] + mask);
        }
        return result;
    }
};