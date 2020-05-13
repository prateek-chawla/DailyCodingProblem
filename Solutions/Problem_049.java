
/*
This problem was asked by Amazon.

Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, 
since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.
*/
/*
SOLUTION:
the idea is to traverse the array and adding elements in currSum and whenever it exceeds maxSum , 
we update maxSum.
and whenever currSum reduces to less than 0, it means even if next element addition leads to max value 
but our currsum is reducing it a little bit so turn it again 0 and start considering the 
contiguos arrayagain from next element.

TIME COMPLEXITY:O(N)
SPACE COMPLEXITY:O(1)

*/

public class Problem_049 {
    public static int findSum(int[] arr) {
        int maxSum = 0;
        int currSum=0;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum<0){
                currSum = 0;
            }
            else if (currSum > maxSum){
                maxSum = currSum;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {34, -50, 42, 14, -5, 86};
        System.out.println(findSum(arr));
        
    }
}