class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        hs = {}
        for s in strs:
            lst = list(sorted(s))
            lst = tuple(lst)
            if hs.get(lst):
                hs[lst].append(s)
            else:
                hs[lst] = [s]
        return hs.values()
        
