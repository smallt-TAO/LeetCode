// LeetCode, Restore IP Addresses
// Time complexity O(n^4)
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(s, 4);
    }
    
    private boolean validIpNumber(String s) {
        return Integer.parseInt(s) - 256 < 0 && !(s.charAt(0) == '0' && s.length() > 1);
    }
    
    // restore Ip Addresses in n parts
    public List<String> restoreIpAddresses(String s, int n) {
        List<String> list = new ArrayList<String>();
        
        // valid string
        if (s.length() / n > 3 || (s.length() / n == 3 && s.length() % n != 0) || s.length() < n) {
            return list;
        }
        
        // base case, return
        if (n == 1) {
            if (validIpNumber(s)) {
                list.add(s);
            }
            return list;
        }
        
        for (int i = 1; i <= 3; i++) {
            if (s.length() >= i) {
                String sub = s.substring(0, i);
                if (validIpNumber(sub)) {
                    sub += ".";
                    List<String> restList = restoreIpAddresses(s.substring(i), n - 1);
                    for (String str : restList) {
                        list.add(sub + str);
                    }
                }
            } else {
                break;
            }
        }
        return list;
    }
}