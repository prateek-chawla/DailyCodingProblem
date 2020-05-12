'''
Question -->
This problem was asked by Facebook.
Given a binary tree, return all paths from the root to leaves.
For example, given the tree:
   1
  / \
 2   3
    / \
   4   5

Return [[1, 2], [1, 3, 4], [1, 3, 5]].

Approach -->
Use recursion to traverse all the paths and add current path
to list of paths when a leaf node is encountered
'''
# Import Binary Tree defined in Trees.py
from Trees import BinaryTree


def findAllPaths(root, currPath, paths):
    if not root:
        return paths
    if root.left is None and root.right is None:
        currPath.append(root.data)
        paths.append(currPath)
        return paths
    findAllPaths(root.left, currPath+[root.data], paths)
    findAllPaths(root.right, currPath+[root.data], paths)
    return paths


inp = [1, 2, 3, -1, -1, 4, 5, -1, -1, -1, -1]

# Creating a new Tree
tree = BinaryTree()
tree.constructBinaryTree(inp)
root = tree.root

paths = findAllPaths(root, [], [])

print(*paths)
