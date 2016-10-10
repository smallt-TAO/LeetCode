/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    var m = obstacleGrid.length;
    var n = obstacleGrid[0].length;
    if (obstacleGrid[0][0] || obstacleGrid[m - 1][n - 1]) {
        return 0;
    }
    
    var f = Array(n).fill(0);
    f[0] = obstacleGrid[0][0] ? 0:1;
    
    for (var i = 0; i < m; i++) {
        for (var j = 0; j < n; j++) {
            f[j] = obstacleGrid[i][j] ? 0 : (j === 0? 0:f[j - 1]) + f[j];
        }
    }
    
    return f[n - 1];
};