/*
This problem was asked by Two Sigma.

Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, 
implement a function rand7() that returns an integer from 1 to 7 (inclusive).
*/

/*
SOLUTION:
idea is to use rand5() to generate numbers from 1 to 35 which is lcm of 5 and 7 and then simply dividing 
or taking mod of the ans by 7 and resultant will be 1 to 7.

*/

public class Problem_045 {
    public static int rand5() {
        int temp = (int)(Math.random()*5)+1;
        while(temp==6){
            temp = (int)(Math.random()*5)+1;
        }
        return temp;
    }
    public static void main(String[] args) {
        System.out.println( (rand5()*6 +rand5())%7 +1);
    }
}