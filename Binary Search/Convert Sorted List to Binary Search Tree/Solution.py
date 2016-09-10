# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        def helper(L, R):
            if L <= R:
                mid = L + (R - L + 1) / 2
                root = TreeNode(nums[mid])
                root.left = helper(L, mid - 1)
                root.right = helper(mid + 1, R)
                return root
        nums, node = [], head
        while node:
            nums.append(node.val)
            node = node.next
        return helper(0, len(nums) - 1)
