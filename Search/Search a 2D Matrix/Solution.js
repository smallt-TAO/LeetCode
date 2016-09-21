/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    if (matrix === null || matrix.length === 0) {
        return false;
    }
    if (matrix[0] === null || matrix[0].length === 0) {
        return false;
    }
    
    var row = matrix.length;
    var col = matrix[0].length;
    var first = 0;
    var last = row * col;
    
    while (first < last) {
        var mid = (first + last) / 2;
        var val = matrix[~~(mid / col)][~~(mid % col)];
        
        if (val === target) return true;
        else if (val < target) first = mid + 1;
        else last = mid;
    }
    
    return false;
};