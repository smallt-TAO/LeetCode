// LeetCode, Unique Paths II
// Time complexity O(n^2)
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        if (obstacleGrid[0][0] || obstacleGrid[m - 1][n - 1]) {
            return 0;
        }
    
        vector<int> f(n, 0);
        f[0] = obstacleGrid[0][0] ? 0:1;
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[j] = obstacleGrid[i][j] ? 0 : (j == 0? 0:f[j - 1]) + f[j];
            }
        }
    
        return f[n - 1];
    }
};