// LeetCode, Add Binary
// Time complexity O(n)
public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();        
    
        for(int i = a.length() - 1, j = b.length() -1;  i >= 0 || j >= 0 || carry > 0 ; i--, j--) {
            int sum = 0;
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            sum += carry;
        
            carry = sum /2;
            sum %=2;
            sb.append(sum);
        }
        
        return sb.reverse().toString();
    }
}
