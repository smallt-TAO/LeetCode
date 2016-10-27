// LeetCode, Word Break
// Time complexity O(n^2)
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                f[i] |= f[j] && wordDict.contains(s.substring(j, i));
            }
        }
        return f[s.length()];
    }
}