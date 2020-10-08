package main.assignment2.impl;

import java.nio.BufferUnderflowException;

public class BinaryHeap {
    private Integer arr[];
    private int currentsize;

    BinaryHeap(int size){
        arr = new Integer[size];
        this.currentsize = 0;
    }

    public void insert(Integer x){

        if(currentsize == arr.length -1){
            //enlarge
            enlargeArray(arr.length *2 + 1);
        }

        //percolate up.
        int hole = ++currentsize;
        for(arr[0] = x; x.compareTo(arr[ hole/2 ]) < 0; hole /=2){
            arr[hole] = arr[hole/2];
        }
        arr[hole] = x;
    }
    private void enlargeArray(int nm){
        Integer tmp[] = new Integer[nm];
        for(int i =1; i <= currentsize; i++){
            tmp[i] = arr[i];
        }

        arr = tmp;
    }

    public int get(int i){
        return arr[i];
    }

    public void printHeap(){

        for(int i =1; i <= currentsize; i++){
            System.out.println(arr[i] + " ");
        }

    }

    private int findMin(){
        return arr[1];
    }
    private boolean isEmpty(){
        return currentsize == 0;
    }

    private void percolateDown(int hole){
        int child;
        int tmp = arr[hole];
        for(; hole*2 <= currentsize; hole = child){
            child = hole * 2;
            if(child != currentsize && arr[child+1].compareTo(arr[child]) < 0){
                child++;
            }
            if(arr[child].compareTo(tmp) < 0){
                arr[hole] = arr[child];
            }else {
                break;
            }
        }
        arr[hole] = tmp;
    }
    public int deleteMin(){
        if(isEmpty()){
            throw new BufferUnderflowException();
        }

        int minitem = findMin();

        arr[1]= arr[currentsize--];

        percolateDown(1);

        return minitem;
    }
}
