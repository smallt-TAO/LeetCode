//LeetCode
//Time complexity O(n^2),Space complexity 
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1;
            int end = nums.size() - 1;
            while (start < end) {
                int curSum = nums[i] + nums[start] + nums[end];
                if (curSum == target) return target;
                if (abs(curSum - target) < abs(target - result)) result = curSum;
                if (curSum > target) end--;
                else start++;
            }
        }
        return result;
    }
};
