/*
 Given a list of numbers L, implement a method sum(i, j) which returns the sum from the sublist L[i:j] 
 (including i, excluding j).

For example, given L = [1, 2, 3, 4, 5], sum(1, 3) should return sum([2, 3]), which is 5.

You can assume that you can do some pre-processing. sum() should be optimized over the pre-processing step.
*/

// find the sum upto every index and just find for that range in o(1) by subtracting the sum upto i-1 from sum upto j-1.


class sublistSum{
    public:
    vector<int> ans;
	sublistSum(vector<int> &arr)
	{
	int sum=0;
	for(int i=0;i<arr.size();i++){
		sum+=arr[i];
		ans.push_back(sum);
	   }
   }

   int sum(vector<int> &arr,int i,int j){
   	if(i<0 || j>=arr.size() || i>j || j<=0)
   		 return 0;
   	return ans[j-1]-ans[i-1];
   }
};