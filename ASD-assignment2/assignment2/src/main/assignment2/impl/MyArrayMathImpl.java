package main.assignment2.impl;

import main.assignment2.*;

public class MyArrayMathImpl implements ArrayMath {

    /**
     * @complexity: average O(N), worst-case O(NLogN).
     * @param array1
     * @param array2
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

        MyHashTableImpl<Integer,Integer> hash1 = new MyHashTableImpl(0.5);
        MyHashTableImpl<Integer,Integer> hash2 = new MyHashTableImpl(0.5);

        for(int i = 0; i < size1; i++){// insert is average case O(1) * N (size of array).
            hash1.insert(array1[i], array1[i]);
            hash2.insert(array2[i], array2[i]);
        }

        boolean same = true;
        System.out.println(hash1);
        System.out.println(hash2);
        for(int i = 0; i < size1 & same; i++){ // contains is average time O(1) * N (size of array).

            Integer value1 = hash1.contains(array2[i]);
            Integer value2 = hash2.contains(array2[i]);

            if(value1 == null || value2 == null){
                same = false;
            }else{
                same = value1.equals(value2);
            }

        }

        return same;
    }

    /**
     * @complexity: worse-case O(NlogN)
     * @param array1
     * @param array2
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
     * @param a
     * @param first
     * @param sec
     */
    private void swapReferences(Integer[] a, int first, int sec){
        Integer tmp = a[first];
        a[first] = sec;
        a[sec] = tmp;
    }

    /***
     * @role: orders the left right and median and hides the pivot.
     * @param a
     * @param left
     * @param right
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

    private void quickselect(int[] a, int left, int right, int lowerbound, int upperbound){

        if(left + CUTOFF <= right){
            int pivot = median3(a, left, right);

            //begin partitioning
            int i = left, j = right-1;


        }


    }

    /*Function to sort array using insertion sort*/
    void selectionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
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

        quickselect(arr,0, arr.length-1, lower, upper); //sorting the range only

        //calculating the right index of the percintile.
        int eachelm = 100 / arr.length;

        int lowerindex = lower / eachelm;

        int upperindex = upper / eachelm;

        int[] perArray = new int[upperindex - lowerindex + 1];

        for(int i = 0; i<perArray.length; i++){
            perArray[i] = arr[i+lowerindex];
        }

	return perArray;
    }

}
