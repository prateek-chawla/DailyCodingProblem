/*
  Given a node in a binary search tree, return the next bigger element, also known as the inorder successor.

For example, the inorder successor of 22 is 30.

   10
  /  \
 5    30
     /  \
   22    35
You can assume each node has a parent pointer.

*/

node* inorderSucceessor(node* root, node* given){
     if(given->right!=NULL){
         given=given->right;
         while(given->left!=NULL)
           given=given->left;
        return given;
     }
    node* ans=given->parent;
    while(ans!=NULL && given==ans->right){
        given=ans;
        ans=ans->parent;
    }
    return ans;
}
/*If for a node its right part is not null then it's inorder successor will be min value on its right
and if its null it will be one of its parent to find that we go above until we found a node having a left child

IF parent was not given from root we can move on right and left based on, if it is greater or less until it 
become equal to the given node and while going left we will update the ans .
time-O(h) if complete tree ,otherwise O(n);
