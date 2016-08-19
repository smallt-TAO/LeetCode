# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        Head = ListNode(-1)
        Head.next = head
        pre = Head
        cur = head
        while cur != None and cur.next != None:
            if cur.val == cur.next.val:
                while cur.next != None and cur.val == cur.next.val:
                    cur = cur.next
                pre.next = cur.next
                cur = cur.next
            else:
                pre = cur
                cur = cur.next
        return Head.next

