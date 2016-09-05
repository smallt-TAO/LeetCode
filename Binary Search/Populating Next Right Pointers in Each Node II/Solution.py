class Solution(object):
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        if root:
            level = [root]
            while level:
                if len(level) > 1:
                    for i in xrange(len(level) - 1):
                        level[i].next = level[i + 1]
                level = [n for node in level for n in (node.left, node.right) if n]
