/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    const MAX = 2147483647;
    const sign = x < 0 ? -1 : 1;

    let result = 0;

    for (let i = Math.abs(x); i >= 1; i = Math.floor(i / 10)) {
       result = (result * 10) + (i % 10);
    }

    return result < MAX ? (result * sign) : 0;
};