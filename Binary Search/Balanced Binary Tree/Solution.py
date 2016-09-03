# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        if self.depth(root) == -1:
            return False
        else:
            return True
        
    def depth(self,root):
        if not root:
            return 0
    
        left = self.depth(root.left)
        right = self.depth(root.right)
    
        if abs(left-right)>1 or left == -1 or right == -1:
            return -1
        return max(left,right)+1
        
