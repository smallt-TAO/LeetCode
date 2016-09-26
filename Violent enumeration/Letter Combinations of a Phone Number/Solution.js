/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    var digitMap = {
        2: ['a', 'b', 'c'],
        3: ['d', 'e', 'f'],
        4: ['g', 'h', 'i'],
        5: ['j', 'k', 'l'],
        6: ['m', 'n', 'o'],
        7: ['p', 'q', 'r', 's'],
        8: ['t', 'u', 'v'],
        9: ['w', 'x', 'y', 'z'],
    };
    
    if (digits.length === 0) return [];
    if (digits.length === 1) return digitMap[digits[0]];
    var result = [];
    var restResult = letterCombinations(digits.slice(1));
    digitMap[digits[0]].forEach(function(letter) {
        result = result.concat(restResult.map(function (item) {
            return letter + item;
        }));
    });
    return result;
};