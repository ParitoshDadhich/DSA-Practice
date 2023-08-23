// Time: O(log(m*n))
// Space: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        if(col == 0)
            return false;
        
        if(row == 1)
            return bSearch(matrix, 0, 0, col-1, target);
        
        // setting upper and lower bounds
        int rStart = 0;
        int rEnd = row-1;
        int cMid = col/2;

        // runs loop till number of row becomes 2
        while(rStart < (rEnd-1)){
            int mid = rStart + (rEnd-rStart)/2;

            if(matrix[mid][cMid] == target)
                return true;
            
            if(matrix[mid][cMid] > target)
                rEnd = mid;
            else
                rStart = mid;
        }


        // now we have 2 rows
        // checking whether the target is int the col of 2 rows
        if(matrix[rStart][cMid] == target)
            return true;
        if(matrix[rEnd][cMid] == target)
            return true;
        
        // checking in the 4 parts
        // 1st part
        if(cMid > 0 && target <= matrix[rStart][cMid-1] && target >= matrix[rStart][0] )
            return bSearch(matrix, rStart, 0, cMid-1, target);
        
        // 2nd part
        if(cMid < col-1 && target >= matrix[rStart][cMid+1] && target <= matrix[rStart][col-1])
            return bSearch(matrix, rStart, cMid+1, col-1, target);

        // 3rd part
        if(cMid > 0 && target <= matrix[rStart+1][cMid-1] && target >= matrix[rStart+1][0] )
            return bSearch(matrix, rStart+1, 0, cMid-1, target);
        
        // 4th part
        else
            return bSearch(matrix, rStart+1, cMid+1, col-1, target);
    }

    private boolean bSearch(int matrix[][], int row, int cStart, int cEnd, int target){

        if(cStart > cEnd)
            return false;

        int mid = cStart + (cEnd-cStart)/2;

        if(matrix[row][mid] == target)
            return true;
        
        if(matrix[row][mid] > target)
            return bSearch(matrix, row, cStart, mid-1, target);
        else
            return bSearch(matrix, row, mid+1, cEnd, target);
    }
}
