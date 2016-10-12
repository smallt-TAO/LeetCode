// LeetCode, N-Queens II
// Time complexity O(n)
class Solution {
public:
    int sum;
    bool canPut(int row, int col, vector<int> &cols) {
        for (int i = 0; i < row; i++) {
            if (cols[i] - i == col - row) {
                return false;
            }
            if (cols[i] + i == col + row) {
                return false;
            }
            if (cols[i] == col) {
                return false;
            }
        }
        return true;
    }
    
    void dfs(int n, int k, vector<int> &cols) {
        if (k == n) {
            sum++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!canPut(k, i, cols)) {
                continue;
            }
            cols[k] = i;
            dfs(n, k + 1, cols);
        }
    }
    
    int totalNQueens(int n) {
        vector<int> cols(n);
        sum = 0;
        dfs(n, 0, cols);
        return sum;
    }
};