/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    var f = Array(n).fill(0);
    f[0] = 1;
    for (var k = 0; k < m; k++) {
        for (var j = 1; j < n; j++) {
            f[j] = f[j - 1] + f[j];
        }
    }
    
    return f[n - 1];
};