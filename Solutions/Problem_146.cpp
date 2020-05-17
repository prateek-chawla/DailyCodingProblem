/*
 Given a binary tree where all nodes are either 0 or 1, prune the tree so that subtrees containing all 0s are removed.

For example, given the following tree:

   0
  / \
 1   0
    / \
   1   0
  / \
 0   0
should be pruned to:

   0
  / \
 1   0
    /
   1
We do not remove the tree at the root or its left child because it still has a 1 as a descendant.
*/

// return a val which will tell that if subtree contains 1 or not if not just point subtree to NULL
class Solution {
public:
    int helper(TreeNode*root){
        if(root==NULL)
            return 0;
        int a=helper(root->left);
        if(a==0)
            root->left=NULL;
        int b=helper(root->right);
        if(b==0)
            root->right=NULL;
        if(a || b || root->val)
            return 1;
        return 0;
    }
    
    TreeNode* pruneTree(TreeNode* root) {
        if(root==NULL)
            return root;
        int val=helper(root);
        if(val==0)
            return NULL;
        return root;
    }
};