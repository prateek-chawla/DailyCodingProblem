'''
Question -->
This problem was asked by Cisco.
Given an unsigned 8-bit integer, swap its even and odd bits.
The 1st and 2nd bit should be swapped, the 3rd and 4th bit should be swapped, and so on.
For example, 10101010 should be 01010101. 11100010 should be 11010001.
Bonus: Can you do this in one line?

Approach -->
1. Left shift the number effectively replacing odd bits with even bits
   Clear out the odd bits by &-ing with 10101010 (175)

2. Right shift the number effectively replacing even bits with odd bits
   Clear out the even bits by &-ing with 01010101 (85)

3. Combine results from 1. and 2. by |-ing them
'''


def swapBits(n):
    # (170)10 = (10101010)2     (85)10 = (01010101)2
    ans = ((170 & (n << 1)) | (85 & (n >> 1)))
    return ans


def binaryRepresentation(n):
    return bin(n).split('0b')[1].rjust(8, '0')


binaryX = '11100010'
x = int(binaryX, base=2)

ans = swapBits(x)
binaryAns = binaryRepresentation(ans)

print("Orignal Number", x, " --> ", binaryX)
print("Swapped Number", ans, " --> ", binaryAns)
