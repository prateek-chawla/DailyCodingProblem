/*

This problem was asked by Google.

Given an array of strictly the characters 'R', 'G', and 'B', 
segregate the values of the array so that all the Rs come first, 
the Gs come second, and the Bs come last. 

You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array 
['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become 
['R', 'R', 'R', 'G', 'G', 'B', 'B'].

*/ 

/*
SOLUTION:
so here we are starting from 0 index and using two pointers filling all positions of R 1 st pointer is recording 
where we should put R and 2nd pointer is going in tha array forward and finding next R for us

similar doing for G and their starting indexes are obtained from previous char count

and B is already sorted if ar and g is done
*/
public class Problem_035{
    public static void solution(char[] arr,int index,char ch) {
        int nextpos=index; //2nd pointer which will find the next position of current char ch
        int n = arr.length;
        while(nextpos < n){
            if(arr[index] == ch){
                index++;
                nextpos++;
                continue;
            }
            else{
                while( nextpos<n && arr[nextpos] != ch ){
                    nextpos++;
                }
                if( nextpos == n ){
                    break;
                }
                char temp = arr[nextpos];
                arr[nextpos] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
    }
    public static void main(String[] args) {
        char[] arr = {'G', 'B', 'R', 'R', 'B', 'R', 'G','G', 'B', 'R', 'R', 'B', 'R', 'G'};
        int r=0;
        // int g=0, b=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]=='R'){
                r++;
            }
            // else if(arr[i]=='G'){
            //     g++;
            // }
            // else if(arr[i]=='B'){
            //     b++;
            // }
            
            //technically not required if observed the flow of execution
        }

        solution(arr,0,'R');
        solution(arr,r,'G');
        // solution(arr,r+g,'B'); // no need for this part

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}