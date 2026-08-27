 Maximmum count of positive integer or negative integer
 // find count of NEGATIVE nums (<0)
 // find the index of the first elem that is >=0,
// because arr is sorted, all elems before this index are negative
        int n = arr.length;
        int lo = 0, hi = n; 
        while(lo<hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid]<0) {// num is neg -- > 
                lo = mid + 1; // go right to find non - neg range 
            }else { // num is >= 0 , search left 
                hi = mid;
            }
        }
        int negCount = lo; // 1st index where elem is >=0= total negatives 
        lo =0; // find positive nums >0
        hi = n;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid]<=0) { // go right if <=0
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        int posCount = n - lo; //Nums of positive elem 
        return Math.max(negCount, posCount);


//Search a 2D matrix
//find total rows and cols in the matrix
        int rows = arr.length, cols = arr[0].length;
        int low = 0, high = rows * cols -1;// find total elem in the matrix
        while(low<=high){
            int mid = (low+high)/2;// find mid index 
            // 1D index (mid) to 2D matrix coordinates (row , col) convert
            int midRow = mid/cols, midCol = mid%cols; 
            if(arr[midRow][midCol] == target) return true; // target found 
            else if(arr[midRow][midCol]> target) high = mid-1;// Agar current element target se bada hai, iska matlab target left half me hoga
            else low = mid +1; // Agar current element target se chhota hai, toh target right half me hoga
        }
         return false; // target not found 


kth missing positive number 
   int low = 0, high = arr.length - 1;// set pointers start to end index 
        while(low<=high){
            int mid = low + (high - low)/2;
            int correctNo = mid + 1 ;// if none of them num miss , toh mid pr mid+1 value hona chahiye 
            int missing = arr[mid] - correctNo;// find miss nums until arr[mid]
            if(missing >= k) high = mid - 1;// if miss count 'k' or greater , than find nums left side 
            else low = mid +1 ;// if miss count 'k' pr lesser ,  than find nums right side  
        }// by end of the loop 'low' find correct position 
        return low + k;


// ROTATE MATRIX BY 90 DEGREE 
        // transpose of matrix
        int n = arr.length;// storerows and col, n x n matrix
        for(int i = 0; i<n;i++){ // iterate each row i
            for(int j  = 0; j<i; j++){// iterate elem below main diagonal, j <i each pair (i,j) swap (j,i) exactly one , avoid double swap
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }// raverse each row horizontally
         for(int i = 0; i<n; i++){// process every row individually
            int stCol = 0, endCol = n -1; // two pointers for column swap
            while(stCol < endCol){
                int temp = arr[i][stCol];// Swap left element with right element
                arr[i][stCol] = arr[i][endCol];
                arr[i][endCol] = temp;
                stCol++;
                endCol--;
            }
        }



// PASCAL'S TRIANGLE 
        // Step 1: Pura Pascal's Triangle store karne ke liye main 2D list banayi
        List<List<Integer>> ans = new ArrayList<>();

        // ===== PASS 1: Triangle ka structure banana =====
        // Har row (i) ke liye ek khali list banayenge aur usme temporary '1' bhar denge
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(1); // Row 'i' mein (i + 1) baar 1 add hoga
            }
            ans.add(list); // Is dummy row ko main triangle list mein add kar diya
        }

        // ===== PASS 2: Middle values calculate aur update karna =====
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // Rule 1: Row ka pehla (j=0) aur aakhri (j=i) element hamesha 1 hota hai
                if (j == 0 || j == i) {
                    ans.get(i).set(j, 1);
                } 
                // Rule 2: Beech ke elements = Upar ke do numbers ka SUM
                else {
                    // ans.get(i-1).get(j)     -> Exactly upar wala number (Right diagonal)
                    // ans.get(i-1).get(j-1)   -> Upar ke left wala number (Left diagonal)
                    int var = ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1); // var = arr[i-1][j]+arr[i-1][j-1]
                    
                    // Old dummy '1' ko hatakay calculate kiya hua sum set kar do
                    ans.get(i).set(j, var);
                }
            }
        }
        // Complete 2D list return kar do
        return ans;


