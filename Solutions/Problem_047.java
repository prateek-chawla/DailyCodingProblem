/*
This problem was asked by Facebook.

Given a array of numbers representing the stock prices of a company in chronological order, 
write a function that calculates the maximum profit you could have made from buying and selling that stock once.
You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars 
and sell it at 10 dollars.
*/

/*
SOLUTION:
the idea is to traverse aarray of prices and keep maintaining an element which is minimum till that point
and then comparing it with current element
if diff is greater then storing it in finalAns variable(which stores max profit)
and keep updating the element which is minimum at every point
Idea is to find two points in array , and subtracting them will create max difference value.

TIME COMPLEXITY:O(N)
SPACE COMPLEXITY:O(1)
*/

public class Problem_047 {
    public static int maxProfit(int[] arr) {
        int minElem = 99999999;
        int maxAns = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < minElem){
                minElem = arr[i];
            }
            else if(arr[i] > minElem){
                maxAns = Math.max( maxAns , arr[i]-minElem );
            }
        }
        return maxAns;
    }
    public static void main(String[] args) {
        int[] arr = {9, 11, 8, 5, 7, 10};
        System.out.println( maxProfit(arr) );
        
    }
}