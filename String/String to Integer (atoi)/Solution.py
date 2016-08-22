class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        str = str.strip()
        if str == "":
            return 0
        i, sign = 0, 1
        ret, length = 0, len(str)
        MaxInt = (1 << 31) - 1
        if str[i] == '+':
            i += 1
        elif str[i] == '-':
            i += 1
            sign = -1
        for i in range(i, length):
            if str[i] < '0' or str[i] > '9':
                break
            ret = ret * 10 + int(str[i])
            if ret > MaxInt:
                break
        ret *= sign
        if ret >= MaxInt:
            return MaxInt
        if ret < MaxInt * -1:
            return MaxInt * -1 - 1
        return ret
        
