/*
  Given an array of integers in which two elements appear exactly once and all other elements appear 
  exactly twice, find the two elements that appear only once.

For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.

Follow-up: Can you do this in linear time and constant space?
*/


/*
  By XORing all the numbers you get the XOR value of exact two numbers there must be a set bit in it as
  the numbers are diff so if you can find the position of the first set bit and for all the values
  you divide them in two groups having that bit as 0 ana 1 so at the end as other numbers will be equal
  they will XOR out and you will be left with the two numbers 
*/





class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int n=nums.size();
        long long int val=0;
        for(auto it:nums)
            val=val^it;
        int mask = (val & (-val));
    int a=0;
    int b=0;
    for(auto it:nums){
        if(mask&it)
            a=a^it;
        else
            b=b^it;
    }
    return {a,b};      
    }
};

/*
There is a little trick here to get last bit equal 1 from the result XOR.
see if we get XOR = aaaa1000(a = 1 or 0)
we could get the first(from low to high) bit equals 1 as follow:
first:~XOR = bbbb0111 (b = ~a)
then add 1, with carrying bits~XOR + 1 = bbbb1000
then, XOR & (~XOR + 1) = 00001000
so we can write as XOR & (-XOR)also.
*/