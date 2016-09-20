// LeetCode, Search for a Range
// Time complexity O(lgn)
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result;
        vector<int>::iterator p;
        
        int l, r;
        p = find(nums.begin(), nums.end(), target);
        if (p != nums.end())
            l = p - nums.begin();
        else
            l = -1;
            
        r = -1;
        int len = nums.size();
        for (int i = len - 1; i != -1; --i) {
            if (nums[i] == target) {
                r = i;
                break;
            }
        }
        result.push_back(l);
        result.push_back(r);
        return result;
    }
};