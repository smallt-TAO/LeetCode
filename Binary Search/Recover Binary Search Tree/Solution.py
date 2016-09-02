# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        prev = None
        first = None
        second = None
        if root.left:
            buf = root.left
            while buf.right != root and buf.right:
                buf = buf.right
            if buf.right:
                buf.right = root
                root = root.left
            else:
                if prev and prev.val > root.val:
                    if not first:
                        first = prev
                    second = root
                prev = root
                buf.right = None
                root = root.right
        else:
            if prev and prev.val > root.val:
                if not first:
                    first = prev
                second = root
            prev = root
            root = root.right
            
        if first:
            first.val, second.val = second.val, first.val
    
