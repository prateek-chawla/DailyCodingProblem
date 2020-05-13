/*

This problem was asked by Jane Street.

Suppose you are given a table of currency exchange rates, 
represented as a 2D array. Determine whether there is a 
possible arbitrage: that is, whether there is some sequence 
of trades you can make, starting with some amount A of any currency,
so that you can end up with some amount greater than A of that currency.

There are no transaction costs and you can trade 
fractional quantities.

*/ 

/*
SOLUTION:
we can do this question by backtracking method in the search of getting the value of the same currency higher
in further cnversion events.O(N^N)
but we have to run this for every currency O(N*(N^N))
and we know that this is very very high complexity.

but this is similar to graph and we just have to find the distance to the same node
so we can apply dijkstra algorithm to that node by setting curent node(and every other) distance to infinity.
but again we have to apply this algorithm for every currency which means every node.
and we know there is an optimized algorithm for the same purpose i.e. BELLMAN FORD ALGORITHM

SO APPLYING THIS ALGORITHM AND CHECKING FOR EVERY NODE FROM THE RESULTANT ARRAY.
TIME COMPLEXITY: O(N^3)
SPACE COMPLEXITY: O(N^2)
*/

//Ditto Algo/Code as bellman ford , please refer to gfg for exact Algo