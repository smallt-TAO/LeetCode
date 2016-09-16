# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        q = [(root, root.val)]
        sum = 0
        while q:
            node, num = q.pop(0)
            if [node.left, node.right] == [None, None]:
                sum += num
            else:
                for child in [node.left, node.right]:
                    if child != None:
                        q.append((child, 10 * num + child.val))
        return sum
