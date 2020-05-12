'''
Question -->
This problem was asked by Jane Street.
Generate a finite, but an arbitrarily large binary tree quickly in O(1).
That is, generate() should return a tree whose size is unbounded but finite.

Approach -->
Use python lazy properties to generate a tree
Node's left and right are only computed the first time they are accessed,
after that they are stored to prevent repeated evaluations
Reference --> https://stevenloria.com/lazy-properties/
'''

from random import random
NODE_DATA = 0


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.isLeftEvaluated = False
        self.isRightEvaluated = False

    @property
    def left(self):
        if not self.isLeftEvaluated:
            if random() < 0.5:
                self.left = Node(NODE_DATA)
                self.isLeftEvaluated = True
        return self.left

    @property
    def right(self):
        if not self.isRightEvaluated:
            if random() < 0.5:
                self.right = Node(NODE_DATA)
                self.isRightEvaluated = True
        return self.right


def generate():
    return Node(NODE_DATA)
