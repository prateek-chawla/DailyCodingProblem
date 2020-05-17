/*
 You have a large array with most of the elements as zero.

Use a more space-efficient data structure, SparseArray, that implements the same interface:

init(arr, size): initialize with the original large array and size.
set(i, val): updates index at i with val.
get(i): gets the value at index i.
 */

// use a map to store values which are not 0;

class sparseArray{

    unordered_map<int,int> sparse;
    public:
    void init(int arr[],int size){
        for(int i=0;i<size;i++){
            if(arr[i]!=0)
              sparse[i]=arr[i];
        }
    }

    void set(int ind,int val){
        if(val!=0)
          sparse[ind]=val;
    }
    
    int get(int ind){
        if(sparse.find(ind)==sparse.end())
           return 0;
        return sparse[ind];
    }
}