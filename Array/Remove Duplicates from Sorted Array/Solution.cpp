//LeetCode , Two Sum
//hash
//Time complexity O(n),Space complexity 
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i, j = 0;
        if(nums.size() == 0) return 0;
        
        for(i = 1; i < nums.size(); i++) {
            if(nums[i] != nums[i - 1]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
};