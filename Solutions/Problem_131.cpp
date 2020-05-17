/*Good morning! Here's your coding interview problem for today.

This question was asked by Snapchat.

Given the head to a singly linked list, where each node also has a “random” pointer that points to anywhere in the linked list, deep clone the list.
*/

/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/
// you can make new nodes just next to original nodes and put random pointers as node.next.random=node.random.next
class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head==NULL)
            return NULL;
        Node*temp=head;
        Node*curr;
   while(temp!=NULL){
       Node*n=new Node(temp->val);
       curr=temp->next;
       temp->next=n;
       n->next=curr;
       temp=curr;
   }
  //all the next pointers are cloned just next to all the nodes in original list
   temp=head;
   while(temp!=NULL){
       if(temp->random!=NULL)
         temp->next->random=temp->random->next;
       temp=temp->next->next;
   }
//all the random pointers are cloned as next node is part of cloned list
   Node*cur = head;
   Node*head_cp=head->next;
   Node*cur_cp;
        while (cur != nullptr)
        {
            cur_cp = cur->next;
            cur->next = cur_cp->next;
            cur = cur->next;
            if (cur)
                cur_cp->next = cur->next;
        }
        return head_cp;
// cloned linked list has been extracted  

    }
};