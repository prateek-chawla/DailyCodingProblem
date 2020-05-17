/*
Implement a bit array.

A bit array is a space efficient array that holds a value of 1 or 0 at each index.

init(size): initialize the array with size
set(i, val): updates index at i with val where val is either 1 or 0.
get(i): gets the value at index i.
*/

/* as each int takes 32 bits so storing each value at separate index will waste 31 bits as you need to store
  only 0 or 1 so for every index we will put values at each bit
*/

class bitArray{
    public:
    int * arr;
    bitArray(int size){
        req_size=size/32 + 1;
        arr=new int[req_size];
    }
    void set(int index,int val){
        int ind=index/32;
        int pos=index%32;
        pos= 1<<pos;
        if(val==1)
        arr[ind]=arr[ind] | pos;
        pos=~pos;
        if(val==0)
          arr[ind]=arr[ind] & pos;
    }
    int get(int index){
        int ind=index/32;
        int pos=index%32;
        pos=1<<pos;
        return arr[ind]&pos;
    }
}
