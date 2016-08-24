class Solution(object):
    def intToRoman(self, num):
        symbols = ["M", "D", "C", "L", "X", "V", "I"]
        ret, div, symPos = "", 1000, 0
        while num > 0:
            v = num / div
            if v <= 3:
                ret += v * symbols[symPos]
            elif v == 4:
                ret += symbols[symPos] + symbols[symPos - 1]
            elif v >= 5 and v < 9:
                ret += symbols[symPos - 1] + (v - 5) * symbols[symPos]
            elif v == 9:
                ret += symbols[symPos] + symbols[symPos - 2]
            num = num % div
            div /= 10
            symPos += 2
        return ret
        
