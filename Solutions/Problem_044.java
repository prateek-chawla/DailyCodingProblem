
/*
This problem was asked by Google.

We can determine how "out of order" an array A is by counting the number of inversions it has. 
Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, 
a smaller element appears after a larger element.

Given an array, count the number of inversions it has. Do this faster than O(N^2) time.

You may assume each element in the array is distinct.

For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: 
(2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.
*/

/*
SOLUTION:
Idea is to use mergesort and while merging we know all left array elements index < right array indexes
so while merging keeping track of count and simultaneously observing if one element(from left array) 
is bigger than all those elements further in left array will be bigger than right element so adding 
contribution from all elements.

TIME COMPLEXITY:O(NLOGN)
SPACE COMPLEXITY:O(N) // can be improved to O(1) with inplace merge sort technique using mod and divide operators 
and taking max+1 number of the current subarray being merged.
*/

public class Problem_044 {
    public static int count = 0;
    public static void merge(int[] arr, int i, int mid , int j) {
        int l1 = mid-i+1;
        int l2 = j-mid;
        int[] left = new int[l1];
        int[] right = new int[l2];
        for(int k=0;k<l1;k++){
            left[k] = arr[i+k];
        }
        for(int k=0; k<l2 ;k++){
            right[k] = arr[mid+k+1];
        }
        int k=i;
        int leftIndex = 0;
        int rightIndex = 0;
        while( leftIndex < l1 && rightIndex < l2 ){
            if( left[leftIndex] > right[rightIndex]){
                count += l1-leftIndex;
                arr[k] = right[rightIndex];
                rightIndex++;
            }
            else{
                arr[k] = left[leftIndex];
                leftIndex++;
            }
            k++;
        }
        while( leftIndex < l1 ){
            arr[k] = left[leftIndex];
            k++;
            leftIndex++;
        }
        while( rightIndex < l2 ){
            arr[k] = right[rightIndex];
            k++;
            rightIndex++;
        }


    }
    public static void mergeSort(int[] arr ,int i, int j) {
        if(i < j){
            int mid = (int)((i+j)/2);

            mergeSort(arr ,i ,mid); //left side
            mergeSort(arr ,mid+1 , j); //right side

            merge( arr, i , mid , j); //merging both arrays
        }
    }
    public static void main(String[] args) {
        count=0; //global variable and setting it to 0 for every case
        int[] arr = {5,4,3,2,1}; 

        mergeSort(arr,0,arr.length-1);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println();
        System.out.println(count);
    }
    
}