/*
 Design and implement a HitCounter class that keeps track of requests (or hits). It should support the following operations:

record(timestamp): records a hit that happened at timestamp
total(): returns the total number of hits recorded
range(lower, upper): returns the number of hits that occurred between timestamps lower and upper (inclusive)

*/


class HitCounter{
    public:
    vector<int> hits;
    
    void record(int time)
     { 
         hits.push_back(time);   // O(1)
     }

     int total(){
         return hits.size();     // O(1)
     }
      int search(int val){
         int s=0;
         int e=hits.size()-1;
         while(s<=e){
             int mid=s + (e-s)/2;
             if(hits[mid]==val)
                return mid+1;
             if(hits[mid]>val)
                e=mid-1;
             else
               s=mid+1;
         }
         return e+1;
     }
     
     int range(int lower,int upper){  // O(log total)
         int start=search(lower);
         int end=search(upper);
         if(start!=0 && hits[start-1]==lower)
             start--;
         return end-start;
     }

}
