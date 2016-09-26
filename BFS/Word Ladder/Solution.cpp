// LeetCode, Word Ladder
// Time complexity O(3^n)
class Solution {
public:
    int ladderLength(string beginWord, string endWord, unordered_set<string>& wordList) {
        if (wordList.empty() || beginWord == endWord)  
            return 0;  
        queue<string>strq;  
        queue<int>depq;  
        strq.push(beginWord);  
        depq.push(1);  
        string cur, nxt;  
        int depth;  
        unordered_set<string> visited;  
        while (!strq.empty()) {  
            nxt = cur = strq.front();  
            strq.pop();  
            depth = depq.front();  
            depq.pop();  
            if (cur == endWord)  
                return depth;  
            for (int i = 0; i < cur.length(); ++i) {  
                for (char ch = 'a'; ch<='z'; ++ch) {  
                    if (ch!=cur[i]) {  
                        nxt[i] = ch;  
                        if (wordList.find(nxt) != wordList.end() && visited.find(nxt) == visited.end()) {  
                            visited.insert(nxt);  
                            strq.push(nxt);  
                            depq.push(depth + 1);  
                        }  
                        nxt = cur;  
                    }  
                }  
            }  
        }  
        return 0;  
    }
};