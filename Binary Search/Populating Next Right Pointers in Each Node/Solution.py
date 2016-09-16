# Definition for binary tree with next pointer.
# class TreeLinkNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution(object):
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        head = root
        while head is not None:
            if head.left is None: 
                break
            curNode = head
            curNode.left.next = curNode.right
            while curNode is not None:
                curNode.left.next = curNode.right
                if curNode.next is not None:
                    curNode.right.next = curNode.next.left
                curNode = curNode.next
            head = head.left
            
