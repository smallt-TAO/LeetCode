# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def helper(self, n, start):
        ret = []
        for i in range(start, n + start):
            l = self.helper(i - start, start)
            r = self.helper(n + start - i - 1, i + 1)
            for x in (l if len(l) else [None]):
                for y in (r if len(r) else [None]):
                    root = TreeNode(i)
                    root.left, root.right = x, y
                    ret.append(root)
        return ret
    
    def generateTrees(self, n):
        return self.helper(n, 1)
        
