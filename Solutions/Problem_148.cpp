/* Gray code is a binary code where each successive value differ in only one bit, as well as when wrapping around.
 Gray code is common in hardware so that we don't see temporary spurious values during transitions.

Given a number of bits n, generate a possible gray code for it.

For example, for n = 2, one gray code would be [00, 01, 11, 10].
*/

/* the logic behind gray code is for the grey code of n bit you just have to add 1 and 0 to all the valies of grey code of n-1

   for ex for n=2       for n=3       
   00                    000      100
   01                    001      101
   11                    011      111
   10                    010      110
   
   */

class Solution {
public:
    vector<int> grayCode(int n) {
      vector<int> ans;
        ans.push_back(0);
      for(int i=0;i<n;i++){
          int m=ans.size();
          for(int j=m-1;j>=0;j--){
              ans.push_back(ans[j]|1<<i);
          }
      }
        return ans;
    }
};