/*
This problem was asked by Google.

Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. 
If such a subset cannot be made, then return null.

Integers can appear more than once in the list. You may assume all numbers in the list are positive.

For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
*/


/*
SOLUTION:
Idea is to call recurison for first element for array and then make 2 calls in which you take the current element
and in other one you reject it and simply jump to next element
in this way you cover all the posibilities and at the end, you check if currsum is target sum or not,
and space used is for recursion stack.

TIME COMPLEXITY:O(2^N)
SPACE COMPLEXITY:O(N) //Recursion Stack
*/

import java.util.ArrayList;

public class Problem_042 {
    public static void sum(int[] arr,int index, int currSum, int target, ArrayList<Integer> currEle, ArrayList<Integer> ans) {
        if(index >= arr.length){
            if( currSum==target && ans.size()==0 ){
                for(int i=0; i<currEle.size(); i++){
                    ans.add( currEle.get(i) );
                }
            }
            return;
        }
        sum( arr, index+1, currSum, target, currEle, ans);//not considering element

        currEle.add(arr[index]); //do
        currSum+=arr[index];
        sum( arr, index+1, currSum, target, currEle, ans);// considering element
        currEle.remove( currEle.size()-1 ); //undo
        
    }
    public static void main(String[] args){
        int[] arr = {12, 1, 61, 5, 9, 2};
        int target = 24;
        ArrayList<Integer> currEle = new ArrayList<>(); // stores currently elements in my consideration
        ArrayList<Integer> ans = new ArrayList<>(); //stores final answer

        sum( arr , 0, 0, target, currEle, ans);

        if(ans.size()!=0){
            for(int i=0; i<ans.size();i++ ){
                System.out.print( ans.get(i) +" " );
            }
        }


    }
}