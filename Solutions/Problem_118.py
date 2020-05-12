'''
Question -->
This problem was asked by Google.
Given a sorted list of integers, square the elements
and give the output in sorted order.

For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].

Approach -->
Use two pointers (intialised with the extremes of the list)
and compare their absolute value and add to the list accordingly
'''

def sortedSquared(arr,n):
    i,j=0,n-1
    res=[0 for _ in range(n)]
    resIdx=n-1
    while i<=j:
        if abs(arr[i])>=abs(arr[j]):
            res[resIdx]=arr[i]*arr[i]
            i+=1
        else:
            res[resIdx]=arr[j]*arr[j]
            j-=1
        resIdx-=1
    return res


inp=[-9, -2, 0, 2, 3]
print("Before --> ",*inp)

res=sortedSquared(inp,len(inp))
print("After  --> ",*res)
