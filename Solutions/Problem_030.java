/*
This problem was asked by Facebook.

You are given an array of non-negative integers that represents a 
two-dimensional elevation map where each element is unit-width wall 
and the integer is the height. Suppose it will rain and all spots 
between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) 
time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of 
water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the 
first index, 2 in the second, and 3 in the fourth index 
(we cannot hold 5 since it would run off to the left), 
so we can trap 8 units of water.

*/

/*
SOLUTION:
we can easily do this in time-n and space-n ehich is little optimized
but for constant space 
we have to observe that we need to pick wall smaller from both sides to get the maximum water trapped
instead we can store this in 2 vairables and start from both ends and bigger(suppose at right) wall out 
of them will obviously not trap any water so we can use that wall later and work on smaller one so that 
it is for sure that it has safety from right(suppose) to not overflow and now for smaller one if it is
greater than left side wall we will update left_val variable otherise of smaller than we will add the 
trapped water value in our final ans

TIME COMPLEXITY: O(n)
SPACE COMPLEXITY: O(1)
*/

public class Problem_030 {
    public static int sol(int[] heights) {
        int n = heights.length;
        if(n==1){
            return 0;
        }
        int low = 0; //left side variable
        int high = n-1; //right side variable
        int total=0; //final ans stores total water trapped
        int left_max=-1; //left side max height wall
        int right_max=-1; //right side max height wall

        while( low<=high ) {
            if( heights[low] < heights[high] ){

                if( heights[low] < left_max ){
                    total += left_max-heights[low];
                }
                else{
                    left_max = heights[low];
                }
                low++;
            }
            else{

                if( heights[high] < right_max ){
                    total += right_max-heights[high];
                }
                else{
                    right_max = heights[high];
                }
                high--;
            }

        }
        return total;

    }
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        //0,1,0,2,1,0,1,3,2,1,2,1 example 2
        System.out.println(sol(arr));
    }
}
