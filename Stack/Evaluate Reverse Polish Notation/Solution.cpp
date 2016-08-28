// LeetCode, Evaluate Reverse Polish Notation
// Time complexity O(n)
class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> st;
        for (string s : tokens) {
            if (s == "+" || s == "-" || s == "*" || s == "/") {
                int b = st.top(); 
                st.pop(); 
                int a = st.top(); 
                st.pop(); 
                st.push(s == "+" ? a + b : s == "-" ? a - b : s == "*" ? a * b : a / b);
            } else { 
                st.push(stoi(s)); 
            }
        }
        
        return st.empty() ? 0 : st.top();
    }
};