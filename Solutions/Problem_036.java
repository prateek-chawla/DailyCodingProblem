/*

This problem was asked by Dropbox.

Given the root to a binary search tree, 
find the second largest node in the tree.

*/

/*
SOLUTION:
Idea is to traverse whole tree and at every node , we will have 5 data points
2 large points from left branch of that node
2 large points from right branch
1 is the node data itself
find 2 largest nodes from these 5 and return them.

TIME COMPLEXITY:O(N)
SPACE COMPLEXITY:O(logN) //recursion call stack
*/

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int d, TreeNode l, TreeNode r){
        d = data;
        left = l;
        right = r;
    }
}
class ans{
    int large1;
    int large2;
    ans(int l1,int l2){
        large1 = l1;
        large2 = l2;
    }
}
public class Problem_036{
    public static ans compare(ans a1, ans a2, int a) {
        int temp = Math.max( a, Math.max( a1.large1, a2.large1 ));
        int temp2 = -1000000;
        if(temp == a){
            temp2 = Math.max( a1.large1, a2.large1);
        }
        else if(temp == a1.large1){
            temp2 = Math.max(a, Math.max( a1.large2, a2.large1 ));
        }
        else if(temp == a2.large1){
            temp2 = Math.max(a, Math.max( a1.large1, a2.large2 ) );
        }
        return new ans(temp, temp2);
    }
    public static ans findMax(TreeNode root) {
        if(root==null){
            return new ans(-100000000,-100000000);
        }
        ans left = findMax(root.left);
        ans right  = findMax(root.right);
        return compare(left, right, root.data);
    }

    // you can test this function using problem_048 class,all funcions are implemented there
    //just import this class in that file and run this max function on the tree.
}