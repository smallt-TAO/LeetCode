// LeetCode, Word Ladder
// Time complexity O(3^n)
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList.size() == 0) return 0;
        LinkedList<String> queue = new LinkedList<String>();
        String tag = new String();
        queue.add(beginWord);
        queue.add(tag);
        int len = 1;
        while (queue.size() > 1) {
            String top = queue.pop();
            if (top == tag) {
                len++;
                queue.add(tag);
                continue;
            }
            if (top.equals(endWord)) {
                return len;
            }
            for (int i = 0; i < top.length(); i++) {
                char[] currCharArr = top.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);
                    if (wordList.contains(newWord)) {
                        queue.add(newWord);
                        wordList.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}