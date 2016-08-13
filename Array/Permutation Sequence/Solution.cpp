//LeetCode
//Time complexity O(n^2)
class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> nums(n);
        int pCount = 1;
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            pCount *= (i + 1);
        }
        
        k--;
        string result = "";
        for (int i = 0; i < n; i++) {
            pCount /= (n - i);
            int selected = k / pCount;
            result += ('0' + nums[selected]);
            for(int j = selected; j < n - i - 1; j++)
                nums[j] = nums[j + 1];
            k %= pCount;
        }
        return result;
    }
};