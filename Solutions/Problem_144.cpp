/* 
 Given an array of numbers and an index i, return the index of the nearest larger number of the number at index i, where distance is measured in array indices.

For example, given [4, 1, 3, 5, 6] and index 0, you should return 3.
*/

// if single query is there you can start traversing from ind to its left and right but for many queries you have to preprocess it.
int greaterElement(vector<int> nums, int ind){
	int n=nums.size();
	stack<int> st;
	int ans[n]={-1};
	for(int i=0;i<n;i++){
        while(!st.empty() && nums[i]>nums[st.top()])
        	{ans[st.top()]=i;//putting next greater element for every index on its right
            st.pop();}
        st.push(i);
	}
	while(!st.empty())
		st.pop();// clearing the stack

	for(int i=n-1;i>=0;i--){
		while(!st.empty() && nums[i]>nums[st.top()])// putting next greater element on left 
        	{   if(ans[st.top()]!=-1)
        		    ans[st.top()]=min(ans[st.top()]-st.top(),st.top()-i);//comparing for the min dist on left and right for index
        		else
        			ans[st.top()]=i;
            st.pop();}
        st.push(i);
	}
	return ans[ind];

}