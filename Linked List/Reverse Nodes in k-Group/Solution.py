# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        # need to solve this problem using recursive method
        if k == 1 or head is None:
            return head
        dummy = ListNode(-1)
        dummy.next = head
        n = k
        p, start = dummy, dummy
        while p:
            if n == 0:
                tmp = start.next
                self.reverseList(start, k)
                start = tmp
                p = start
                n = k
                continue
            p = p.next
            n -= 1
        return dummy.next

    def reverseList(self, head, k):
        p, c, n = head, head.next, head.next.next
        newTail = c
        while c and k > 0:
            c.next = p
            k -= 1
            if k == 0:
                break

            p = c
            if n:
                c = n
                n = n.next
            else:
                break
        head.next = c
        newTail.next = n

        return
