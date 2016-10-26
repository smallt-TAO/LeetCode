/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    if (typeof s !== 'string' || s.length === 0) {
        return 0;
    }
    
    var len     = s.length;
    var memo    = [];
    memo[len]   = 1;
    memo[len-1] = s[len-1] === '0' ? 0 : 1;

    for (var i = len - 2 ; i >= 0 ; i--) {
        if (s[i] === '0') {
            memo[i] = 0;
            continue;
        }
        var double = Number(s.substring(i, i + 2));
        memo[i] = (double <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
    }

    return memo[0];
};