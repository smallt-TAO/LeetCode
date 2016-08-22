class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        lena = len(a) - 1
        lenb = len(b) - 1
        carry = 0
        sum = ""
        while lena >= 0 or lenb >= 0:
            aa = int(a[lena]) if lena >= 0 else 0
            bb = int(b[lenb]) if lenb >= 0 else 0
            cc = (aa + bb + carry) % 2
            carry = (aa + bb + carry) / 2
            sum = str(cc) + sum
            lena -= 1
            lenb -= 1
        if carry == 1:
            sum = '1' + sum
        return sum
    
