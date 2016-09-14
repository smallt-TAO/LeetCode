# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        v_map = {}
        # hash
        for l in lists:
            while l is not None:
                try:
                    v_map[l.val].append(l)
                except KeyError:
                    v_map[l.val] = [l]
                l = l.next
        head = last = ListNode(-1)
        # sort and connect
        for k in sorted(v_map.keys()):
            for t in v_map[k]:
                last.next = t
                last = t
        last.next = None
        return head.next
        
