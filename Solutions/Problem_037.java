/*

This problem was asked by Google.

The power set of a set is the set of all its subsets. 
Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return 
{{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.

*/
/* 
SOLUTION:
Simple solution is to make 2 calls for every index of array and one call is for selecting that element and 
other is for not selecting that element

If you want print subsets in lexicographic manner 
make a tree for all calls and observe that when recursion call goes from parent 
to left child(selecting eleement) these calls are in lexicographical manner and can be printed these only.

TIME COMPLEXITY: O(2^n)
SPACE COMPLEXITY: O(n) for recursion stack
*/
import java.util.ArrayList;
public class Problem_037{
    public static void solution(ArrayList<ArrayList<Integer>> ans,int index , int[] arr,ArrayList<Integer> curr) {
        if(index>=arr.length){
            
            ans.add( new ArrayList<Integer>() );
            for(int i=0;i<curr.size();i++){
                ans.get(ans.size()-1).add(curr.get(i));
            }
            // ans.add(curr);
            return;
        }
        solution(ans,index+1,arr,curr); //not considering current element
        curr.add(arr[index]);
        solution(ans,index+1,arr,curr); //considering current element
        curr.remove(curr.size()-1);
    }
    public static void main(String[] args){
        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] arr={1,2,3};
        solution(ans,0,arr,curr);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}