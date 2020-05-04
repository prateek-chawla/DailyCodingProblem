'''
Question -->
This problem was asked by Facebook.
Write a function that rotates a list by k elements.
For example, [1, 2, 3, 4, 5, 6] rotated by two becomes [3, 4, 5, 6, 1, 2].
Try solving this without creating a copy of the list.
How many swap or move operations do you need?

Approach -->
Use an element to store two numbers - the number originally at that index
and the number at that index after rotation.
'''


def rotate(arr, k):
    maximum = max(arr)+1
    n = len(arr)
    for i in range(n):
        rotIdx = (i+k) % n
        arr[i] = arr[i] + (arr[rotIdx] % maximum)*maximum

    for i in range(n):
        arr[i] = arr[i]//maximum
    return arr


arr = [1, 2, 3, 4, 5]
k = 3

print("Before Rotation --> ", *arr)
arr = rotate(arr, k)
print("After  Rotation --> ", *arr)
