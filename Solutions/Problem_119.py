'''
Question -->
This problem was asked by Google.

Given a set of closed intervals,
find the smallest set of numbers that covers all the intervals.
If there are multiple smallest sets, return any of them.

For example, given the intervals [0, 3], [2, 6], [3, 4], [6, 9],
one set of numbers that covers all these intervals is {3, 6}

Approach -->
0  1  2  3  4  5  6  7  8  9
<-------->
      <----------->
         <-->
                  <-------->

Find the interval that ends first, say IntervalX
Every interval to the left of IntervalX can be represented by this interval's
end value, say minEnd.
[minEnd,minEnd] can represent all the intervals till IntervalX.
Now we have to only include intervals which start after this IntervalX,
The interval which starts last will be the maximum number to be included
'''


def findSmallestSet(intervals):
    if not intervals:
        return []
    minEnd, maxStart = None, None
    for interval in intervals:
       # Swap if an interval is in descending order [12,6] => [6,12]
        if interval[0] > interval[1]:
            interval[0], interval[1] = interval[1], interval[0]
      # Find minEnd and maxStart
        if minEnd is None:
            minEnd = interval[1]
            maxStart = interval[0]
        else:
            minEnd = min(minEnd, interval[1])
            maxStart = max(maxStart, interval[0])

    maxStart = maxStart if maxStart > minEnd else minEnd

    return [minEnd, maxStart]


intervals = [[0, 3], [6, 12], [3, 4], [6, 9]]
print(*findSmallestSet(intervals))
