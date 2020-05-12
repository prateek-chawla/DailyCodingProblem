'''
Question -->
This problem was asked by Google.
Given two non-empty binary trees s and t, check whether tree t has
exactly the same structure and node values with a subtree of s.
A subtree of s is a tree consists of a node in s and all of
this node's descendants. The tree s could also be considered as a subtree of itself.

Approach -->
Check if t is a subtree of s , return True if Yes ,else check recursively for
left and right child of s

s
     1
    / \
   2   3
  / \
 4   5

 t
    2
   / \
  4   5

'''
# Import Binary Tree defined in Trees.py
from Trees import BinaryTree

def compareTrees(rootS,rootT):
    if not rootS and not rootT:
        return True
    if not rootS or not rootT:
        return False
    if rootS.data != rootT.data:
        return False
    return compareTrees(rootS.left,rootT.left) and compareTrees(rootS.right,rootT.right)

def isSubtree(rootS, rootT):

    if compareTrees(rootS,rootT):
        return True
    return compareTrees(rootS.left,rootT) or compareTrees(rootS.right,rootT)

s=[1,2,3,4,5,-1,-1,-1,-1,-1,-1]
treeS=BinaryTree()
treeS.constructBinaryTree(s)
rootS=treeS.root

t=[2,4,5,-1,-1,-1,-1]
treeT=BinaryTree()
treeT.constructBinaryTree(t)
rootT=treeT.root

print(isSubtree(rootS,rootT))










