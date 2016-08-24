// LeetCode, Longest Common Prefix
// Time complexity O(n1 + n2)
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int arrayLen = strs.length;
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
    
        int minlen = strs[0].length();
        int len;
        for (int i = 1; i < arrayLen; i++) {
            len = strs[i].length();
            if (minlen > len) 
                minlen = len;
        } 

        int i, j;
        for (i = 0; i < minlen; i++) {
            for (j = 1; j < arrayLen; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) 
                    return strs[0].substring(0,i);
            }
        }
        
        return strs[0].substring(0,i);
    }
}

