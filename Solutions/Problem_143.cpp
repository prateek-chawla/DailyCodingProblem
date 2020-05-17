

/*
  Given a pivot x, and a list lst, partition the list into three parts.

  The first part contains all elements in lst that are less than x
  The second part contains all elements in lst that are equal to x
  The third part contains all elements in lst that are larger than x
*/

//you can maintain three tail pointers and change them within the LL


class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode*less=new ListNode(0);
        ListNode*more=new ListNode(1);
        ListNode*equal=new ListNode(1);
        ListNode*head1=less;
        ListNode*head2=equal;
        ListNode*head3=more;
        while(head!=NULL){
            if(head->val < x){
                less->next=head;
                less=less->next;
            }
            else if(head->val==x){
                equal->next=head;
                equal=equal->next;
            }
             else{
                more->next=head;
                more=more->next;
            }
            head=head->next;
        }
        more->next=NULL;
        less->next=head2->next;
        equal->next=head3->next;
        return head1->next;
    }
};