// LeetCode, Length of Last Word
// Time complexity O(n)
class Solution {
public:
    int lengthOfLastWord(string s) {
        int length = 0;
        for (int i = s.size() - 1; i >= 0; i--) {
            if (length == 0) {
                if (s[i] == ' ') {
                    continue;
                } else {
                    length++;
                }
            } else {
                if (s[i] == ' ') {
                    break;
                } else {
                    length++;
                }
            }
        }
        return length;
    }
};