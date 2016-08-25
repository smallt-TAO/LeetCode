// LeetCode, Roman to Integer
// Time complexity O(n)
public class Solution {
    private static final int[] vals;
    static {
        vals = new int[256];
        vals['I'] = 1;
        vals['V'] = 5;
        vals['X'] = 10;
        vals['L'] = 50;
        vals['C'] = 100;
        vals['D'] = 500;
        vals['M'] = 1000;
    }
    
    public int romanToInt(String s) {
        char[] r = s.toCharArray();
        int previousVal = Integer.MAX_VALUE;
        int result = 0;
        int carry = 0;
        for (char c: r) {
            int val = vals[c];
            if (previousVal > val) {
                result += carry;
                carry = val;
            } else if (previousVal == val) {
                carry += val;
            } else {
                carry = -carry + val;
            }
            previousVal = val;
        }
        return result + carry;
    }
}