
/*
This problem was asked by Google.

Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

For example, given the following preorder traversal:

[a, b, d, e, c, f, g]

And the following inorder traversal:

[d, b, e, a, f, c, g]

You should return the following tree:

    a
   / \
  b   c
 / \ / \
d  e f  g
*/

/*
SOLUTION:
Idea is to pick first element of preorder(root,left,right) and search that element in inorder(left,root,right)
when found its index in inorder, divide inorder array in left and right and 
do this similarly with the help of recursion.

TIME COMPLEXITY:O(N^2)
SPACE COMPLEXITY:O(logN) //recursion stack

However, time complexity can be improved if we put all elements of inorder into hashmap for O(1) search.
**Improved time will be O(N) ans space will be O(N).**
*/


class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int d, TreeNode l, TreeNode r){
        data = d;
        left = l;
        right = r;
    }
}

public class Problem_048 {
    public static int search( int[] arr, int find ,int st, int end) {
        for(int i=st; i<=end; i++){
            if( arr[i] == find ){
                return i;
            }
        }
        return -1; // will never come here
    }
    public static TreeNode construct(int[] preOrder, int[] inOrder, int[] index, int start, int end) {
        if(index[0]>=preOrder.length || end < start){
            return null;
        }
        int inorderIndex = search(inOrder , preOrder[index[0]] ,start, end);
        
        TreeNode currNode = new TreeNode( preOrder[index[0]] ,null ,null );

        index[0]++;
        TreeNode left = construct( preOrder, inOrder, index, start, inorderIndex-1);
        if(left==null){
            index[0]--;
        }

        index[0]++;
        TreeNode right = construct( preOrder, inOrder, index, inorderIndex+1, end);
        if(right==null){
            index[0]--;
        }

        currNode.left = left;
        currNode.right = right;

        return currNode;
    }
    public static void inorder(TreeNode root) {
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int[] preOrder = {1,2,4,5,3,6,7};
        int[] inOrder = {4,2,5,1,6,3,7};
        int[] index = new int[1]; //index for preorder array

        TreeNode root = construct( preOrder, inOrder, index, 0, preOrder.length);

        inorder(root); //print
        
    }
}