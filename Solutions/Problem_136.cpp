/*
Given an N by M matrix consisting only of 1's and 0's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

[[1, 0, 0, 0],
 [1, 0, 1, 1],
 [1, 0, 1, 1],
 [0, 1, 0, 0]]
Return 4.
*/

/* we will move row by row and for every row form a histogram with base as that row and height as
  longest continous 1's from that and for a histogram formed we will find largest rectangle in it 
   by taking every bar as height and max width it can be extended on its left and right i.e first smaller 
 value on left and right
*/

int histo(vector<int> A) {
    int n=A.size();
    stack<int> st;
    int right[n];
    int left[n];
    for(int i=n-1;i>=0;i--){    // 2 1 5 6 2 3               1 -1 4 4 -1 -1
        int val=A[i];
        if(!st.empty()){
            while(!st.empty() && val<=A[st.top()]){
                st.pop();
            }
        }
        if(st.empty())
          right[i]=-1;
        else         
         right[i]=st.top();
        st.push(i);
    }
    while(!st.empty())
      st.pop();
     for(int i=0;i<n;i++){    // 2 1 5 6 2 3                 -1 -1 1 2 1 4
        int val=A[i];
        if(!st.empty()){
            while(!st.empty() && val<=A[st.top()]){
                st.pop();
            }
        }
        if(st.empty())
          left[i]=-1;
        else
         left[i]=st.top();
        st.push(i);
    }
    int ans=0;
    for(int i=0;i<n;i++){
        int l,r;
        if(left[i]==-1)
         l=i;
        else
         l=i-left[i]-1;
        if(right[i]==-1)
         r=n-i-1;
        else
         r=right[i]-i-1;
        l=l*A[i];
        r=r*A[i];
        int val=l+r+A[i];
        if(val>ans)
         ans=val;
        //cout<<l<<","<<r<<","<<val<<" ";
    }
    return ans;
    
}

int Solution::solve(vector<vector<int> > &A) {
    int n=A.size();
    int m=A[0].size();
    for(int i=0;i<m;i++){
        int sum=0;
        for(int j=0;j<n;j++){
            if(A[j][i]==0)
             sum=0;
            else
             {A[j][i]=sum+A[j][i];
             sum++;}
        }
    }
    int ans=0;
    for(int i=0;i<n;i++){
        int val=histo(A[i]);
        if(val>ans)
         ans=val;
    }
    return ans;
}
