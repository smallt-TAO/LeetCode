# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        ans = []
        tmp = head
        while tmp != None:
            ans.append(tmp.val)
            tmp = tmp.next

        ans.sort()
        tmp = head
        for i in ans:
            tmp.val = i
            tmp = tmp.next
        return head
        
