# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if not root:
            return []
        if not root.right and not root.left:
            return [[root.val]] if root.val == sum else []
        
        return [[root.val] + i for i in self.pathSum(root.left, sum - root.val) +
               self.pathSum(root.right, sum - root.val)]
        
