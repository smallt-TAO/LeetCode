/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {
    if (!matrix.length)
    return 0;

    var n = matrix.length, m = matrix[0].length;
    var heights = [];
    for (var i = 0; i < m; i++)
        heights[i] = 0;

    var ans = 0;

    for (var k = 0; k < n; k++) {
      for (var j = 0; j < m; j++) {
        if (matrix[k][j] === '1') 
            heights[j]++;
        else 
            heights[j] = 0;
       }
    ans = Math.max(ans, largestRectangleArea(heights));
    }

    return ans;
};

var largestRectangleArea = function(heights) {
    heights.push(0);
    var maxn = 0;
    var stack = [];
    for (var i = 0, len = heights.length; i < len; i++) {
        while (stack.length && heights[i] < heights[stack[stack.length - 1]]) {
            var top = stack.pop();
        var nextTop = stack.length === 0 ? -1 : stack[stack.length - 1];
        maxn = Math.max((i - nextTop - 1) * heights[top], maxn);
        }
    stack.push(i);
    }

    return maxn;
};