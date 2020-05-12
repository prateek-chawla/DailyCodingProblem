# Helper Class for using Trees

from collections import deque

END_OF_LEVEL = 'END_LEVEL'


class TreeNode:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.data = key



class Tree:
    @staticmethod
    def inOrderTraversal(root):
        inorder = []

        def inOrderTraversalUtil(node):
            if node:
                inOrderTraversalUtil(node.left)
                inorder.append(node)
                inOrderTraversalUtil(node.right)
        inOrderTraversalUtil(root)
        return inorder

    @staticmethod
    def preOrderTraversal(root):
        preorder = []

        def preOrderTraversalUtil(node):
            if node:
                preorder.append(node)
                preOrderTraversalUtil(node.left)
                preOrderTraversalUtil(node.right)
        preOrderTraversalUtil(root)
        return preorder

    @staticmethod
    def postOrderTraversal(root):
        postorder = []

        def postOrderTraversalUtil(node):
            if node:
                postOrderTraversalUtil(node.left)
                postOrderTraversalUtil(node.right)
                postorder.append(node)
        postOrderTraversalUtil(root)
        return postorder

    @staticmethod
    def levelOrderTraversal(root):
        levelorder, currLevel = [], []
        q = deque()
        root = root

        q.append(root)
        q.append(END_OF_LEVEL)

        while q:
            currNode = q.popleft()
            if currNode == END_OF_LEVEL:
                levelorder.append(currLevel)
                currLevel = []
                if not q:
                    break
                else:
                    q.append(END_OF_LEVEL)
            else:
                currLevel.append(currNode.data)
                if currNode.left:
                    q.append(currNode.left)
                if currNode.right:
                    q.append(currNode.right)
        return levelorder

    @staticmethod
    def constructTree(nodeList, idx):
        if idx >= len(nodeList) or nodeList[idx] == -1:
            return None
        data = nodeList[idx]
        newNode = TreeNode(data)
        newNode.left = Tree.constructTree(nodeList, 2*idx+1)
        newNode.right = Tree.constructTree(nodeList, 2*idx+2)
        return newNode

    @staticmethod
    def insertNode(root, node):
        if root is None:
            return node
        else:
            if root.left is None:
                root.left = Tree.insertNode(root.left, node)
            else:
                root.left = Tree.insertNode(root.left, node)
        return root


class BST(Tree):
    def __init__(self):
        self.root = None

    def constructBST(self, nodeList):
        self.root = super().constructTree(nodeList, 0)

    def insertNode(self, node):
        self.root = super().insertNode(self.root, node)

    def inOrderTraversal(self):
        return super().inOrderTraversal(self.root)

    def preOrderTraversal(self):
        return super().preOrderTraversal(self.root)

    def postOrderTraversal(self):
        return super().postOrderTraversal(self.root)

    def levelOrderTraversal(self):
        return super().levelOrderTraversal(self.root)


class BinaryTree(Tree):
    def __init__(self):
        self.root = None

    def constructBinaryTree(self, nodeList):
        self.root = super().constructTree(nodeList, 0)

    def insertNode(self, node):
        self.root = super().insertNode(self.root, node)

    def levelOrderTraversal(self):
        return super().levelOrderTraversal(self.root)
