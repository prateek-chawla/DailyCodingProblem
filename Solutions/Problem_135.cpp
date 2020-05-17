/*
   Given a binary tree, find a minimum path sum from root to a leaf.
*/


int pathSum(TreeNode*root){
    if(root==NULL)
      return INT_MAX;
    if(!root->left && !root->right)
        return root->val;
    int l=pathSum(root->left);
    int r=pathSum(root->right);
    return min(l,r)+root->val;
}

