// LeetCode, Longest Valid Parentheses
// Time complexity O(n)
class Solution {
public:
    int longestValidParentheses(string s) {
        if (s.size() == 0) return 0;
        stack<int> stack;
        int maxLen = 0;
        int accumulatedLen = 0;

        for(int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                stack.push(i);
            } else {
                if (stack.empty()) {
                    accumulatedLen = 0;
                } else {
                    int matchedPos = stack.top();
                    stack.pop();
                    int matchedLen = i - matchedPos + 1;

                    if (stack.empty()) {
                        accumulatedLen += matchedLen;
                        matchedLen = accumulatedLen;
                    } else {
                        matchedLen = i - stack.top();
                    }
                    maxLen = max(maxLen, matchedLen);
                }
            }
        }
        return maxLen;
    }
};