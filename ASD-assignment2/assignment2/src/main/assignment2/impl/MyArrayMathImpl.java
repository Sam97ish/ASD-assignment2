package main.assignment2.impl;

import main.assignment2.*;

public class MyArrayMathImpl implements ArrayMath {
    private int CUTOFF = 10;

    /**
     * @complexity: average O(N), worst-case O(NLogN).
     * @param array1 - first array
     * @param array2 - second array
     * @return true if array1, array2 are the same collection
     */
    @Override
    public boolean isSameCollection(int[] array1, int[] array2) {
	// TODO Auto-generated method stub

        int size1 = array1.length;
        int size2 = array2.length;

        if(size1 != size2){
            return false;
        }

        MyHashTableImpl<Integer,Integer> hash1 = new MyHashTableImpl<>(0.5);
        MyHashTableImpl<Integer,Integer> hash2 = new MyHashTableImpl<>(0.5);

        for(int i = 0; i < size1; i++){// insert is average case O(1) * N (size of array).
            hash1.insertForIsSame(array1[i], 1);
            hash2.insertForIsSame(array2[i], 1);
        }

        boolean Notsame = false;

        for(int i = 0; i < size1 & !Notsame; i++) {
            Integer value = hash1.contains(array2[i]);
            Integer value2 = hash2.contains(array2[i]);
            if (value == null || value2 == null){
                Notsame = true;
            } else {
                Notsame = !value.equals(value2);
            }
        }

       /* boolean same = true;
        for(int i = 0; i < size1 & same; i++){ // contains is average time O(1) * N (size of array).

            Integer value1 = hash1.contains(array2[i]);
            Integer value2 = hash2.contains(array2[i]);

            if(value1 == null || value2 == null){
                same = false;
            }else{
                same = value1.equals(value2);
            }

        }*/

        return !Notsame;
    }

    /**
     * @complexity: worse-case O(NlogN)
     * @param array1 - provided array
     * @param array2 - provided array
     * @return the diff between the values of arr1, arr2.
     */
    @Override
    public int minDifferences(int[] array1, int[] array2) {
	// TODO Auto-generated method stub
        int size1 = array1.length;
        int size2 = array2.length;

        BinaryHeap heap1 = new BinaryHeap(size1+1);
        BinaryHeap heap2 = new BinaryHeap(size2+1);

        for(int i = 0; i < size1; i++){
            // worst-case O(NLogN);
            heap1.insert(array1[i]);
            heap2.insert(array2[i]);
        }
        int sum = 0;
        for(int i = 0; i< size1; i++){// worst case O(NLogN) because deleteMin is O(LogN) each.
            int first= heap1.deleteMin();
            int second = heap2.deleteMin();
            int both = first - second;
            both *= both;
            sum += both;
        }
	return sum;
    }

    /**
     * @role: swaps the two values in the array a.
     * @param a - array
     * @param first - first index
     * @param sec - second index
     */
    private void swapReferences(Integer[] a, int first, int sec){
        Integer tmp = a[first];
        a[first] = a[sec];
        a[sec] = tmp;
    }

    /***
     * @role: orders the left right and median and hides the pivot.
     * @param a - array
     * @param left - left index
     * @param right - right index
     * @return median (pivot).
     */
    private int median3(Integer[] a, int left, int right){
        int center = (left+right) / 2;

        if(a[center].compareTo(a[left]) < 0){
            swapReferences(a, left, center);
        }
        if(a[right].compareTo(a[left]) < 0){
            swapReferences(a, left, right);
        }
        if(a[right].compareTo(a[center]) < 0){
            swapReferences(a, center, right);
        }

        //place pivot at position right-1.
        swapReferences(a, center, right-1);

        return a[right-1]; // pivot

    }

    /**
     * @role sorts the demanded range so that the correct percentile be returned.
     * @param a - array
     * @param left - left index
     * @param right - right index
     * @param lowerbound - lowerbound
     * @param upperbound - upperbound
     * @complexity: average O(N).
     */
    private void quickselect(Integer[] a, int left, int right, int lowerbound, int upperbound){

        if(left + this.CUTOFF <= right){
            int pivot = median3(a, left, right);

            //begin partitioning
            int i = left, j = right-1;
            for(;;){

                while(a[++i].compareTo(pivot) < 0){

                }
                while(a[--j].compareTo(pivot) > 0){

                }

                if(i<j){
                    swapReferences(a, i, j);
                }else{
                    break;
                }
            }

            swapReferences(a, i, right-1);//restore pivot. i is now index of pivot

            //comparing index of pivot with range.
            if(i < lowerbound){ // range to the right of pivot

                quickselect(a, i+1, right, lowerbound, upperbound);

            }else if( i > upperbound){ // range to left of pivot

                quickselect(a, left, i-1, lowerbound, upperbound);

            }else if(i >= lowerbound && i <= upperbound){ //pivot inside range.

                quickselect(a, i+1, right, lowerbound, upperbound);
                quickselect(a, left, i-1, lowerbound, upperbound);

            }


        }else{
            selectionSort(a, left,right);
        }


    }

    /*Function to sort array using insertion sort*/
   private void selectionSort(Integer[] arr, int left, int right)
    {

        for (int i = left+1; i <= right; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /***
     * @role: finds and returns the required Percentile
     * @param arr - given array
     * @param lower - range
     * @param upper - range
     * @return list of int
     * @complexity: average O(N) since quickselect only takes O(N) on average.
     */
    @Override
    public int[] getPercentileRange(int[] arr, int lower, int upper) {
	// TODO Auto-generated method stub

        //case 1.
        if(arr.length == 1){
            return arr;
        }

        //case 2.
        if(lower == 0 && upper == 100){
            return arr;
        }

        //converting the list from int[] to Integer[] because we need compareTo in quickSelect.
        Integer[] arrToBeSorted = new Integer[arr.length];
        for(int i = 0; i<arr.length; i++){
            arrToBeSorted[i] = arr[i];
        }

        //calculating the right index of the percintile.
        double eachelm = (double)100 / (double)arr.length;

        int lowerindex = (int) (lower / eachelm);

        int upperindex = (int) ((upper / eachelm) - 1);

        quickselect(arrToBeSorted,0, arr.length-1, lowerindex, upperindex); //sorting the range only



        int[] perArray = new int[upperindex - lowerindex + 1];

        for(int i = 0; i<perArray.length; i++){
            perArray[i] = arrToBeSorted[i+lowerindex];
        }
	return perArray;
    }

}
