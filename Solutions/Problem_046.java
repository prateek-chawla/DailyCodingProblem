
/*
This problem was asked by Amazon.

Given a string, find the longest palindromic contiguous substring. 
If there are more than one with the maximum length, return any one.

For example, the longest palindromic substring of "aabcdcb" is "bcdcb". 
The longest palindromic substring of "bananas" is "anana".
*/

/*
SOLUTION:
the idea is to traverse over array and check for every element ,making it middle element and going both sides
and finding max length palindrome, and for this checking for both odd and even array like
odd: ***i***
even:***i****
and storing max for comparison and returning max in the end.


TIME COMPLEXITY: O(N^2)
SPACE COMPLEXITY: O(1)
*/

public class Problem_046 {
    public static int check(String str, int i, int j) { //check if current range of string is palindrome
        int count = 0;
        while(i>=0 && j<str.length() ){
            if(str.charAt(i)!=str.charAt(j)){
                return count;
            }
            else{
                count+=2;
            }
            if(i==j){
                count-=1;
            }
            i--;
            j++;
        }
        return count;
    }
    public static String maxPalin(String str) {
        String ans = "";
        int i = 0;
        while(i < str.length()-1 ){
            int odd = check(str,i,i);
            int even = check(str,i,i+1);
            // System.out.println(odd+" "+even);
            if( odd > ans.length() ){
                int temp = (int)(odd/2);
                ans = str.substring(i-temp,i+temp+1);
            }
            if( even > ans.length() ){
                int temp = (int)(even/2);
                ans = str.substring(i-temp+1,i+temp+1);
            }
            i++;
        }
        return ans;
        
    }
    public static void main(String[] args) {
        String str = "aabcdcb";
        System.out.println( maxPalin(str) );
    }
}