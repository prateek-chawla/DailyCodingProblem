/*

This problem was asked by Google.

The edit distance between two strings refers to the minimum number 
of character insertions, deletions, and substitutions required to 
change one string to the other. For example, the edit distance 
between “kitten” and “sitting” is three: substitute the “k” for “s”,
 substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.

*/

 
/*
SOLUTION:
Idea is to make all the cases of the index
if chars at a particular char of strings are equal we can simply move to next char of both string
but if not equal
we can insert delete and substitute

1st case:INSERT and DELETE are similar operations because if we insert one char in str1 similar to str2 char ,
we need to check now from str2(index+1) and str1(index) because str1(index) can be used again
for any str2 char and str2(index) is used up for str1 new char.
similar above case for deleting str(index)

2nd case: insert in str2 instead of str1 and similar to this case is deleting from str1

3rd case:substituting current char either str1 or str2 and incrementing both str1 and str2 indexes
and minimium of these is selected and in this way we solved our subproblems and 
our problem is solved by selecting min result getting from these cases

TIME COMPLEXITY: O(n^2)
SPACE COMPLEXITY: O(n^2)
*/
public class Problem_031{
    public static int solution(String str1 ,String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp = new int[n1+1][n2+1];
        //making dp grid of both string len+1

        for(int i=0;i<=n1;i++){
            dp[i][0]=i;
        }
        //setting intials because if one string is empty another string has to be empty also and this case
        //is possible if we delete all chars of that string
        for(int i=0;i<=n2;i++){
            dp[0][i]=i;
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){

                if( str1.charAt(i-1)==str2.charAt(j-1) ){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min( dp[i-1][j-1] , Math.min( dp[i-1][j] , dp[i][j-1]) );
                    // selecting min of the three situations where 
                    //we can just move to next element in one of strings(2 case)
                    //or we can simply substitute one of the char in any string(1 case)
                }
            }
        }
        return dp[n1][n2];   
    }
    public static void main(String[] args) {

        String ques = "kitten";
        String ques2 = "sitting";
        System.out.println(solution(ques, ques2));
        
    }
}