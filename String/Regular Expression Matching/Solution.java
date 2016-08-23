// LeetCode, Regular Expression Matching
// Time complexity O(n)
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] res = new boolean[n + 1];
        res[0] = true;
        
        int i, j;
		for (j = 2; j <= n; j++)
			res[j] = res[j - 2] && p.charAt(j - 1) == '*';

		char pc, sc, tc;
		boolean pre, cur; // pre=res[i - 1][j - 1], cur=res[i-1][j]

		for (i = 1; i <= m; i++) {
			pre = res[0];
			res[0] = false;
			sc = s.charAt(i - 1);

			for (j = 1; j <= n; j++) {
				cur = res[j];
				pc = p.charAt(j - 1);
				if (pc != '*')
					res[j] = pre && (sc == pc || pc == '.');
				else {
					// pc == '*' then it has a preceding char, i.e. j>1
					tc = p.charAt(j - 2);
					res[j] = res[j - 2] || (res[j] && (sc == tc || tc == '.'));
				}
				pre = cur;
			}
		}
		return res[n];
    }
}
