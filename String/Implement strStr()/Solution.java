// LeetCode, Implement strStr()
// Time complexity O(n*m)
public class Solution {
    public int strStr(String haystack, String needle) {
        int i, j;
        int lenh = haystack.length();
        int lenn = needle.length();
        if (needle == null || haystack == null) return -1;
        
        for (i = 0; i < lenh - lenn + 1; i++) {
            for (j = 0; j < lenn; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == lenn) {
                return i;
            }
        }
        return -1;
    }
}
