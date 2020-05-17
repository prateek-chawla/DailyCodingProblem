/* Given the head of a singly linked list, swap every two nodes and return its head.

For example, given 1 -> 2 -> 3 -> 4, return 2 -> 1 -> 4 -> 3.

*/


class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if(head==NULL || head->next==NULL)
            return head;
        ListNode*head1=head->next;
        ListNode*cur =head->next;
        ListNode*prev=head;
        ListNode*temp=cur->next;
        while(true){
        temp=cur->next;
            cur->next=prev;
            if(temp==NULL || temp->next==NULL)
            {prev->next=temp;
                break;}
        prev->next=temp->next;
            prev=temp;
            cur=temp->next;
        }
        return head1;
    }
};