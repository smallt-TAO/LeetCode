// LeetCode, Unique Paths II
// Time complexity O(n^2)
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0) {
                    if (obstacleGrid[i][j] == 1) break;
                    dp[i][j] = 1;
                    continue;
                }
                if (j == 0 && i != 0) {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + 0;
                    continue;
                }
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j-1];
                
                
            }
        }
        return dp[height - 1][width - 1];
    }
}