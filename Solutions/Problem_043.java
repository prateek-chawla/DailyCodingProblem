/*
This problem was asked by Amazon.

Implement a stack that has the following methods:

--push(val), which pushes an element onto the stack

--pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, 
then it should throw an error or return null.

--max(), which returns the maximum value in the stack currently. If there are no elements in the stack, 
then it should throw an error or return null.

Each method should run in constant time.
*/
/*
SOLUTION:
idea is to store 2*currElement-Previousmax if we found element which is greater than our max
in this way , when popping this element we will know that this contains max element and after popping this one 
max element will change because 2*currele-prev_maxele > currele.

note:x+maxele will fail for negative numbers in finding max element
similarly x-minele will alsofail for negative numbers in finding min element.

TIME COMPLEXITY:O(N)
SPACE COMPLEXITY:O(N)
OPERATIONS:O(1)
*/


import java.util.ArrayList;
class stackempty extends Exception{

}
class stack{
    ArrayList<Integer> arr;
    int maxi;
    stack(){
        arr = new ArrayList<>();
        maxi = -10000000;
    }
    void push(int val){
        if(val > maxi ){
            arr.add(2*val - maxi);
            maxi = val;
            return;
        }
        arr.add(val);
    }
    int size(){
        return arr.size();
    }
    int pop() throws stackempty{
        if( size()==0 ){
            throw new stackempty();
        }
        int temp = arr.get( size()-1 );
        arr.remove( size()-1 );
        if(temp > maxi){
            maxi = 2*maxi - temp;
            return (int)((temp+maxi)/2);
        }
        return temp;
    }
    int getMax(){
        return maxi;
    }
    int peek(){
        return arr.get( size()-1 );
    }

}
public class Problem_043 {
    public static void main(String[] args) throws stackempty{
        stack stack = new stack();

        stack.push(3); 
        stack.push(5) ; 
        System.out.println("max:" + stack.getMax() );
        stack.push(7) ;
        stack.push(19) ;
        System.out.println("max:" + stack.getMax() );
        stack.pop() ;
        System.out.println("max:" + stack.getMax() );
        stack.pop()  ;
        System.out.println("peek:" + stack.peek() );
        
    }
    
}