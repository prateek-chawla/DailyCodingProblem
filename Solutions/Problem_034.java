/*

This problem was asked by Quora.

Given a string, find the palindrome that can be made by 
inserting the fewest number of characters as possible anywhere 
in the word. If there is more than one palindrome of minimum length
that can be made, return the lexicographically earliest one 
(the first one alphabetically).

For example, given the string "race", you should return "ecarace",
 since we can add three letters to it 
 (which is the smallest amount to make a palindrome). 
 There are seven other palindromes that can be made from "race" 
 by adding three letters, but "ecarace" comes first alphabetically.

As another example, given the string "google", 
you should return "elgoogle".

*/

/*
SOLUTION:
idea is to check if first and last indices chars are equal or not, if equal move forward
if not then there comes 2 cases in which we append at last ith index char or we append jth char in front,
and call for recursion,
whichever gives us minimum length will be the current correct answer.
This problem will have overlapping subproblems so used Dp.

TIME COMPLEXITY:O(N^2)
SPACE COMPLEXITY:O(STR.LENGTH()*N^2) CAN BE OPTIMIZED TO O(N^2)
                if we simply store length of subarray in dp array instead of storing substring

*/

public class Problem_034{
    public static void main(String[] args) {
        String str = "google";
        int l = str.length();
        String[][] dp = new String[l][l];

        int k=0;
        for(int i=0;i<l;i++){
            dp[i][k]=Character.toString(str.charAt(i));
            k++;
        }
        k=0;
        for(int tj=1;tj<l;tj++){
            k=0;
            int j = tj;
            while(k<l && j<l){
                if(str.charAt(k)==str.charAt(j)){
                    if(dp[k+1][j-1]==null){
                        dp[k+1][j-1]="";
                    }
                    dp[k][j] = Character.toString(str.charAt(k)) + dp[k+1][j-1] + Character.toString(str.charAt(k));
                }
                else{
                    String temp1 = dp[k+1][j];// can be further optimized if we simply put length in dp array
                    String temp2 = dp[k][j-1];//and access string directly from our main string, LESS MEMORY.
                    if(temp1==null){
                        temp1="";
                    }
                    if(temp2==null){
                        temp2="";
                    }
                    if(temp1.length() < temp2.length()){
                        dp[k][j] = Character.toString(str.charAt(k)) + temp1 + Character.toString(str.charAt(k));
                    }
                    else{
                        dp[k][j] = Character.toString(str.charAt(j)) + temp2 + Character.toString(str.charAt(j));
                    }
                }
                k++;
                j++;
            }
        }
        System.out.println(dp[0][l-1]);
        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[0][2]);
    }
}