// Maximmum count of positive integer or negative integer
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

// Search a 2D matrix
// find total rows and cols in the matrix
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
