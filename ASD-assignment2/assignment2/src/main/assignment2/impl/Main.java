package main.assignment2.impl;

import main.assignment2.ArrayMath;

public class Main {
    public static void main(String[] args) {
        /*
        MapEntryImpl[] lol = new MapEntryImpl[10];
        lol[0] = new MapEntryImpl(5,4, true);
        MapEntryImpl a = lol[0];
        System.out.println(a.getValue());
        MapEntryImpl map = lol[0];
        map.setValue(19);
        System.out.println(a.getValue());
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
        System.out.println(mymath.isSameCollection(array1,array2));
        System.out.println(mymath.isSameCollection(array1,array3));
         */

        //testing second method in ex2.
        int[] array1 = { 2, 5, 3, 9 };
        int[] array2 = { 15, 12, 1, 3 };
        ArrayMath mymath = new MyArrayMathImpl();
        System.out.println(mymath.minDifferences(array1, array2)); //expected 86.
    }
}
