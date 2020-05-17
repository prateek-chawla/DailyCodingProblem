'''
Question -->
This problem was asked by Microsoft.
Let's represent an integer in a linked list format by
having each node represent a digit in the number.
The nodes make up the number in reversed order.

For example, the following linked list:
1 -> 2 -> 3 -> 4 -> 5
is the number 54321.

Given two linked lists in this format,
return their sum in the same linked list format.

For example, given
9 -> 9
5 -> 2
return 124 (99 + 25) as:

4 -> 2 -> 1

Approach -->
Keep adding carry-over and nodes of both linked lists and
store in a new linked list
'''


class Node:
    # Function to initialize the node object
    def __init__(self, v):
        self.val = v
        self.next = None


class LinkedList:

    @staticmethod
    def numToLinkedList(n):
        head = Node(0)
        temp = head
        while n:
            temp.next = Node(n % 10)
            temp = temp.next
            n = n//10
        return head.next

    @staticmethod
    def linkedListToNum(head):
        temp = head
        num, placeValue = 0, 0
        while temp:
            curr = (10**placeValue)*temp.val
            num = curr+num
            temp = temp.next
            placeValue += 1
        return num

    @staticmethod
    def printLinkedList(head):
        if not head:
            return
        temp = head
        while temp:
            print(temp.val, end=" --> ")
            temp = temp.next

    @staticmethod
    def addLinkedLists(head1, head2):
        if not head1:
            return head2
        if not head2:
            return head1

        head = Node(0)
        temp, temp1, temp2 = head, head1, head2
        carry = 0

        while temp1 or temp2:
            val = 0
            if temp1:
                val += temp1.val
                temp1 = temp1.next
            if temp2:
                val += temp2.val
                temp2 = temp2.next
            val += carry
            carry = val//10
            curr = Node(val % 10)
            temp.next = curr
            temp = temp.next

        if carry:
            temp.next = Node(carry)

        return head.next


head1 = LinkedList.numToLinkedList(909)
head2 = LinkedList.numToLinkedList(99)
head = LinkedList.addLinkedLists(head1, head2)

print(LinkedList.linkedListToNum(head))
LinkedList.printLinkedList(head)
