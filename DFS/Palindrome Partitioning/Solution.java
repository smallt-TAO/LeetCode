// LeetCode, Palindrome Partitioning
// Time complexity O(2 ^ n)
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null) {
            return result;
        }
        
        ArrayList<String> path = new ArrayList<String>();
        helper(s, path, 0, result);
        
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int beg = 0;
        int end = s.length() - 1;
        while (beg < end) {
            if (s.charAt(beg) != s.charAt(end)) {
                return false;
            } else {
                beg++;
                end--;
            }
        }
        
        return true;
    }
    
    private void helper(String s, ArrayList<String> path, int pos, List<List<String>> result) {
        if (pos == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }
        
        for (int i = pos + 1; i <= s.length(); i++) {
            String prefix = s.substring(pos, i);
            if (!isPalindrome(prefix)) {
                continue;
            }
            path.add(prefix);
            helper(s, path, i, result);
            path.remove(path.size() - 1);
        }
    }
}