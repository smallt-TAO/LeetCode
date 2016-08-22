// LeetCode, String to Integer (atoi)
// Time complexity O(n)
class Solution {
public:
    int myAtoi(string str) {
        double ret = 0;
        int sign = 1;
        int n = str.length();
        int i = 0;
        while (str[i] == ' ' && i < n) i++;
        if (i == n) return 0;
        
        if (str[i] == '+') {
            i++;
        } else if (str[i] == '-') {
            i++;
            sign = -1;
        }
        
        for (; i < n; i++) {
            if (str[i] < '0' || str[i] > '9')
                break;
            ret = ret * 10 + str[i] - '0';
            if (ret > INT_MAX)
                break;
        }
        ret *= sign;
        if (ret >= INT_MAX) return INT_MAX;
        if (ret <= INT_MIN) return INT_MIN;
        
        return ret;
    }
};
