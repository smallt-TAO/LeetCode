/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {Set} wordList
 *   Note: wordList is a Set object, see:
 *   https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    var visited = new Set();
    var queue = [];
    var level = 1;
    var letters = 'abcdefghijklmnopqrstuvwxyz';
    queue.push(beginWord);
    visited.add(beginWord);
    while (queue.length > 0) {
        var len = queue.length;
        for (var i = 0; i < len; i++) {
            var word = queue.shift();
            for (var j = 0; j < word.length; j++) {
                for (var k =0; k < letters.length; k++) {
                    var newWord = word.substring(0, j) + letters[k] + word.substring(j + 1);
                    if (newWord === endWord) {
                        return level + 1;
                    }
                    if (wordList.has(newWord) && !visited.has(newWord)) {
                        queue.push(newWord);
                        visited.add(newWord);
                    }
                }
            }
        }
        level++;
    }
    return 0;
};