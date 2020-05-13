/*

This problem was asked by Google.

Given an array of integers where every integer occurs three times except for one integer, 
which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.

*/

/*
SOLUTION:
The idea is to iterate the whole array for every bit till max bit in any number of array
Iterate over array and and count the number of 0s and 1s in that ith bit, and as you know 
all number are occuring 3 times so observe which bit either count0 or count1 will not be multiple of 3 
and we will know that our final number bit
and start making the final number with every bit observed.

1110
 1   1   1   0
2^3+2^2+2^1+2^0 = 14

TIME COMPLEXITY:O(N*LOG(M)) where M is max element of array and log base is 2
TIME COMPLEXITY:O(1)
*/

public class Problem_040{
    public static void main(String[] args) {
        int[] arr = {6, 10, 3, 3, 3, 6, 6,7,7,7,2,2,2,5,5,5,90,90,90,11,11,11};
        int max=-1;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max , arr[i] );
        }
        int count = 0;
        while(max>0){
            count++;
            max = (int)(max/2);
        }
        int bit = 1;
        int ans = 0;
        while( bit <= count ){
            // int count0 = 0;
            int count1 = 0;
            for(int i=0;i<arr.length;i++){
                int temp = arr[i];
                temp>>=bit-1;
                if(temp%2!=0){
                    count1++;
                }
                // else{
                //     count0++;
                // }
                
                //technically not required if observe execution just here for illustration purposes
            }
            if( count1%3 == 1 ){
                ans += Math.pow(2,bit-1);
            }
            bit++;
        }
        System.out.println(ans);
    }
}