
/* You're given a string consisting solely of (, ), and *. * can represent either a (, ), or an empty string. 
   Determine whether the parentheses are balanced.

For example, (()* and (*) are balanced. )*( is not balanced.

*/

/* if there was no * you can take two pointers open and close and iterate from left, inc open if '(' occurs and close if
 ')' occurs and if at any point close becomes greater than open than its not possible so return false
  and at end just check if open==close.

  now if * occurs there are three ways you can take it to be '(',')' or '' so there will be three path from a value
  open+1,close+1,or as it is. so if you you take all the paths and at end check if any value in it is 0 then return
  true. Instead of taking all the values you can take a range as all values will always be continous only and
  maintain max and min and at end just check if min == 0;
  */


class Solution {
public:
    bool checkValidString(string s) {
       int n=s.length();
        int low=0;
        int high=0;
        for(int i=0;i<n;i++){
            if(s[i]=='(')
            {
                low++;
                high++;
            }
            else if(s[i]==')')
            {
                low--;
                high--;
            }
            else{
                high++;
                low--;
            }
            if(high<0)
                return false;
            low=max(low,0);
        }
        if(low==0)
            return true;
        return false;
    }
};