'''
Question -->
This problem was asked by Twitter.
Given a binary tree, find the lowest common ancestor (LCA)
of two given nodes in the tree.
Assume that each node in the tree also has a pointer to its parent.

Approach -->
Traverse the first node upto root using the parent pointer,
store the path in a set.
Traverse the second node using parent pointer,
return the first node which exists in the set
'''


class TreeNode:
    def __init__(self, key, parent):
        self.left = None
        self.right = None
        self.parent = parent
        self.data = key


def findLCA(nodeA, nodeB):
    if not nodeA or not nodeB:
        return None
    pathA = set()

    temp = nodeA
    while temp != None:
        pathA.add(temp)
        temp = temp.parent

    temp = nodeB
    while temp != None:
        if temp in pathA:
            return temp.data
        temp = temp.parent

    return None

# Construct Tree
#    1
#   / \
#  2   3
#     / \
#    4   5


root = TreeNode(1, None)
nodeL2 = TreeNode(2, root)
nodeR3 = TreeNode(3, root)
root.left = nodeL2
root.right = nodeR3
nodeL4 = TreeNode(4, nodeR3)
nodeR5 = TreeNode(5, nodeR3)
nodeR3.left = nodeL4
nodeR3.right = nodeR5


nodeA = nodeL4
nodeB = nodeL2

print(findLCA(nodeA, nodeB))
