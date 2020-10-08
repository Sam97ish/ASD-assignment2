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

    if(size1 != size2){ //if not the same size return false immediately.
        return false;
    }

    BinaryHeap heap1 = new BinaryHeap(size1+1);
    BinaryHeap heap2 = new BinaryHeap(size2+1);
    boolean same = true;
    for(int i = 0; i < size1; i++){
        // average of insertion in heap is O(1) * N = O(N) average. Worst is O(LogN),
        //which leads to O(NLogN) worst case.
        heap1.insert(array1[i]);
        heap2.insert(array2[i]);

    }

    for(int i = 1; i<=size1 && same; i++){// O(N)
        same = heap1.get(i) == heap2.get(i);
    }



	return same;
    }

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
        for(int i = 0; i< size1; i++){// worst case O(NLogN) because deleteMin is O(LogN).
            int first= heap1.deleteMin();
            int second = heap2.deleteMin();
            int both = first - second;
            both *= both;
            sum += both;
        }
	return sum;
    }

    @Override
    public int[] getPercentileRange(int[] arr, int lower, int upper) {
	// TODO Auto-generated method stub
	return null;
    }

}
