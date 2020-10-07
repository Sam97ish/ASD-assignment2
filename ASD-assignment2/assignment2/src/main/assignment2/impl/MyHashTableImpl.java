package main.assignment2.impl;

import main.assignment2.ArrayWithPublishedSize;
import main.assignment2.MyMap;
public class MyHashTableImpl<K, V> implements MyMap<K, V>, ArrayWithPublishedSize {
    private static final int DEFAULT_TABLE_SIZE = 11;
    private MapEntryImpl<K, V>[] array;


    private double MAXIMUM_ALLOWED_LOAD_FACTOR; // This is the load factor that the table can never exceed. However, it
    // may happen that an insertion fails before reaching this load factor.
    // the internal rehash() function should be called when either the load
    // factor is higher than a limit passed as an argument in the
    // constructor of MyHashTable or when an insertion fails (this is, when
    // an insertion does not find an empty cell

    public MyHashTableImpl(double MAX_LOAD_FACTOR) {
        MAXIMUM_ALLOWED_LOAD_FACTOR = MAX_LOAD_FACTOR;
        array = new MapEntryImpl[DEFAULT_TABLE_SIZE];
        // Here you need to create the array. It is not possible to create a new array
        // of generic type in Java. You can use any of the methods to simulate the
        // generic-like array; this assignment does not restrict the method to use for that.
    }

    private static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1) return false;
        if (n <= 3) return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    // Function to return the smallest
    // prime number greater than N
    private static int nextPrime(int N)
    {

        // Base case
        if (N <= 1)
            return 2;

        int prime = N;
        boolean found = false;

        // Loop continuously until isPrime returns
        // true for a number greater than n
        while (!found)
        {
            prime++;

            if (isPrime(prime))
                found = true;
        }

        return prime;
    }

    private int myhash(K x) {
        int hashVal = x.hashCode();

        hashVal %= array.length;
        if(hashVal < 0){
            hashVal += array.length;
        }
        return hashVal;
    }

    @Override
    public int getLengthOfArray() {
        return array.length;
    }

    @Override
    public void insert(K key, V value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(K key) {
        // TODO Auto-generated method stub

    }

    @Override
    public V contains(K key) {
        // TODO Auto-generated method stub
        return null;
    }

}

