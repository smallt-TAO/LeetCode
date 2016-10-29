// LeetCode, Word Break II
// Time complexity O(n^2)
public class Solution {
        /* 3ms 99.91%
		Backtracking. Use a boolean array to prune branches.
		invalid[i]: s[i:end] can be breakable
		
		Also record max length of all words to prune branches.
	*/
    int maxLen = 0;  // max length of all words
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        for (String word : wordDict) 
            if (word.length() > maxLen) 
                maxLen = word.length();
        wordBreak(s, wordDict, new StringBuilder(), 0, new boolean[s.length()], res);
        return res;
    }
    private boolean wordBreak(String s, Set<String> wordDict, StringBuilder sb, int start, boolean[] invalid, List<String> res) {
        if (start == s.length()) { // reach the end
            res.add(sb.toString().trim());
            return true;
        }
        boolean breakable = false;
        int sbLen = sb.length();  // record current size
        int rightBound = Math.min(s.length(), start + maxLen);
        for (int end = start + 1; end <= rightBound; end++) {   // exclusive
            if (end != s.length() && invalid[end]) continue;    // check if s[right:end] is breakable
            String word = s.substring(start, end);
            if (wordDict.contains(word)) {
                sb.append(" "); sb.append(word);
                breakable |= wordBreak(s, wordDict, sb, end, invalid, res);
                sb.setLength(sbLen);
            }
        }
        invalid[start] = !breakable;
        return breakable;
    }
}