/*Given a list of points, a central point, and an integer k, find the nearest k points from the central point.

For example, given the list of points [(0, 0), (5, 4), (3, 1)], 

the central point (1, 2), and k = 2, return [(0, 0), (3, 1)].

*/

// You can use max heap of size k. time-O(nlogk) Space-O(k);
// you can also do quickselect to do it in o(n) average time .


class Solution {
public:    
    
   vector<vector<int>> kClosest(vector<vector<int>>& points, int K,vector<int>& central) {
        priority_queue<pair<int, int>> pq;
       vector<vector<int>> ans;
       int x=central[0];
       int y=central[1];
for(int i = 0 ; i != points.size(); i++) {
    int sq = (points[i][0]-x) * (points[i][0]-x) + (points[i][1]-y) * (points[i][1]-y);
    if(pq.size() < K) pq.push({sq, i});
    else {
        if(sq < pq.top().first) {
            pq.pop();
            pq.push({sq, i});
        }
    }
}
while(!pq.empty()) {
    ans.push_back(points[pq.top().second]);
    pq.pop();
}
return ans;
   }
    };