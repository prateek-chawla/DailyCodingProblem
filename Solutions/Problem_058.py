'''
Question -->
This problem was asked by Amazon.
An sorted array of integers was rotated an unknown number of times.
Given such an array, find the index of the element in the array in
faster than linear time. If the element doesn't exist in the array,
return null.
For example, given the array [13, 18, 25, 2, 8, 10] and the element 8,
return 4 (the index of 8 in the array).
You can assume all the integers in the array are unique.

Approach -->
Use Binary Search to find index in rotated array

'''


def search(arr, val):

    start = 0
    end = len(arr)-1

    while start <= end:
        mid = (start+end)//2

        if arr[mid] == val:
            return mid

        if arr[mid] >= arr[start]:
            if arr[mid] >= val and arr[start] <= val:
                end = mid-1
            else:
                start = mid+1
        else:  # A[mid]<A[start]
            if arr[mid] <= val and arr[start] > val:
                start = mid+1
            else:
                end = mid-1

    return None
