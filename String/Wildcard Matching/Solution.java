// LeetCode, Wildcard Matching
// Time complexity O(n)
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        if(m == 0) return n == 0;
        boolean[] res = new boolean[n + 1];
        res[0] = true;
        for(int j = 0; j < m; j++) {
            if(p.charAt(j) != '*') {
                for(int i = n - 1; i >= 0; i--) {
                    res[i + 1] = res[i] && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j));
                }
            } else {
                int i = 0;
                while(i <= n && !res[i])
                    i++;
                for(;i <= n; i++) {
                    res[i] = true;
                }
            }
            res[0] = res[0] && p.charAt(j) == '*';
        }
        return res[n];
    }
}
