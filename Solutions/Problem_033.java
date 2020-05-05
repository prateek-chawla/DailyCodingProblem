/*

This problem was asked by Microsoft.

Compute the running median of a sequence of numbers. 
That is, given a stream of numbers, print out the 
median of the list so far on each new element.

Recall that the median of an even-numbered list is the 
average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], 
your algorithm should print out:

2
1.5
2
3.5
2
2
2

*/

/*
SOLUTION:
the idea is to use 2 heaps :one max and one min
which stores 50%(approx) of the numbers each
when total elements are odd
left which is max heap will store one extra element than right
when total are even
both will store equal
when ever new elements comes , it is added in right i.e. min heap and elements will be shifted to maintain order

TIME COMPLEXITY:O()
SPACE COMPLEXITY:O()

*/
import java.util.Collections;
import java.util.PriorityQueue;

public class Problem_033{
    public static void solution(int[] arr,int n) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int total=0;
        for(int i=0;i<n;i++){
            total++;
            right.add(arr[i]);
            if(total%2!=0){
                left.add(right.peek());
                right.poll();
            }

            while( left.size()!=0 && right.size()!=0 &&  left.peek() > right.peek() ){
                int temp = left.poll();
                left.add(right.poll());
                right.add(temp);
            }
            // if you look closely and observe the pattern, you will see that above loop will not run many times
            // and it will be enough to run once or max twice just to maintain the icoming element
            // instead of above loop , we can put incomging element directly into left heap if it is smaller than 
            //smallest element off right heap

            if(total%2==0){
                int temp = left.peek();
                int temp2 = right.peek();
                System.out.println(((temp+temp2)/2.0)+" ");
            }
            else{
                System.out.println(left.peek()+" ");
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 7, 2, 0, 5,3,7,9,1,5,8,2,3,0,9,1};
        solution( arr, arr.length );
    }
}
