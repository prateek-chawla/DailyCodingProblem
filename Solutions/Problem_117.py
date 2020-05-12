'''
Question -->
This problem was asked by Facebook.
Given a binary tree, return the level of the tree with minimum sum.

Approach -->
Traverse all the levels using a queue
and maintain minimum level sum for each level

For example, given the tree:
   10
  / \
 2   13
    / \
   4   5

Return 9
'''

# Import Binary Tree defined in Trees.py
from Trees import BinaryTree


def minLevelSum(tree):
    levels = tree.levelOrderTraversal()  # Returns list of all the levels in the tree
    minSum = float('inf')
    for level in levels:
        minSum = min(minSum, sum(level))
    print(minSum)


inp = [10, 2, 13, -1, -1, 4, 5, -1, -1, -1, -1]

# Creating a new Tree
tree = BinaryTree()
tree.constructBinaryTree(inp)
root = tree.root

if not root:
    print("Empty Tree")
else:
    minLevelSum(tree)
