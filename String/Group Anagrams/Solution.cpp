// LeetCode, Group Anagrams
// Time complexity O(n)
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> result;
        unordered_map<string, vector<string>> hMap;
        string temp;
        for (int i = 0; i < strs.size(); i++) {
            temp = strs[i];
            sort(temp.begin(), temp.end());
            hMap[temp].push_back(strs[i]);
        }
        
        for (auto x = hMap.begin(); x != hMap.end(); x++) {
            vector<string> tmp = x->second;
            // sort(tmp.begin(), tmp.end());
            result.push_back(tmp);
        }
        
        return result;
    }
};