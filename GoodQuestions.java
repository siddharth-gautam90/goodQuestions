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
