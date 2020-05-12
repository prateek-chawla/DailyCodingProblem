'''
Question -->
This problem was asked by Google.
Given the root of a binary search tree, and a target K,
return two nodes in the tree whose sum equals K.
For example, given the following tree and K of 20

    10
   /   \
 5      15
       /  \
     11    15
Return the nodes 5 and 15.

Approach -->
The inorder traversal of a BST gives the elements of the tree
in non-decreasing order. Use two pointers to traverse the sorted list
and find the sum pair.
'''

# Import BST defined in Trees.py
from Trees import BST


def findPairSum(target):
    inorder = tree.inOrderTraversal()
    i, j = 0, len(inorder)-1
    while i < j:
        left, right = inorder[i].data, inorder[j].data
        if left+right == target:
            print(left, right)
            return
        if left+right > target:
            j -= 1
        else:
            i += 1
    print("No such pair found")


inp = [12, 3, 31, -1, 11, -1, 41, -1, -1, -1, -1]
target = 15

# Creating a new BST
tree = BST()
tree.constructBST(inp)

findPairSum(target)
