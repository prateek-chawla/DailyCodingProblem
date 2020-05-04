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


class TreeNode:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.data = key


class BST:
    def __init__(self):
        self.root = None

    def insertNode(self, node):
        def insertNodeUtil(root, node):
            if root is None:
                return node
            else:
                if root.data < node.data:
                    root.right = insertNodeUtil(root.right, node)
                else:
                    root.left = insertNodeUtil(root.left, node)
            return root

        self.root = insertNodeUtil(self.root, node)

    def inOrderTraversal(self):
        inorder = []

        def inOrderTraversalUtil(node):
            if node:
                inOrderTraversalUtil(node.left)
                inorder.append(node)
                inOrderTraversalUtil(node.right)
        inOrderTraversalUtil(self.root)
        return inorder

    def findPairSum(self, target):
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


inp = [12, 3, 11, 41, 41]
target = 15

# Creating a new BST
tree = BST()
for data in inp:
    node = TreeNode(data)
    tree.insertNode(node)

tree.findPairSum(target)
