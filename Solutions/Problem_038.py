

# This problem was asked by Microsoft.

# You have an N by N board. Write a function that, given N,
#  returns the number of possible arrangements of the board where 
# N queens can be placed on the board without threatening each other, 
# i.e. no two queens share the same row, column, or diagonal.



class Solution:
    # @param A : integer
    # @return a list of list of strings 
    def crosscheck(self,placed,row,col):
        #checks if particular placed queen conflicts with previously placed queen
        # return true if conflicting else false
        for i in range(row):
            if col==placed[i]:
                return True
            elif row + col == i + placed[i]:
                return True
            elif row - col == i - placed[i]:
                return True
        return False
    def nqueue(self,row,n,placed,fin):
        if row == n:
            fin += [placed[:]]
            return
        for col in range(n):
            if self.crosscheck(placed, row, col):
                continue

            placed[row] = col #do
            self.nqueue(row+1,n,placed,fin)
            placed[row] = -1 #undo
            #backtrack
        return fin
    def solveNQueens(self, A):
        # (placed) stores queens position where index of element tell row of queen and 
        # its value specifies column

        # (final) is where total number of solutions are stored in diff arrays


        final=self.nqueue(0, A, [-1]*A, [])
        
        helper=["."]*A
        result=[]
        #result is developing proper array for final output,it is array1(array2(array3))

        # array1 is whole set, array2 is a solution grid , array3 is that solution rows
        for i in range(len(final)):
            result.append( [] )
            for j in range(A):
                
                result[i].append( helper[:] )
                result[ i ][ j ][ final[i][j] ] = 'Q'
                result[i][j] = "".join( result[i][j] )
        return result

s1 = Solution()
print(s1.solveNQueens(4)) # enter number for NxN board