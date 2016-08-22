// LeetCode, Implement strStr()
// Time complexity O(n*m)
class Solution {
public:
    int strStr(string haystack, string needle) {
        int lenh = haystack.length(), lenn = needle.length();
        if (lenn == 0)  return 0;
        
        for (int i = 0; i < lenh - lenn + 1; i++) {
            int j = 0;
            for (j = 0; j < lenn; j++) {
                if (haystack[i + j] != needle[j]) {
                    break;
                }
            }
            // finished loop, needle found.
            if (j == lenn) {
                return i;
            }
        }
        return -1;
    }
};
