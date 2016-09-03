# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True
        else:
            return  compire(root.left,root.right)
              
def compire(l,r):
    if l is None and r is None:
        return True
    elif l is None or r is None:
        return False
    elif l.val==r.val:
        return compire(l.left,r.right) and compire(l.right,r.left)
    return False
