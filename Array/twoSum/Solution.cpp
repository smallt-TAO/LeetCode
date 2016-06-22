//LeetCode , Two Sum
//hash
//Time complexity O(n),Space complexity 
class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		vector<int> result;
		map<int, int> hash_map;
		for (int i = 0; i < nums.size(); i++){
			hash_map[nums[i]] = i;
		}
		for (int i = 0; i < nums.size(); i++){
			const int gap = target - nums[i];
			if (hash_map.find(gap) != hash_map.end() && hash_map[gap] > i){
				result.push_back(i);
				result.push_back(hash_map[gap]);
				break;
			}

		}
		return result;
	}
};