// spiral MATRIX 
        ArrayList<Integer> ans = new ArrayList<>();
        int m = arr.length, n = arr[0].length;
        
        // Define 4 boundary pointers to keep track of the remaining matrix
        int firstRow = 0, lastRow = m - 1, firstCol = 0, lastCol = n - 1;

        // Continue until the boundaries overlap/cross each other
        while (firstRow <= lastRow && firstCol <= lastCol) {
            
            // 1. Move RIGHT along the current top row
            for (int j = firstCol; j <= lastCol; j++) 
                ans.add(arr[firstRow][j]);
            firstRow++; // Top boundary shrinks down

            // Check if boundaries cross before proceeding
            if (firstRow > lastRow || firstCol > lastCol) break;

            // 2. Move DOWN along the current rightmost column
            for (int i = firstRow; i <= lastRow; i++) 
                ans.add(arr[i][lastCol]);
            lastCol--; // Right boundary shrinks left

            // Check if boundaries cross before proceeding
            if (firstRow > lastRow || firstCol > lastCol) break;

            // 3. Move LEFT along the current bottom row
            for (int j = lastCol; j >= firstCol; j--) 
                ans.add(arr[lastRow][j]);
            lastRow--; // Bottom boundary shrinks up

            // Check if boundaries cross before proceeding
            if (firstRow > lastRow || firstCol > lastCol) break;

            // 4. Move UP along the current leftmost column
            for (int i = lastRow; i >= firstRow; i--) 
                ans.add(arr[i][firstCol]);
            firstCol++; // Left boundary shrinks right
        }
        
        return ans;


// Factorial trailing zeroes
        // Keeps track of the total count of trailing zeroes
        int zeroes = 0; 

        // Loop until n is reduced to 0
        // Each iteration processes the next power of 5 (5, 25, 125, ...)
        while (n > 0) {
            // Count how many multiples of 5 exist in the current range
            // Iteration 1: counts multiples of 5   (5, 10, 15, 20, 25...)
            // Iteration 2: counts multiples of 25  (25, 50, 75...)
            // Iteration 3: counts multiples of 125 (125, 250...)
            zeroes += n / 5; 
            // Divide n by 5 to move to the next power of 5 in the next iteration
            n /= 5; 
        } 
        // Return the final calculated count of trailing zeroes
        return zeroes; 
    } 
}



/// UNIQUE PATHS , M = ROWS , N = COLUMNS 
//// TRY AGAIN THIS PROBLEM , AFTER START DP
// 

        // DP Table: path[i][j] stores the number of unique paths to reach cell (i, j)
        int[][] path = new int[m][n];

        // Iterate through every cell in the m x n grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                // Base Case: First row or first column cells only have 1 path 
                // (moving strictly right or strictly down)
                if (i == 0 || j == 0) {
                    path[i][j] = 1;
                } 
                // Transition Relation: Current cell paths = paths from Top + paths from Left
                else {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }

        // Return the accumulated total paths for the bottom-right target cell
        return path[m - 1][n - 1];
    }
}


// Set/array ,ismatch 

class Solution {
    public int[] findErrorNums(int[] arr) {
        int n = arr.length;
        int i = 0;

        // --- STEP 1: CYCLIC SORT ---
        // Since values range from 1 to n, each number 'x' belongs at index 'x - 1'.
        // We place every element into its correct index via swapping.
        while (i < n) {
            // Calculate where arr[i] ought to live in a zero-indexed array
            int idx = arr[i] - 1; 

            // If current number is NOT at its correct target index, swap it
            if (arr[i] != arr[idx]) {
                swap(arr, i, idx); 
            } else {
                // If it's already in the correct place (or a duplicate of it is), move forward
                i++;
            }
        }

        // --- STEP 2: FIND DUP & MISSING ---
        // Iterate through sorted array to find the index that holds the wrong number
        for (i = 0; i < n; i++) {
            // If the element at index i doesn't equal (i + 1):
            if (arr[i] != i + 1) {
                // arr[i] is the Duplicate number (occupying someone else's spot)
                // (i + 1) is the Missing number (the expected value for index i)
                return new int[] {arr[i], i + 1};
            }
        }

        // Default fallback (won't be reached under valid test constraints)
        return new int[]{-1, -1};
    }

    // Helper method to swap elements at indices i and idx
    public static void swap(int[] arr, int i, int idx) {
        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }
}
