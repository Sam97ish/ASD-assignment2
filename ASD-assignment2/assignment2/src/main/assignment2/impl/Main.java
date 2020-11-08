package main.assignment2.impl;

import main.assignment2.ArrayMath;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = { 1, 7, 7,10 };
        int[] array2 = { 1, 7, 10, 10,10 };

        int [] array3 = new int[200];
        MyHashTableImpl hash = new MyHashTableImpl(0.98);
        for( int i = 0; i< 200; i++){
            hash.insert(i,i);
            array3[i] = i+1;
        }
        System.out.println(Arrays.toString(array3));
        MyArrayMathImpl mymath = new MyArrayMathImpl();

        System.out.println(mymath.isSameCollection(array3, array3));

        int arr [] = mymath.getPercentileRange(array3, 0, 20);

        System.out.println(Arrays.toString(arr));
        System.out.println(hash);
        /*
        MyHashTableImpl hash = new MyHashTableImpl(0.98);
        hash.insert(4, 1);
        hash.insert(3, 2);
        //System.out.println(hash);
        hash.insert(2, 15);
        // System.out.println(hash);
        hash.insert(15, 90);
        hash.insert(5, 909);
        hash.insert(26, 2323);
        // System.out.println(hash);
        hash.delete(4);
        //hash.delete(9);
        // System.out.println(hash);
        hash.insert(4, 78);
        hash.insert(60, 600);
        hash.insert(82, 780);
        hash.insert(42, 75558);
        hash.insert(49, 902);
        hash.delete(49);
        System.out.println(hash);
        System.out.println(hash.contains(49));
        */


        /*
        //testing binary heap insertion and deletion.
        BinaryHeap heap = new BinaryHeap(11);
        heap.insert(13);
        heap.insert(21);
        heap.insert(16);
        heap.insert(24);
        heap.insert(31);
        heap.insert(19);
        heap.insert(68);
        heap.printHeap(); //expected 13 21 16 24 31 19 68
        System.out.println("Starting deleteMin");
        for(int i = 0; i < 7; i++){//expected ordered listing of previous input.
            System.out.println(heap.deleteMin());
        }
        */

        /*
        //testing first method in ex2.
        int[] array1 = { 10, 1, 7, 10 };
        int[] array2 = { 1, 10, 7, 10 };
        int[] array3 = { 10, 1, 7, 9 };
        ArrayMath mymath = new MyArrayMathImpl();
        System.out.println(mymath.isSameCollection(array1,array2)); //expecting true.
        System.out.println(mymath.isSameCollection(array1,array3)); //expecting false.
        */

        /*
        //testing second method in ex2.
        int[] array1 = { 2, 5, 3, 9 };
        int[] array2 = { 15, 12, 1, 3 };
        ArrayMath mymath = new MyArrayMathImpl();
        System.out.println(mymath.minDifferences(array1, array2)); //expected 86.
        */

        /*
        //testing third method in ex2.
        ArrayMath mymath = new MyArrayMathImpl();
        int[] example = {20000, 160, -2, 4, 100, 6, 120, 8, 140, 1800};
        int lower = 10;
        int upper = 50;
        int[] answer = mymath.getPercentileRange(example,lower,upper);
        //expected = [4,6,8,100].
        for (int j : answer) {
            System.out.println(j);
        }
        */
    }
}
